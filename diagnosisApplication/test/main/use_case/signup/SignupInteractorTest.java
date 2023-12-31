package main.use_case.signup;

import main.data_access.FileUserDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.signup.SignupController;
import main.interface_adapter.signup.SignupPresenter;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SignupInteractorTest {
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    SignupViewModel signupViewModel = new SignupViewModel();
    LoginViewModel loginViewModel = new LoginViewModel();
    SymptomCheckerViewModel symptomCheckerViewModel = new SymptomCheckerViewModel();
    SignupOutputBoundary presenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel, symptomCheckerViewModel);
    UserFactory userFactory = new CommonUserFactory();
    SignupUserDataAccessInterface signupDAO = new FileUserDataAccessObject("./users.csv", userFactory);
    SignupInputBoundary interactor = new SignupInteractor(signupDAO, presenter, userFactory);
    SignupController controller = new SignupController(interactor);

    public SignupInteractorTest() throws IOException {
    }

    @Test
    public void execute() {
        SignupInputData data = new SignupInputData("user", "password", "password", "male", 2000);
        interactor.execute(data);
    }

    @Test
    public void passwordNoMatch() {
        SignupInputData data = new SignupInputData("newUser", "password",
                "wrongPassword", "male", 2000);
        interactor.execute(data);
    }

    @Test
    public void switchLogin() {
        interactor.switchLogin();
    }
}
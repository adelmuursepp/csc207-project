package main.interface_adapter.signup;

import main.data_access.FileUserDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.signup.SignupInputBoundary;
import main.use_case.signup.SignupInteractor;
import main.use_case.signup.SignupOutputBoundary;
import main.use_case.signup.SignupUserDataAccessInterface;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SignupControllerTest {
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    SignupViewModel signupViewModel = new SignupViewModel();
    LoginViewModel loginViewModel = new LoginViewModel();
    SymptomCheckerViewModel symptomCheckerViewModel = new SymptomCheckerViewModel();
    SignupOutputBoundary presenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel, symptomCheckerViewModel);
    UserFactory userFactory = new CommonUserFactory();
    SignupUserDataAccessInterface signupDAO = new FileUserDataAccessObject("./users.csv", userFactory);
    SignupInputBoundary interactor = new SignupInteractor(signupDAO, presenter, userFactory);
    SignupController controller = new SignupController(interactor);

    public SignupControllerTest() throws IOException {
    }

    @Test
    public void execute() {
        controller.execute("username", "password", "password", "male", 2000);
    }

    @Test
    public void switchLogin() {
        controller.switchLogin();
    }
}
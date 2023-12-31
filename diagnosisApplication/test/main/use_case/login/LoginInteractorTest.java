package main.use_case.login;

import main.data_access.FileUserDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.login.LoginController;
import main.interface_adapter.login.LoginPresenter;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class LoginInteractorTest {
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    SymptomCheckerViewModel symptomCheckerViewModel = new SymptomCheckerViewModel();
    LoginViewModel viewModel = new LoginViewModel();
    SignupViewModel signupViewModel= new SignupViewModel();
    LoginOutputBoundary presenter = new LoginPresenter(viewManagerModel, symptomCheckerViewModel, viewModel, signupViewModel);
    UserFactory userFactory = new CommonUserFactory();
    LoginUserDataAccessInterface loginDAO = new FileUserDataAccessObject("./users.csv", userFactory);
    LoginInputBoundary interactor = new LoginInteractor(loginDAO, presenter);
    LoginController controller = new LoginController(interactor);

    public LoginInteractorTest() throws IOException {
    }

    @Test
    public void execute() {
        LoginInputData data = new LoginInputData("username", "password");
        interactor.execute(data);
    }

    @Test
    public void userNoExist() {
        LoginInputData data = new LoginInputData("wrongUsername", "password");
        interactor.execute(data);
    }

    @Test
    public void wrongPassword() {
        LoginInputData data = new LoginInputData("username", "wrongPassword");
        interactor.execute(data);
    }

    @Test
    public void switchSignUp() {
        interactor.switchSignUp();
    }
}
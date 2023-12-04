package main.interface_adapter.login;

import main.data_access.FileUserDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.login.LoginInputBoundary;
import main.use_case.login.LoginInteractor;
import main.use_case.login.LoginOutputBoundary;
import main.use_case.login.LoginUserDataAccessInterface;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class LoginControllerTest {
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    SymptomCheckerViewModel symptomCheckerViewModel = new SymptomCheckerViewModel();
    LoginViewModel viewModel = new LoginViewModel();
    SignupViewModel signupViewModel= new SignupViewModel();
    LoginOutputBoundary presenter = new LoginPresenter(viewManagerModel, symptomCheckerViewModel, viewModel, signupViewModel);
    UserFactory userFactory = new CommonUserFactory();
    LoginUserDataAccessInterface loginDAO = new FileUserDataAccessObject("./users.csv", userFactory);
    LoginInputBoundary interactor = new LoginInteractor(loginDAO, presenter);
    LoginController controller = new LoginController(interactor);

    public LoginControllerTest() throws IOException {
    }

    @Test
    public void execute() {
        controller.execute("username", "password");
    }

    @Test
    public void switchSignUp() {
        controller.switchSignUp();
    }
}
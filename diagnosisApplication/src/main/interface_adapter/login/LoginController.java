package main.interface_adapter.login;

import main.use_case.login.LoginInputData;
import main.use_case.login.LoginInputBoundary;
import main.use_case.signup.SignupInputBoundary;
import main.use_case.signup.SignupInputData;

public class LoginController {

    final LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }


    public void execute(String username, String password) {
        LoginInputData loginInputData = new LoginInputData(
                username, password);

        loginUseCaseInteractor.execute(loginInputData);
    }
}

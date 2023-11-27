package diagnosisApplication.src.main.interface_adapter.login;

import diagnosisApplication.src.main.use_case.login.LoginInputData;
import diagnosisApplication.src.main.use_case.login.LoginInputBoundary;
import diagnosisApplication.src.main.use_case.signup.SignupInputBoundary;
import diagnosisApplication.src.main.use_case.signup.SignupInputData;

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

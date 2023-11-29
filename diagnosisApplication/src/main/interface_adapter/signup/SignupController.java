package main.interface_adapter.signup;

import main.use_case.signup.SignupInputBoundary;
import main.use_case.signup.SignupInputData;
import main.use_case.signup.SignupInputBoundary;

public class SignupController {

    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2, String sex, Integer yearOfBirth) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2, sex, yearOfBirth);

        userSignupUseCaseInteractor.execute(signupInputData);
    }

}

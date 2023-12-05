package main.interface_adapter.signup;

import main.use_case.signup.SignupInputBoundary;
import main.use_case.signup.SignupInputData;
import main.use_case.signup.SignupInputBoundary;

public class SignupController {

    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Packages sign up fields username, passwords, sex, and yearOfBirth into
     * SignupInputData to be sent from the use case to the data access to be saved in the csv.
     *
     * @param username
     * @param password1
     * @param password2
     * @param sex
     * @param yearOfBirth
     */
    public void execute(String username, String password1, String password2, String sex, Integer yearOfBirth) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2, sex, yearOfBirth);

        userSignupUseCaseInteractor.execute(signupInputData);
    }

    /**
     * Uses the use case interactor to switch the active view from the SignupView to the LoginView
     *
     */
    public void switchLogin() {
        userSignupUseCaseInteractor.switchLogin();
    }

}

package diagnosisApplication.src.main.interface_adapter.signup;

import diagnosisApplication.src.main.use_case.signup.SignupInputBoundary;
import diagnosisApplication.src.main.use_case.signup.SignupInputData;
import diagnosisApplication.src.main.use_case.signup.SignupInputBoundary;

public class SignupController {

    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}

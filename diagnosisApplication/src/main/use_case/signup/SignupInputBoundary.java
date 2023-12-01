package main.use_case.signup;

public interface SignupInputBoundary {
    void execute(SignupInputData signupInputData);

    void switchLogin();

    void switchGlossary();
}

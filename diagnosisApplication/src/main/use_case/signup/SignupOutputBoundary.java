package main.use_case.signup;

public interface SignupOutputBoundary {
    void prepareSuccessView(SignupOutputData user);

    void prepareFailView(String error);

    void prepareLoginView();

    void prepareGlossaryView();
}
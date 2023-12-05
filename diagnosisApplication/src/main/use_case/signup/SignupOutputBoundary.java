package main.use_case.signup;

public interface SignupOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);

    void prepareLoginView();
}
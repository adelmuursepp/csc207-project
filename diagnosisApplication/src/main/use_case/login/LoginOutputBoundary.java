package diagnosisApplication.src.main.use_case.login;


public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData user);

    void prepareFailView(String error);
}
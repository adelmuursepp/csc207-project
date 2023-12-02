package main.interface_adapter.login;

import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerState;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.login.LoginOutputBoundary;
import main.use_case.login.LoginOutputData;


public class LoginPresenter implements LoginOutputBoundary {

    private final SymptomCheckerViewModel symptomCheckerViewModel;
    private final LoginViewModel loginViewModel;

    private final SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          SymptomCheckerViewModel symptomCheckerViewModel,
                          LoginViewModel loginViewModel,
                          SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.symptomCheckerViewModel = symptomCheckerViewModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {

        SymptomCheckerState symptomCheckerState = symptomCheckerViewModel.getState();
        this.symptomCheckerViewModel.setState(symptomCheckerState);
        this.symptomCheckerViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(symptomCheckerViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSignUpView() {
        viewManagerModel.setActiveView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

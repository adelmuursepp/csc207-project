package main.interface_adapter.login;

import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.logged_in.LoggedInState;
import main.interface_adapter.logged_in.LoggedInViewModel;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.signup.SignupState;
import main.interface_adapter.symptom_checker.SymptomCheckerState;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.login.LoginOutputBoundary;
import main.use_case.login.LoginOutputData;
import main.use_case.signup.SignupOutputBoundary;
import main.use_case.signup.SignupOutputData;


public class LoginPresenter implements LoginOutputBoundary {

    private final SymptomCheckerViewModel symptomCheckerViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          SymptomCheckerViewModel symptomCheckerViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.symptomCheckerViewModel = symptomCheckerViewModel;
        this.loginViewModel = loginViewModel;
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
}

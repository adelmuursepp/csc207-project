package main.interface_adapter.signup;

import main.interface_adapter.login.LoginState;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.ViewManagerModel;
import main.use_case.signup.SignupOutputBoundary;
import main.use_case.signup.SignupOutputData;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignupPresenter implements SignupOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private final SymptomCheckerViewModel symptomCheckerViewModel;
    private ViewManagerModel viewManagerModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel, SymptomCheckerViewModel symptomCheckerViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
        this.symptomCheckerViewModel = symptomCheckerViewModel;
    }

    /**
     * Triggers the viewManagerModel to change the active view from the SignupView to
     * the SymptomCheckerView when sign up is successful.
     *
     */
    @Override
    public void prepareSuccessView() {

        viewManagerModel.setActiveView(symptomCheckerViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Set up the error in the SignupState to present an error when the sign up encounters an error.
     * @param error an error state for the SignupState to return an error
     */
    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

    /**
     * Uses the viewManagerModel to switch the current view from the SignupView to the
     * LoginView
     *
     */
    public void prepareLoginView() {
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}

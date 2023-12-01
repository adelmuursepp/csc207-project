package main.interface_adapter.signup;

import main.interface_adapter.glossary.GlossaryViewModel;
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
    private final GlossaryViewModel glossaryViewModel;
    private final SymptomCheckerViewModel symptomCheckerViewModel;
    private ViewManagerModel viewManagerModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel, SymptomCheckerViewModel symptomCheckerViewModel,
                           GlossaryViewModel glossaryViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
        this.symptomCheckerViewModel = symptomCheckerViewModel;
        this.glossaryViewModel = glossaryViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData response) {
        // On success, switch to the login view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(symptomCheckerViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

    public void prepareLoginView() {
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void prepareGlossaryView() {
        viewManagerModel.setActiveView(glossaryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}

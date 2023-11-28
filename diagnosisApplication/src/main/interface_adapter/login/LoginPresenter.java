package diagnosisApplication.src.main.interface_adapter.login;
import diagnosisApplication.src.main.interface_adapter.logged_in.LoggedInState;
import diagnosisApplication.src.main.interface_adapter.logged_in.LoggedInViewModel;
import diagnosisApplication.src.main.interface_adapter.ViewManagerModel;
import diagnosisApplication.src.main.interface_adapter.signup.SignupState;
import diagnosisApplication.src.main.use_case.login.LoginOutputBoundary;
import diagnosisApplication.src.main.use_case.login.LoginOutputData;
import diagnosisApplication.src.main.use_case.signup.SignupOutputBoundary;
import diagnosisApplication.src.main.use_case.signup.SignupOutputData;


public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;

    //private final SymptomCheckerViewModel symptomCheckerViewModel;
    //private ViewManagerModel viewManagerModel;

    //public LoginPresenter(ViewManagerModel viewManagerModel,
                          //SymptomCheckerViewModel symptomCheckerViewModel,
                          //LoginViewModel loginViewModel) {
        //this.viewManagerModel = viewManagerModel;
        //this.symptomCheckerViewModel = symptomCheckerViewModel;
      //?
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {

        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());

        // On success, switch to the logged in view.

        //SymptomCheckerState symptomCheckerState = symptomCheckerViewModel.getState();
        //this.symptomCheckerViewModel.setState(symptomCheckerState);
        //this.symptomCheckerViewModel.firePropertyChanged();

        //this.viewManagerModel.setActiveView(symptomCheckerViewModel.getViewName());
      //?
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}

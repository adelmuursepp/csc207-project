
package diagnosisApplication.src.main.app;

import diagnosisApplication.src.main.entity.CommonUserFactory;
import diagnosisApplication.src.main.entity.UserFactory;
import diagnosisApplication.src.main.interface_adapter.ViewManagerModel;
import diagnosisApplication.src.main.interface_adapter.logged_in.LoggedInViewModel;
import diagnosisApplication.src.main.interface_adapter.login.LoginController;
import diagnosisApplication.src.main.interface_adapter.login.LoginPresenter;
import diagnosisApplication.src.main.interface_adapter.login.LoginViewModel;
import diagnosisApplication.src.main.use_case.login.LoginInputBoundary;
import diagnosisApplication.src.main.use_case.login.LoginOutputBoundary;
import diagnosisApplication.src.main.use_case.login.LoginInteractor;
import diagnosisApplication.src.main.use_case.login.LoginUserDataAccessInterface;
import diagnosisApplication.src.main.view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {

    private LoginUseCaseFactory() {}

    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
      //SymptomCheckerViewModel symptomCheckerViewModel?
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        try {
            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);

            
            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            //SymptomCheckerViewModel symptomCheckerViewModel
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) throws IOException {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);


        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}

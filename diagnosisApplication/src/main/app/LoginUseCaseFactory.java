
package main.app;

import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.login.LoginController;
import main.interface_adapter.login.LoginPresenter;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.login.LoginInputBoundary;
import main.use_case.login.LoginOutputBoundary;
import main.use_case.login.LoginInteractor;
import main.use_case.login.LoginUserDataAccessInterface;
import main.view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {

    private LoginUseCaseFactory() {}

    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            //SymptomCheckerViewModel symptomCheckerViewModel?
            SymptomCheckerViewModel symptomCheckerViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        try {
            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, symptomCheckerViewModel, userDataAccessObject);

            
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
            SymptomCheckerViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) throws IOException {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);


        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}

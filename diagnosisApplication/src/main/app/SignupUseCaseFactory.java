package main.app;

import main.data_access.FileUserDataAccessObject;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.signup.SignupController;
import main.interface_adapter.signup.SignupPresenter;
import main.interface_adapter.signup.SignupViewModel;
import main.use_case.signup.SignupUserDataAccessInterface;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.*;
import main.use_case.signup.SignupInputBoundary;
import main.use_case.signup.SignupInteractor;
import main.use_case.signup.SignupOutputBoundary;
import main.view.SignupView;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel,
            SignupUserDataAccessInterface userDataAccessObject) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel,
                                                            SignupViewModel signupViewModel,
                                                            LoginViewModel loginViewModel,
                                                            SignupUserDataAccessInterface userDataAccessObject)
            throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }

}

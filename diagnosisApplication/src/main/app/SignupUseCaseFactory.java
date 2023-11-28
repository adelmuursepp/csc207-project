package diagnosisApplication.src.main.app;

import diagnosisApplication.src.main.data_access.FileUserDataAccessObject;
import diagnosisApplication.src.main.interface_adapter.login.LoginViewModel;
import diagnosisApplication.src.main.interface_adapter.signup.SignupController;
import diagnosisApplication.src.main.interface_adapter.signup.SignupPresenter;
import diagnosisApplication.src.main.interface_adapter.signup.SignupViewModel;
import diagnosisApplication.src.main.use_case.signup.SignupUserDataAccessInterface;
import diagnosisApplication.src.main.entity.CommonUserFactory;
import diagnosisApplication.src.main.entity.UserFactory;
import diagnosisApplication.src.main.interface_adapter.ViewManagerModel;
import diagnosisApplication.src.main.interface_adapter.login.LoginViewModel;
import diagnosisApplication.src.main.interface_adapter.*;
import diagnosisApplication.src.main.use_case.signup.SignupInputBoundary;
import diagnosisApplication.src.main.use_case.signup.SignupInteractor;
import diagnosisApplication.src.main.use_case.signup.SignupOutputBoundary;
import diagnosisApplication.src.main.view.SignupView;

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

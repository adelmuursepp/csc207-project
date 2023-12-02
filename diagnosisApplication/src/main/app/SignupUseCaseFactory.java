package main.app;

import main.interface_adapter.glossary_search.GlossarySearchViewModel;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.signup.SignupController;
import main.interface_adapter.signup.SignupPresenter;
import main.interface_adapter.signup.SignupViewModel;
import main.use_case.signup.SignupUserDataAccessInterface;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.use_case.signup.SignupInputBoundary;
import main.use_case.signup.SignupInteractor;
import main.use_case.signup.SignupOutputBoundary;
import main.view.SignupView;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel,
            SymptomCheckerViewModel symptomCheckerViewModel,
            GlossarySearchViewModel glossarySearchViewModel,
            SignupUserDataAccessInterface userDataAccessObject) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel,
                    loginViewModel, symptomCheckerViewModel, glossarySearchViewModel, userDataAccessObject);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel,
                                                            SignupViewModel signupViewModel,
                                                            LoginViewModel loginViewModel,
                                                            SymptomCheckerViewModel symptomCheckerViewModel,
                                                            GlossarySearchViewModel glossarySearchViewModel,
                                                            SignupUserDataAccessInterface userDataAccessObject)
            throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel,
                loginViewModel, symptomCheckerViewModel, glossarySearchViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }

}

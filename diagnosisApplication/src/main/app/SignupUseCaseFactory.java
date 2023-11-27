package main.app;

import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.signup.SignupViewModel;
import main.use_case.signup.SignupUserDataAccessInterface;
import main.view.SignupView;
import main.interface_adapter.signup.SignupController
public class SignupUseCaseFactory {

    private SignupUseCaseFactory() {}

    public static SignupView create(
        ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel,
        SignupUserDataAccessInterface userDataAccessObject) {

        try{
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel,
                    loginViewModel, userDataAccessObject);
            return new SignupView(signupController, signupViewModel);
        }
    }

}

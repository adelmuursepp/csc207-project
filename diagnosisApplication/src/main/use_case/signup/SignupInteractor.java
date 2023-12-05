package main.use_case.signup;

import main.entity.User;
import main.entity.UserFactory;

import java.time.LocalDateTime;

public class SignupInteractor implements SignupInputBoundary {
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
    }

    /**
     *Checks if the username is unique and if the password and repeat password match in the sign up fields
     * and if both conditions are met, take the current time and uses the
     * UserFactory to create a new user with attributes given in the sign up fields
     * and saved to the csv, then calls the presenter to move onto the SymptomCheckerView.
     * @param signupInputData the package of the information contained in the fields of the sign up view to be saved
     *                        as user attributes.
     */
    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword(),
                    signupInputData.getSex(), signupInputData.getYearOfBirth(), now);
            userDataAccessObject.save(user);
            userDataAccessObject.setCurrentUser(signupInputData.getUsername());

            userPresenter.prepareSuccessView();
        }
    }

    /**
     * Calls the presenter to change the active view from SignupView to the LoginView.
     *
     */
    public void switchLogin() {
        userPresenter.prepareLoginView();
    }
}
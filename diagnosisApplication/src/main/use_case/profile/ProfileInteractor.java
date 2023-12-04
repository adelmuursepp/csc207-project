package main.use_case.profile;

import main.use_case.login.LoginOutputBoundary;
import main.entity.User;

import java.time.LocalDateTime;

public class ProfileInteractor implements ProfileInputBoundary {
    final ProfileUserDataAccessInterface userDataAccessObject;
    final ProfileOutputBoundary profilePresenter;

    public ProfileInteractor(ProfileUserDataAccessInterface userDataAccessInterface,
                             ProfileOutputBoundary profileOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.profilePresenter = profileOutputBoundary;
    }

    public void execute() {
        // Get the current user info to display in the profile view
        String currUsername = userDataAccessObject.getCurrentUser();
        User currUser = userDataAccessObject.get(currUsername);
        String currUserPassword = currUser.getPassword();
        String currUserSex = currUser.getSex();
        Integer currUserYearOfBirth = currUser.getYearOfBirth();
        LocalDateTime currUserCreationTime = currUser.getCreationTime();

        ProfileOutputData profileOutputData = new ProfileOutputData(currUsername, currUserPassword, currUserSex,
                currUserYearOfBirth, currUserCreationTime);
        profilePresenter.prepareProfileView(profileOutputData);
    }
}

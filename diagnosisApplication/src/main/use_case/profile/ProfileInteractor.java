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
        System.out.println("Curr username");
        System.out.println(currUsername);
        User currUser = userDataAccessObject.get(currUsername);
        String currUserSex = currUser.getSex();
        Integer currUserYearOfBirth = currUser.getYearOfBirth();
        LocalDateTime currUserCreationTime = currUser.getCreationTime();

        ProfileOutputData profileOutputData = new ProfileOutputData(currUsername, currUserSex, currUserYearOfBirth, currUserCreationTime);
        profilePresenter.prepareProfileView(profileOutputData);
    }
}

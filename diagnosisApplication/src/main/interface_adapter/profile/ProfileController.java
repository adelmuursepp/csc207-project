package main.interface_adapter.profile;

import main.use_case.profile.ProfileInputBoundary;

public class ProfileController {
    final ProfileInputBoundary profileUseCaseInteractor;

    public ProfileController(ProfileInputBoundary profileUseCaseInteractor) {
        this.profileUseCaseInteractor = profileUseCaseInteractor;
    }

    public void execute() {
        profileUseCaseInteractor.execute();
    }
}

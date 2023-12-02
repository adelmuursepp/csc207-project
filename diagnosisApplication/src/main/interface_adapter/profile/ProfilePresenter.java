package main.interface_adapter.profile;

import main.interface_adapter.ViewManagerModel;
import main.use_case.profile.ProfileOutputBoundary;
import main.use_case.profile.ProfileOutputData;

public class ProfilePresenter implements ProfileOutputBoundary {
    private ProfileViewModel profileViewModel;
    private ViewManagerModel viewManagerModel;
    public ProfilePresenter(ViewManagerModel viewManagerModel,
                            ProfileViewModel profileViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.profileViewModel = profileViewModel;
    }

    public void prepareProfileView(ProfileOutputData profileOutputData) {
        ProfileState profileState = profileViewModel.getState();
        profileState.setUsername(profileOutputData.getUsername());
        profileState.setUserSex(profileOutputData.getUserSex());
        profileState.setUserYearOfBirth(profileOutputData.getUserYearOfBirth());
        profileState.setUserCreationTime(profileOutputData.getUserCreationTime());
        profileViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(profileViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

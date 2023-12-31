package main.use_case.profile;

import main.data_access.FileUserDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.profile.ProfileController;
import main.interface_adapter.profile.ProfilePresenter;
import main.interface_adapter.profile.ProfileViewModel;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ProfileInteractorTest {
    UserFactory userFactory = new CommonUserFactory();
    ProfileUserDataAccessInterface dao = new FileUserDataAccessObject("./users.csv", userFactory);
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    ProfileViewModel viewModel = new ProfileViewModel();
    ProfileOutputBoundary presenter = new ProfilePresenter(viewManagerModel, viewModel);
    ProfileInputBoundary interactor = new ProfileInteractor(dao, presenter);

    public ProfileInteractorTest() throws IOException {
    }

    @Test
    public void execute() {
        dao.setCurrentUser("username");
        interactor.execute();
    }
}
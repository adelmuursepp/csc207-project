package main.interface_adapter.profile;

import main.data_access.FileUserDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.use_case.profile.ProfileInputBoundary;
import main.use_case.profile.ProfileInteractor;
import main.use_case.profile.ProfileOutputBoundary;
import main.use_case.profile.ProfileUserDataAccessInterface;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ProfileControllerTest {
    UserFactory userFactory = new CommonUserFactory();
    ProfileUserDataAccessInterface dao = new FileUserDataAccessObject("./users.csv", userFactory);
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    ProfileViewModel viewModel = new ProfileViewModel();
    ProfileOutputBoundary presenter = new ProfilePresenter(viewManagerModel, viewModel);
    ProfileInputBoundary interactor = new ProfileInteractor(dao, presenter);
    ProfileController controller = new ProfileController(interactor);

    public ProfileControllerTest() throws IOException {
    }

    @Test
    public void execute() {
        dao.setCurrentUser("username");
        controller.execute();
    }
}
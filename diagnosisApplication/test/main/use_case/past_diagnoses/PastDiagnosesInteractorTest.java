package main.use_case.past_diagnoses;

import main.data_access.FileDiagnosisDataAccessObject;
import main.data_access.FileUserDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.past_diagnoses.PastDiagnosesController;
import main.interface_adapter.past_diagnoses.PastDiagnosesPresenter;
import main.interface_adapter.past_diagnoses.PastDiagnosesViewModel;
import main.use_case.diagnosis.DiagnosisFileDataAccessInterface;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PastDiagnosesInteractorTest {
    PastDiagnosesViewModel viewModel = new PastDiagnosesViewModel();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    PastDiagnosesOutputBoundary presenter = new PastDiagnosesPresenter(viewModel, viewManagerModel);
    UserFactory userFactory = new CommonUserFactory();
    FileUserDataAccessObject fudao = new FileUserDataAccessObject("./users.csv", userFactory);
    DiagnosisFileDataAccessInterface dao = new FileDiagnosisDataAccessObject("./diagnoses.csv", fudao);
    PastDiagnosesInputBoundary interactor = new PastDiagnosesInteractor(presenter, dao);
    PastDiagnosesController controller = new PastDiagnosesController(interactor);

    public PastDiagnosesInteractorTest() throws IOException {
    }

    @Test
    public void execute() {
        fudao.setCurrentUser("username");
        interactor.execute();
    }
}
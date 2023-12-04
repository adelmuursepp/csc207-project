package main.interface_adapter.past_diagnoses;

import main.data_access.FileDiagnosisDataAccessObject;
import main.data_access.FileUserDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.use_case.diagnosis.DiagnosisFileDataAccessInterface;
import main.use_case.past_diagnoses.PastDiagnosesInputBoundary;
import main.use_case.past_diagnoses.PastDiagnosesInteractor;
import main.use_case.past_diagnoses.PastDiagnosesOutputBoundary;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PastDiagnosesControllerTest {
    PastDiagnosesViewModel viewModel = new PastDiagnosesViewModel();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    PastDiagnosesOutputBoundary presenter = new PastDiagnosesPresenter(viewModel, viewManagerModel);
    UserFactory userFactory = new CommonUserFactory();
    FileUserDataAccessObject fudao = new FileUserDataAccessObject("./users.csv", userFactory);
    DiagnosisFileDataAccessInterface dao = new FileDiagnosisDataAccessObject("./diagnoses.csv", fudao);
    PastDiagnosesInputBoundary interactor = new PastDiagnosesInteractor(presenter, dao);
    PastDiagnosesController controller = new PastDiagnosesController(interactor);

    public PastDiagnosesControllerTest() throws IOException {
    }

    @Test
    public void execute() {
        controller.execute();
    }
}
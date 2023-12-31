package main.use_case.diagnosis;

import main.data_access.FileDiagnosisDataAccessObject;
import main.data_access.FileUserDataAccessObject;
import main.data_access.MedicAPIDiagnosisDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.diagnosis.DiagnosisController;
import main.interface_adapter.diagnosis.DiagnosisPresenter;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DiagnosisInteractorTest {
    DiagnosisViewModel viewModel = new DiagnosisViewModel();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    DiagnosisOutputBoundary presenter = new DiagnosisPresenter(viewModel, viewManagerModel);
    DiagnosisUserDataAccessInterface userDAO = new MedicAPIDiagnosisDataAccessObject();
    UserFactory userFactory = new CommonUserFactory();
    FileUserDataAccessObject fileUserDAO = new FileUserDataAccessObject("./users.csv", userFactory);
    DiagnosisFileDataAccessInterface fileDAO = new FileDiagnosisDataAccessObject("./diagnoses.csv", fileUserDAO);
    DiagnosisInteractor interactor = new DiagnosisInteractor(presenter, userDAO, fileDAO);
    DiagnosisController controller = new DiagnosisController(interactor);
    ArrayList<Integer> symptoms = new ArrayList<>();

    public DiagnosisInteractorTest() throws IOException {
    }

    @Test
    public void execute() {
        fileUserDAO.setCurrentUser("username");
        symptoms.add(207);
        symptoms.add(11);
        symptoms.add(9);
        controller.execute(symptoms);
    }
}
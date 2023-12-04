package main.interface_adapter.diagnosis;

import main.app.MainTest;
import main.app.SymptomCheckerUseCaseFactory;
import main.data_access.FileDiagnosisDataAccessObject;
import main.data_access.FileUserDataAccessObject;
import main.data_access.MedicAPIDiagnosisDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.use_case.diagnosis.DiagnosisFileDataAccessInterface;
import main.use_case.diagnosis.DiagnosisInteractor;
import main.use_case.diagnosis.DiagnosisOutputBoundary;
import main.use_case.diagnosis.DiagnosisUserDataAccessInterface;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DiagnosisControllerTest {
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

    public DiagnosisControllerTest() throws IOException {
    }

    @Test
    public void execute3Diagnoses(){
        fileUserDAO.setCurrentUser("username");
        symptoms.add(207);
        symptoms.add(11);
        symptoms.add(9);
        controller.execute(symptoms);
    }

    // Please add tests for 2, 1, and 0 diagnoses
}
package main.interface_adapter.proposed_symptoms;

import main.data_access.MedicAPIDiagnosisDataAccessObject;
import main.interface_adapter.ViewManagerModel;
import main.use_case.proposed_symptoms.ProposedSymptomsAPIDataAccessInterface;
import main.use_case.proposed_symptoms.ProposedSymptomsInputBoundary;
import main.use_case.proposed_symptoms.ProposedSymptomsInteractor;
import main.use_case.proposed_symptoms.ProposedSymptomsOutputBoundary;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProposedSymptomsControllerTest {
    ProposedSymptomsViewModel viewModel = new ProposedSymptomsViewModel();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    ProposedSymptomsOutputBoundary presenter = new ProposedSymptomsPresenter(viewModel, viewManagerModel);
    ProposedSymptomsAPIDataAccessInterface dao = new MedicAPIDiagnosisDataAccessObject();
    ProposedSymptomsInputBoundary interactor = new ProposedSymptomsInteractor(presenter, dao);
    ProposedSymptomsController controller = new ProposedSymptomsController(interactor);

    @Test
    public void execute() {
        controller.execute(new ArrayList<Integer>());
    }
}
package main.use_case.proposed_symptoms;

import main.data_access.MedicAPIDiagnosisDataAccessObject;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsController;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsPresenter;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsViewModel;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProposedSymptomsInteractorTest {
    ProposedSymptomsViewModel viewModel = new ProposedSymptomsViewModel();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    ProposedSymptomsOutputBoundary presenter = new ProposedSymptomsPresenter(viewModel, viewManagerModel);
    ProposedSymptomsAPIDataAccessInterface dao = new MedicAPIDiagnosisDataAccessObject();
    ProposedSymptomsInputBoundary interactor = new ProposedSymptomsInteractor(presenter, dao);

    @Test
    public void execute() {
        interactor.execute(new ProposedSymptomsInputData(new ArrayList<>()));
    }
}
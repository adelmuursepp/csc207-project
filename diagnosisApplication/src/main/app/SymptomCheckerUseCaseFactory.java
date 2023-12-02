package main.app;

import main.data_access.MedicAPIDiagnosisDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.diagnosis.DiagnosisPresenter;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsController;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsPresenter;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.diagnosis.DiagnosisUserDataAccessInterface;
import main.use_case.proposed_symptoms.ProposedSymptomsAPIDataAccessInterface;
import main.use_case.proposed_symptoms.ProposedSymptomsInputBoundary;
import main.use_case.proposed_symptoms.ProposedSymptomsInteractor;
import main.use_case.proposed_symptoms.ProposedSymptomsOutputBoundary;
import main.view.SymptomCheckerView;
import main.interface_adapter.diagnosis.DiagnosisController;
import main.use_case.diagnosis.DiagnosisOutputBoundary;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.use_case.diagnosis.DiagnosisInputBoundary;
import main.use_case.diagnosis.DiagnosisInteractor;

import javax.swing.*;
import java.io.IOException;

public class SymptomCheckerUseCaseFactory {

    /** Prevent instantiation. */
    private SymptomCheckerUseCaseFactory() {}

    public static SymptomCheckerView create(
            SymptomCheckerViewModel symptomCheckerViewModel, DiagnosisViewModel diagnosisViewModel, ProposedSymptomsViewModel
            proposedSymptomsViewModel, ViewManagerModel viewManagerModel) {

        try {
            DiagnosisController diagnosisController = createDiagnosisUseCase(symptomCheckerViewModel,
                    diagnosisViewModel, viewManagerModel);
            ProposedSymptomsController proposedSymptomsController = createProposedSymptomsUseCase(proposedSymptomsViewModel,viewManagerModel);
            return new SymptomCheckerView(symptomCheckerViewModel, diagnosisController, proposedSymptomsController);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static DiagnosisController createDiagnosisUseCase(SymptomCheckerViewModel symptomCheckerViewModel,
                                                              DiagnosisViewModel diagnosisViewModel,
                                                              ViewManagerModel viewManagerModel)
            throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        DiagnosisOutputBoundary diagnosisOutputBoundary = new DiagnosisPresenter(diagnosisViewModel, viewManagerModel);
        DiagnosisUserDataAccessInterface medicAPIDiagnosisDataAccessInterface = new MedicAPIDiagnosisDataAccessObject();

        UserFactory userFactory = new CommonUserFactory();

        DiagnosisInputBoundary diagnosisInteractor = new DiagnosisInteractor(diagnosisOutputBoundary,
                medicAPIDiagnosisDataAccessInterface);


        return new DiagnosisController(diagnosisInteractor);
    }

    private static ProposedSymptomsController createProposedSymptomsUseCase(ProposedSymptomsViewModel proposedSymptomsViewModel,
                                                                            ViewManagerModel viewManagerModel)
        throws IOException {
        ProposedSymptomsOutputBoundary proposedSymptomsOutputBoundary = new ProposedSymptomsPresenter(proposedSymptomsViewModel, viewManagerModel);
        ProposedSymptomsAPIDataAccessInterface medicAPIProposedSymptomsDataAccessInterface = new MedicAPIDiagnosisDataAccessObject();

        ProposedSymptomsInputBoundary proposedSymptomsInteractor = new ProposedSymptomsInteractor(proposedSymptomsOutputBoundary,
                medicAPIProposedSymptomsDataAccessInterface);
        return  new ProposedSymptomsController(proposedSymptomsInteractor);
    }

}

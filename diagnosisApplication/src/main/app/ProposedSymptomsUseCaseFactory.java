package main.app;

import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;
import main.interface_adapter.symptom_checker.SymptomCheckerPresenter;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.symptom_checker.SymptomCheckerInputBoundary;
import main.use_case.symptom_checker.SymptomCheckerInteractor;
import main.use_case.symptom_checker.SymptomCheckerOutputBoundary;
import main.view.DiagnosisView;
import main.view.ProposedSymptomsView;

import javax.swing.*;
import java.io.IOException;

public class ProposedSymptomsUseCaseFactory {

    private ProposedSymptomsUseCaseFactory() {}

    public static ProposedSymptomsView create(ProposedSymptomsViewModel proposedSymptomsViewModel,
                                              SymptomCheckerViewModel symptomCheckerViewModel,
                                              ViewManagerModel viewManagerModel) {

        try {
            SymptomCheckerController symptomCheckerController = createSymptomCheckerUseCase(symptomCheckerViewModel,
                    viewManagerModel);
            return new ProposedSymptomsView(proposedSymptomsViewModel, symptomCheckerController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not get diagnosis");
        }

        return null;
    }

    private static SymptomCheckerController createSymptomCheckerUseCase(SymptomCheckerViewModel symptomCheckerViewModel,
                                                                        ViewManagerModel viewManagerModel)
            throws IOException {

        SymptomCheckerOutputBoundary symptomCheckerPresenter = new SymptomCheckerPresenter(symptomCheckerViewModel,
                viewManagerModel);

        SymptomCheckerInputBoundary symptomCheckerInteractor = new SymptomCheckerInteractor(symptomCheckerPresenter);


        return new SymptomCheckerController(symptomCheckerInteractor);
    }
}

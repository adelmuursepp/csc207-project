package main.app;

import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.past_diagnoses.PastDiagnosesController;
import main.interface_adapter.past_diagnoses.PastDiagnosesViewModel;
import main.interface_adapter.profile.ProfileViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;
import main.interface_adapter.symptom_checker.SymptomCheckerPresenter;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.diagnosis.DiagnosisFileDataAccessInterface;
import main.use_case.symptom_checker.SymptomCheckerInputBoundary;
import main.use_case.symptom_checker.SymptomCheckerInteractor;
import main.use_case.symptom_checker.SymptomCheckerOutputBoundary;
import main.view.PastDiagnosesView;
import main.view.ProfileView;

import javax.swing.*;
import java.io.IOException;

public class PastDiagnosesUseCaseFactory {

    public PastDiagnosesUseCaseFactory() {}

    public static PastDiagnosesView create(PastDiagnosesViewModel pastDiagnosesViewModel,
                                           SymptomCheckerViewModel symptomCheckerViewModel,
                                           ViewManagerModel viewManagerModel) {

        try {
            SymptomCheckerController symptomCheckerController = createSymptomCheckerUseCase(symptomCheckerViewModel,
                    viewManagerModel);
            return new PastDiagnosesView(pastDiagnosesViewModel, symptomCheckerController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not get past diagnoses");
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
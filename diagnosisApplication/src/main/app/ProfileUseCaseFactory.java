package main.app;

import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.interface_adapter.past_diagnoses.PastDiagnosesController;
import main.interface_adapter.past_diagnoses.PastDiagnosesPresenter;
import main.interface_adapter.past_diagnoses.PastDiagnosesViewModel;
import main.interface_adapter.profile.ProfileViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;
import main.interface_adapter.symptom_checker.SymptomCheckerPresenter;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.diagnosis.DiagnosisFileDataAccessInterface;
import main.use_case.past_diagnoses.PastDiagnosesInputBoundary;
import main.use_case.past_diagnoses.PastDiagnosesOutputBoundary;
import main.use_case.past_diagnoses.PastDiagnosesInteractor;
import main.use_case.symptom_checker.SymptomCheckerInputBoundary;
import main.use_case.symptom_checker.SymptomCheckerInteractor;
import main.use_case.symptom_checker.SymptomCheckerOutputBoundary;
import main.view.DiagnosisView;
import main.view.ProfileView;

import javax.swing.*;
import java.io.IOException;

public class ProfileUseCaseFactory {

    public ProfileUseCaseFactory() {}

    public static ProfileView create(ProfileViewModel profileViewModel,
                                     SymptomCheckerViewModel symptomCheckerViewModel,
                                     PastDiagnosesViewModel pastDiagnosesViewModel,
                                     ViewManagerModel viewManagerModel,
    DiagnosisFileDataAccessInterface fileDiagnosisDataAccessObject) {

        try {
            SymptomCheckerController symptomCheckerController = createSymptomCheckerUseCase(symptomCheckerViewModel,
                    viewManagerModel);
            PastDiagnosesController pastDiagnosesController = createPastDiagnosesUseCase(pastDiagnosesViewModel,
                    viewManagerModel, fileDiagnosisDataAccessObject);
            return new ProfileView(profileViewModel,
                    symptomCheckerController, pastDiagnosesController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not get the profile");
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

    private static PastDiagnosesController createPastDiagnosesUseCase(PastDiagnosesViewModel pastDiagnosesViewModel,
                                                                      ViewManagerModel viewManagerModel,
                                                                      DiagnosisFileDataAccessInterface diagnosesFileDataAccessObject) {

        PastDiagnosesOutputBoundary pastDiagnosesPresenter = new PastDiagnosesPresenter(viewManagerModel, pastDiagnosesViewModel);

        PastDiagnosesInputBoundary pastDiagnosesInteractor = new PastDiagnosesInteractor(pastDiagnosesPresenter, diagnosesFileDataAccessObject);

        return new PastDiagnosesController(pastDiagnosesInteractor);
    }
}

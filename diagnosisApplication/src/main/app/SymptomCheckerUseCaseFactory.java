package main.app;

import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.diagnosis.DiagnosisPresenter;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.signup.SignupController;
import main.interface_adapter.signup.SignupPresenter;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.signup.SignupInputBoundary;
import main.use_case.signup.SignupInteractor;
import main.use_case.signup.SignupOutputBoundary;
import main.use_case.signup.SignupUserDataAccessInterface;
import main.view.SignupView;
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
            SymptomCheckerViewModel symptomCheckerViewModel, DiagnosisViewModel diagnosisViewModel) {

        try {
            DiagnosisController diagnosisController = createDiagnosisUseCase(symptomCheckerViewModel,
                    diagnosisViewModel);
            return new SymptomCheckerView(symptomCheckerViewModel, diagnosisController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static DiagnosisController createDiagnosisUseCase(SymptomCheckerViewModel symptomCheckerViewModel,
                                                           DiagnosisViewModel diagnosisViewModel)
            throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        DiagnosisOutputBoundary diagnosisOutputBoundary = new DiagnosisPresenter(diagnosisViewModel);

        UserFactory userFactory = new CommonUserFactory();

        DiagnosisInputBoundary diagnosisInteractor = new DiagnosisInteractor(diagnosisOutputBoundary);

        return new DiagnosisController(diagnosisInteractor);
    }

}

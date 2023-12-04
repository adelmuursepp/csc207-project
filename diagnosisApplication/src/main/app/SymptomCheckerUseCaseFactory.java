package main.app;

import main.data_access.GlossaryDataAccessObject;
import main.data_access.MedicAPIDiagnosisDataAccessObject;
import main.entity.CommonUserFactory;
import main.entity.UserFactory;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.diagnosis.DiagnosisPresenter;
import main.interface_adapter.login.LoginController;
import main.interface_adapter.login.LoginPresenter;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.profile.ProfileController;
import main.interface_adapter.profile.ProfilePresenter;
import main.interface_adapter.profile.ProfileViewModel;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsController;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsPresenter;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsViewModel;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.glossary.GlossaryController;
import main.interface_adapter.glossary.GlossaryPresenter;
import main.interface_adapter.glossary.GlossaryViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.diagnosis.DiagnosisUserDataAccessInterface;
import main.use_case.proposed_symptoms.ProposedSymptomsAPIDataAccessInterface;
import main.use_case.proposed_symptoms.ProposedSymptomsInputBoundary;
import main.use_case.proposed_symptoms.ProposedSymptomsInteractor;
import main.use_case.proposed_symptoms.ProposedSymptomsOutputBoundary;
import main.use_case.diagnosis.*;
import main.use_case.login.LoginInputBoundary;
import main.use_case.login.LoginInteractor;
import main.use_case.login.LoginOutputBoundary;
import main.use_case.login.LoginUserDataAccessInterface;
import main.use_case.profile.ProfileInputBoundary;
import main.use_case.profile.ProfileInteractor;
import main.use_case.profile.ProfileOutputBoundary;
import main.use_case.profile.ProfileUserDataAccessInterface;
import main.use_case.glossary.GlossaryDataAccessInterface;
import main.use_case.glossary.GlossaryInputBoundary;
import main.use_case.glossary.GlossaryInteractor;
import main.use_case.glossary.GlossaryOuputBoundary;
import main.view.SymptomCheckerView;
import main.interface_adapter.diagnosis.DiagnosisController;
import main.interface_adapter.diagnosis.DiagnosisViewModel;

import javax.swing.*;
import java.io.IOException;

public class SymptomCheckerUseCaseFactory {

    /** Prevent instantiation. */
    private SymptomCheckerUseCaseFactory() {}

    public static SymptomCheckerView create(
            SymptomCheckerViewModel symptomCheckerViewModel, DiagnosisViewModel diagnosisViewModel, ProfileViewModel profileViewModel,
            ProposedSymptomsViewModel proposedSymptomsViewModel, GlossaryViewModel glossaryViewModel,
            ViewManagerModel viewManagerModel, ProfileUserDataAccessInterface profileUserDataAccessObject,
            DiagnosisFileDataAccessInterface diagnosisFileDataAccessObject) {

        try {
            DiagnosisController diagnosisController = createDiagnosisUseCase(diagnosisViewModel,
                    diagnosisFileDataAccessObject, viewManagerModel);
            ProposedSymptomsController proposedSymptomsController = createProposedSymptomsUseCase(proposedSymptomsViewModel,viewManagerModel);
            ProfileController profileController = createProfileUseCase(profileViewModel, viewManagerModel, profileUserDataAccessObject);
            GlossaryController glossaryController = createGlossaryUseCase(viewManagerModel, glossaryViewModel);
            return new SymptomCheckerView(symptomCheckerViewModel, diagnosisController, proposedSymptomsController, glossaryController, profileController);


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static DiagnosisController createDiagnosisUseCase(DiagnosisViewModel diagnosisViewModel,
                                                              DiagnosisFileDataAccessInterface diagnosisFileDataAccessObject,
                                                              ViewManagerModel viewManagerModel)
            throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        DiagnosisOutputBoundary diagnosisOutputBoundary = new DiagnosisPresenter(diagnosisViewModel, viewManagerModel);
        DiagnosisUserDataAccessInterface medicAPIDiagnosisDataAccessInterface = new MedicAPIDiagnosisDataAccessObject();

        UserFactory userFactory = new CommonUserFactory();

        DiagnosisInputBoundary diagnosisInteractor = new DiagnosisInteractor(diagnosisOutputBoundary,
                medicAPIDiagnosisDataAccessInterface, diagnosisFileDataAccessObject);


        return new DiagnosisController(diagnosisInteractor);
    }

    private static ProfileController createProfileUseCase(ProfileViewModel profileViewModel,
                                                          ViewManagerModel viewManagerModel,
                                                          ProfileUserDataAccessInterface profileUserDataAccessObject) {
        ProfileOutputBoundary profileOutputBoundary = new ProfilePresenter(viewManagerModel, profileViewModel);
        ProfileInputBoundary profileInteractor = new ProfileInteractor(profileUserDataAccessObject, profileOutputBoundary);
        return new ProfileController(profileInteractor);
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

    private static GlossaryController createGlossaryUseCase(ViewManagerModel viewManagerModel,
                                                            GlossaryViewModel glossaryViewModel) {

        GlossaryOuputBoundary glossaryPresenter = new GlossaryPresenter(glossaryViewModel, viewManagerModel);
        GlossaryDataAccessInterface glossaryDataAccessObject = new GlossaryDataAccessObject();
        GlossaryInputBoundary glossaryInteractor = new GlossaryInteractor(glossaryDataAccessObject, glossaryPresenter);

        return new GlossaryController(glossaryInteractor);
    }

}

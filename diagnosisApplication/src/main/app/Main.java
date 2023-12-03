package main.app;

import main.data_access.FileDiagnosisDataAccessObject;
import main.data_access.FileUserDataAccessObject;
import main.entity.CommonUserFactory;
import main.interface_adapter.login.LoginViewModel;
//import main.interface_adapter.logged_in.LoggedInViewModel;
import main.interface_adapter.past_diagnoses.PastDiagnosesViewModel;
import main.interface_adapter.profile.ProfileViewModel;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;
import main.use_case.diagnosis.DiagnosisFileDataAccessInterface;
import main.use_case.login.LoginUserDataAccessInterface;
//import main.view.LoggedInView;
import main.use_case.profile.ProfileUserDataAccessInterface;
import main.view.*;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.interface_adapter.diagnosis.DiagnosisViewModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Build main program window.

        //Main Application Window.
        JFrame application = new JFrame("Bootleg WebMD");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        //The various View objects. Only one view is visible.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        //Track and manage which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views,cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SymptomCheckerViewModel symptomCheckerViewModel = new SymptomCheckerViewModel();
        PastDiagnosesViewModel pastDiagnosesViewModel = new PastDiagnosesViewModel();
        DiagnosisViewModel diagnosisViewModel = new DiagnosisViewModel();
        ProfileViewModel profileViewModel = new ProfileViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileDiagnosisDataAccessObject fileDiagnosisDataAccessObject;
        try {
            fileDiagnosisDataAccessObject = new FileDiagnosisDataAccessObject("./diagnoses.csv", userDataAccessObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel,
                symptomCheckerViewModel,
                userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, symptomCheckerViewModel,
                signupViewModel,
                userDataAccessObject);
        views.add(loginView, loginView.viewName);

        SymptomCheckerView symptomCheckerView = SymptomCheckerUseCaseFactory.create(symptomCheckerViewModel,
                diagnosisViewModel, profileViewModel, viewManagerModel, userDataAccessObject, fileDiagnosisDataAccessObject);
        views.add(symptomCheckerView, symptomCheckerView.viewName);

        DiagnosisView diagnosisView = DiagnosisUseCaseFactory.create(diagnosisViewModel, symptomCheckerViewModel,
                viewManagerModel);
        views.add(diagnosisView, diagnosisView.viewName);

        ProfileView profileView = ProfileUseCaseFactory.create(profileViewModel, symptomCheckerViewModel, pastDiagnosesViewModel, viewManagerModel);
        views.add(profileView, profileView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
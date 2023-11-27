package main.app;

import diagnosisApplication.src.main.data_access.FileUserDataAccessObject;
import diagnosisApplication.src.main.entity.CommonUserFactory;
import diagnosisApplication.src.main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.logged_in.LoggedInViewModel;
import diagnosisApplication.src.main.interface_adapter.signup.SignupViewModel;
import diagnosisApplication.src.main.interface_adapter.ViewManagerModel;
import diagnosisApplication.src.main.use_case.login.LoginUserDataAccessInterface;
import diagnosisApplication.src.main.view.LoggedInView;
import diagnosisApplication.src.main.view.LoginView;
import diagnosisApplication.src.main.view.SignupView;
import diagnosisApplication.src.main.view.ViewManager;

import javax.swing.*;
import java.awt.*;

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
        DiagnosisViewModel diagnosisViewModel = new DiagnosisViewModel();

    }
}
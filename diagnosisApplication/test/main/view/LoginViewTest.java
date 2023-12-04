package main.view;

import main.app.LoginUseCaseFactory;
import main.app.Main;
import main.data_access.FileUserDataAccessObject;
import main.data_access.InMemoryUserDataAccessObject;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class LoginViewTest {

    @Test
    public void loginUseCase() {
        Main.main(null);

        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app);


    }

    @Test
    public void actionPerformed() {
    }

    @Test
    public void propertyChange() {
    }
}
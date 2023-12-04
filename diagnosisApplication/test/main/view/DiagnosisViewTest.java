package main.view;

import main.app.DiagnosisUseCaseFactory;
import main.app.Main;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.*;

public class DiagnosisViewTest {
    DiagnosisView view = DiagnosisUseCaseFactory.create(new DiagnosisViewModel(), new SymptomCheckerViewModel(),
            new ViewManagerModel());

    @Test
    public void symptomCheckerUseCase() {
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
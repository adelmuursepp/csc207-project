package view;

import javax.swing.*;
import java.awt.*;


public class SymptomCheckerView extends JPanel {
    public final String viewName = "symptom checker";

    private final JTextField sexInputField = new JTextField(0);
    private final JTextField ageInputField = new JTextField(0);
    private final DiagnosisController diagnosisController;
}

package view;

import interface_adapter.diagnosis.DiagnosisController;
import interface_adapter.symptom_checker.SymptomCheckerController;
import interface_adapter.symptom_checker.SymptomCheckerState;
import interface_adapter.symptom_checker.SymptomCheckerViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SymptomCheckerView extends JPanel {
    public final String viewName = "symptom checker";

    private final SymptomCheckerViewModel symptomCheckerViewModel;
    private final SymptomCheckerController symptomCheckerController;
    private final DiagnosisController diagnosisController;

    private final JButton diagnoses;

    public SymptomCheckerView(SymptomCheckerViewModel symptomCheckerViewModel,
                              SymptomCheckerController symptomCheckerController,
                              DiagnosisController diagnosisController) {
        this.symptomCheckerViewModel = symptomCheckerViewModel;
        this.symptomCheckerController = symptomCheckerController;
        this.diagnosisController = diagnosisController;

        JLabel title = new JLabel(SymptomCheckerViewModel.TITLE_LABEL);

        JPanel buttons = new JPanel();
        diagnoses = new JButton(SymptomCheckerViewModel.DIAGNOSES_BUTTON_LABEL);
        buttons.add(diagnoses);

        diagnoses.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(diagnoses)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();

                            diagnosisController.execute();
                        }
                    }
                }
        );

        this.add(title);
        this.add(buttons);
    }
}

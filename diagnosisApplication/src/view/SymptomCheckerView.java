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

    private final JButton submit;

    private final JCheckBox symptom1;

    public SymptomCheckerView(SymptomCheckerViewModel symptomCheckerViewModel,
                              SymptomCheckerController symptomCheckerController,
                              DiagnosisController diagnosisController) {
        this.symptomCheckerViewModel = symptomCheckerViewModel;
        this.symptomCheckerController = symptomCheckerController;
        this.diagnosisController = diagnosisController;

        JLabel title = new JLabel(SymptomCheckerViewModel.TITLE_LABEL);

        JPanel buttons = new JPanel();
        submit = new JButton(SymptomCheckerViewModel.DIAGNOSES_BUTTON_LABEL);
        buttons.add(submit);

        submit.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(submit)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();

                            diagnosisController.execute();
                        }
                    }
                }
        );

        this.add(title);
        this.add(buttons);
        JPanel checkboxes = new JPanel();
        symptom1 = new JCheckBox("symptom1");
        checkboxes.add(symptom1);

        symptom1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(symptom1)) {

                        }
                    }
                }
        );

    }
}



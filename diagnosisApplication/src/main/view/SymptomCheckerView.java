package diagnosisApplication.src.main.view;

import diagnosisApplication.src.main.interface_adapter.diagnosis.DiagnosisController;
import diagnosisApplication.src.main.interface_adapter.symptom_checker.SymptomCheckerController;
import diagnosisApplication.src.main.interface_adapter.symptom_checker.SymptomCheckerState;
import diagnosisApplication.src.main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import diagnosisApplication.src.main.interface_adapter.diagnosis.DiagnosisController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SymptomCheckerView extends JPanel {
    public final String viewName = "symptom checker";

    private final SymptomCheckerViewModel symptomCheckerViewModel;
    private final JButton submit;

    private final JCheckBox symptom1;

    public SymptomCheckerView(SymptomCheckerViewModel symptomCheckerViewModel, ) {
        this.symptomCheckerViewModel = symptomCheckerViewModel;

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

                            diagnosisController.execute(currentState.getCheckedSymptoms());
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
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(1);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

    }
}



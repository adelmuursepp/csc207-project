package main.view;

import main.interface_adapter.past_diagnoses.PastDiagnosesPresenter;
import main.interface_adapter.past_diagnoses.PastDiagnosesState;
import main.interface_adapter.past_diagnoses.PastDiagnosesViewModel;
import main.interface_adapter.profile.ProfileViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PastDiagnosesView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "past-diagnoses";
    private final PastDiagnosesViewModel pastDiagnosesViewModel;
    private final SymptomCheckerController symptomCheckerController;
    private final JButton symptomChecker;
    private final DefaultListModel<String> listModel;
    private final JList<String> stringList;

    public PastDiagnosesView(PastDiagnosesViewModel pastDiagnosesViewModel,
                             SymptomCheckerController symptomCheckerController) {
        super(new BorderLayout());
        this.pastDiagnosesViewModel = pastDiagnosesViewModel;
        this.symptomCheckerController = symptomCheckerController;

        pastDiagnosesViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(pastDiagnosesViewModel.TITLE_LABEL);
        JPanel buttons = new JPanel();
        symptomChecker = new JButton(pastDiagnosesViewModel.SYMPTOM_CHECKER_BUTTON_LABEL);
        buttons.add(symptomChecker);

        // Create a JList and its model
        listModel = new DefaultListModel<>();
        stringList = new JList<>(listModel);

        // Add the JList to a JScrollPane for scrollability
        JScrollPane listScrollPane = new JScrollPane(stringList);

        symptomChecker.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(symptomChecker)) {
                            symptomCheckerController.execute();
                        }
                    }
                }
        );
        add(title, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);
        add(listScrollPane, BorderLayout.SOUTH);
        addString("String 1");
        addString("String 2");
        addString("String 3");

    }

    // Method to add a string to the list
    public void addString(String s) {
        listModel.addElement(s);
    }

    // Method to update the list with proposed symptoms
    public void updateList(List<String> pastDiagnoses) {
        // Clear the existing list
        listModel.clear();

        // Add the proposed symptoms to the list
        for (String diagnosis : pastDiagnoses) {
            listModel.addElement(diagnosis);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PastDiagnosesState currentState = (PastDiagnosesState) evt.getNewValue();
        List<String> pastDiagnoses = currentState.getPastDiagnosesList();
        updateList(pastDiagnoses);
    }
}

package main.view;

import main.interface_adapter.diagnosis.DiagnosisState;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsState;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ProposedSymptomsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "proposed-symptoms";
    private final ProposedSymptomsViewModel proposedSymptomsViewModel;
    private final SymptomCheckerController symptomCheckerController;
    private final JButton symptomChecker;
    private final DefaultListModel<String> listModel;
    private final JList<String> stringList;
    public ProposedSymptomsView(ProposedSymptomsViewModel proposedSymptomsViewModel, SymptomCheckerController symptomCheckerController) {
        super(new BorderLayout());

        this.proposedSymptomsViewModel = proposedSymptomsViewModel;
        this.symptomCheckerController = symptomCheckerController;
        proposedSymptomsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(proposedSymptomsViewModel.TITLE_LABEL);
        JPanel buttons = new JPanel();
        symptomChecker = new JButton(ProposedSymptomsViewModel.SYMPTOM_CHECKER_BUTTON_LABEL);
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
    public void updateList(List<String> proposedSymptoms) {
        // Clear the existing list
        listModel.clear();

        // Add the proposed symptoms to the list
        for (String symptom : proposedSymptoms) {
            listModel.addElement(symptom);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ProposedSymptomsState currentState = (ProposedSymptomsState) evt.getNewValue();
        List<String> proposedSymptoms = currentState.getProposedSymptomsList();
        updateList(proposedSymptoms);
    }
}

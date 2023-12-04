package main.view;

import main.interface_adapter.past_diagnoses.PastDiagnosesPresenter;
import main.interface_adapter.past_diagnoses.PastDiagnosesState;
import main.interface_adapter.past_diagnoses.PastDiagnosesViewModel;
import main.interface_adapter.profile.ProfileViewModel;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import static main.view.SymptomCheckerView.hexToColor;

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
        setBackground(hexToColor("#B8D2E4"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.pastDiagnosesViewModel = pastDiagnosesViewModel;
        this.symptomCheckerController = symptomCheckerController;

        pastDiagnosesViewModel.addPropertyChangeListener(this);

        Box innerBox = Box.createVerticalBox();
        innerBox.setBackground(hexToColor("#B8D2E4"));
        innerBox.setPreferredSize(new Dimension(600, 300));
        innerBox.setMaximumSize(new Dimension(600, 300));
        innerBox.setMinimumSize(new Dimension(600, 300));

        JLabel title = new JLabel(pastDiagnosesViewModel.TITLE_LABEL);
        Font titleFont = new Font(title.getFont().getName(), Font.BOLD, title.getFont().getSize() + 1);
        title.setFont(titleFont);
        title.setAlignmentX(CENTER_ALIGNMENT);
        innerBox.add(title);
        innerBox.add(Box.createVerticalStrut(100));

        JLabel description = new JLabel(pastDiagnosesViewModel.DESCRIPTION_LABEL);
        Font descriptionFont = new Font(description.getFont().getName(), Font.ITALIC,
                description.getFont().getSize() - 1);
        description.setFont(descriptionFont);
        description.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        description.setAlignmentX(CENTER_ALIGNMENT);
        innerBox.add(description);
        innerBox.add(Box.createVerticalStrut(20));

        JPanel buttons = new JPanel();
        buttons.setAlignmentY(CENTER_ALIGNMENT);
        buttons.setBackground(hexToColor("#B8D2E4"));
        symptomChecker = new JButton(pastDiagnosesViewModel.SYMPTOM_CHECKER_BUTTON_LABEL);
        buttons.add(symptomChecker);
        innerBox.add(buttons);


        // Create a JList and its model
        listModel = new DefaultListModel<>();
        stringList = new JList<>(listModel);
        stringList.setAlignmentX(CENTER_ALIGNMENT);
        stringList.setPreferredSize(new Dimension(320, 200));
        stringList.setMaximumSize(new Dimension(320, 200));
        stringList.setMinimumSize(new Dimension(320, 200));
        stringList.setBackground(hexToColor("#B8D2E4"));

        // Add the JList to a JScrollPane for scrollability
        JScrollPane listScrollPane = new JScrollPane(stringList);
        listScrollPane.setBackground(hexToColor("#B8D2E4"));
        listScrollPane.setPreferredSize(new Dimension(400, 300));
        listScrollPane.setMaximumSize(new Dimension(400, 300));
        listScrollPane.setMinimumSize(new Dimension(400, 300));
        listScrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        listScrollPane.setAlignmentX(CENTER_ALIGNMENT);
        listScrollPane.setAlignmentY(TOP_ALIGNMENT);
        innerBox.add(listScrollPane);

        symptomChecker.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(symptomChecker)) {
                            symptomCheckerController.execute();
                        }
                    }
                }
        );
        add(title);
        add(buttons);
        add(listScrollPane);
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

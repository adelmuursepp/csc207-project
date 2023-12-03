package main.view;

import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.interface_adapter.past_diagnoses.PastDiagnosesController;
import main.interface_adapter.profile.ProfileState;
import main.interface_adapter.profile.ProfileViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile";
    private final ProfileViewModel profileViewModel;
    private final SymptomCheckerController symptomCheckerController;
    private final PastDiagnosesController pastDiagnosisController;
    private final JButton symptomChecker;
    private final JButton pastDiagnoses;

    public ProfileView(ProfileViewModel profileViewModel, SymptomCheckerController symptomCheckerController,
                       PastDiagnosesController pastDiagnosisController) {
        this.profileViewModel = profileViewModel;
        this.symptomCheckerController = symptomCheckerController;
        this.pastDiagnosisController = pastDiagnosisController;
        setLayout(new BorderLayout());

        ProfileState profileState = this.profileViewModel.getState();

        // Create components
        JLabel profileLabel = new JLabel("Profile Name");
        JPanel buttonPanel = new JPanel();
        JPanel namePanel = new JPanel();

        String username = profileState.getUsername();
        System.out.println("The current user name in view");
        System.out.println(username);
        JLabel usernameLabel = new JLabel(username);
        namePanel.add(usernameLabel);
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // Add components to the main frame
        add(profileLabel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.EAST);

        // Set layout manager for the button panel
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));




        JLabel title = new JLabel(profileViewModel.TITLE_LABEL);

//        JPanel buttons = new JPanel();
        symptomChecker = new JButton(profileViewModel.SYMPTOM_CHECKER_BUTTON_LABEL);
        buttonPanel.add(namePanel);
        buttonPanel.add(symptomChecker);
        pastDiagnoses = new JButton(profileViewModel.PAST_DIAGNOSES_BUTTON_LABEL);
        buttonPanel.add(pastDiagnoses);
        // Add buttons to the button panel
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        symptomChecker.addActionListener(

                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(symptomChecker)) {
                            symptomCheckerController.execute();
                        }
                    }
                }
        );

        pastDiagnoses.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(pastDiagnoses)) {
                            pastDiagnosesController.execute();
                        }
                    }
                }
        );

        this.add(title);
//        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ProfileState profileState = (ProfileState) evt.getNewValue();
        System.out.println(profileState.getUsername());




    }
}

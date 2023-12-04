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

import static main.view.SymptomCheckerView.hexToColor;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile";
    private final ProfileViewModel profileViewModel;
    private final SymptomCheckerController symptomCheckerController;
    private final PastDiagnosesController pastDiagnosesController;
    private final JButton symptomChecker;
    private final JButton pastDiagnoses;
    private JLabel username;
    private JLabel password;
    private JLabel userSex;
    private JLabel yearOfBirth;

    public ProfileView(ProfileViewModel profileViewModel, SymptomCheckerController symptomCheckerController,
                       PastDiagnosesController pastDiagnosisController) {
        this.profileViewModel = profileViewModel;
        this.symptomCheckerController = symptomCheckerController;
        this.pastDiagnosesController = pastDiagnosisController;

        ProfileState profileState = this.profileViewModel.getState();

        profileViewModel.addPropertyChangeListener(this);


        // Main panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(30));
        this.setBackground(hexToColor("#B8D2E4"));

        // userInfoBox box for user info
        Box userInfoBox = Box.createVerticalBox();
        userInfoBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        userInfoBox.setPreferredSize(new Dimension(450, 300));
        userInfoBox.setMinimumSize(new Dimension(450, 300));
        userInfoBox.setMaximumSize(new Dimension(450, 300));
        userInfoBox.setAlignmentX(CENTER_ALIGNMENT);
        userInfoBox.setBackground(hexToColor("#B8D2E4"));

        // Title
        JLabel title = new JLabel(ProfileViewModel.TITLE_LABEL);
        Font titleFont = new Font(title.getFont().getName(), Font.BOLD, title.getFont().getSize() + 1);
        title.setFont(titleFont);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Username info and change button
        userInfoBox.add(Box.createVerticalStrut(12));

        Box usernameBox = Box.createHorizontalBox();
        userInfoBox.setPreferredSize(new Dimension(450, 50));

        this.username = new JLabel("Username: " + profileState.getUsername());
        username.setPreferredSize(new Dimension(225, 50));
        usernameBox.add(username);

        JButton changeUsername = new JButton(ProfileViewModel.CHANGE_USERNAME_BUTTON_LABEL);
        usernameBox.add(changeUsername);

        userInfoBox.add(usernameBox);

        // Password info and change button
        userInfoBox.add(Box.createVerticalStrut(10));

        Box passwordBox = Box.createHorizontalBox();
        userInfoBox.setPreferredSize(new Dimension(450, 50));

        this.password = new JLabel("Password");
        password.setPreferredSize(new Dimension(225, 50));
        passwordBox.add(password);

        JButton changePassword = new JButton(ProfileViewModel.CHANGE_PASSWORD_BUTTON_LABEL);
        passwordBox.add(changePassword);

        userInfoBox.add(passwordBox);

        // Sex info and change button
        userInfoBox.add(Box.createVerticalStrut(10));

        Box userSexBox = Box.createHorizontalBox();
        userSexBox.setPreferredSize(new Dimension(450, 50));

        this.userSex = new JLabel("User Sex: " + profileState.getUserSex());
        userSex.setPreferredSize(new Dimension(225, 50));
        userSexBox.add(userSex);

        JButton changeSex = new JButton(ProfileViewModel.CHANGE_SEX_BUTTON_LABEL);
        userSexBox.add(changeSex);

        userInfoBox.add(userSexBox);

        // Year of Birth info and change button
        userInfoBox.add(Box.createVerticalStrut(10));

        Box yearOfBirthBox = Box.createHorizontalBox();
        yearOfBirthBox.setPreferredSize(new Dimension(450, 50));

        this.yearOfBirth = new JLabel("Year of Birth: " + profileState.getUserYearOfBirth());
        yearOfBirth.setPreferredSize(new Dimension(225, 50));
        yearOfBirthBox.add(yearOfBirth);

        JButton changeYearOfBirth = new JButton(ProfileViewModel.CHANGE_YEAR_OF_BIRTH_BUTTON_LABEL);
        yearOfBirthBox.add(changeYearOfBirth);

        userInfoBox.add(yearOfBirthBox);

        // Other buttons box
        Box otherButtonsBox = Box.createVerticalBox();
        otherButtonsBox.setPreferredSize(new Dimension(450, 100));
        otherButtonsBox.setMinimumSize(new Dimension(450, 100));
        otherButtonsBox.setMaximumSize(new Dimension(450, 100));
        otherButtonsBox.setBackground(hexToColor("#B8D2E4"));
        otherButtonsBox.setAlignmentX(CENTER_ALIGNMENT);

        // Other buttons
        JPanel otherButtons = new JPanel();
        otherButtons.setLayout(new BoxLayout(otherButtons, BoxLayout.Y_AXIS));
        otherButtons.setPreferredSize(new Dimension(350, 100));
        otherButtons.setAlignmentX(CENTER_ALIGNMENT);
        otherButtons.setBackground(hexToColor("#B8D2E4"));
        otherButtonsBox.add(otherButtons);


        otherButtonsBox.add(Box.createVerticalStrut(10));
        pastDiagnoses = new JButton(profileViewModel.PAST_DIAGNOSES_BUTTON_LABEL);
        pastDiagnoses.setAlignmentX(CENTER_ALIGNMENT);
        otherButtons.add(pastDiagnoses);

        otherButtonsBox.add(Box.createVerticalStrut(10));
        symptomChecker = new JButton(profileViewModel.SYMPTOM_CHECKER_BUTTON_LABEL);
        symptomChecker.setAlignmentX(CENTER_ALIGNMENT);
        otherButtons.add(symptomChecker);

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
        this.add(Box.createVerticalStrut(30));
        this.add(userInfoBox);
        this.add(Box.createVerticalStrut(30));
        this.add(otherButtonsBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ProfileState profileState = (ProfileState) evt.getNewValue();
        username.setText("Username: " + profileState.getUsername());
        userSex.setText("User Sex: " + profileState.getUserSex());
        yearOfBirth.setText("Year of Birth: " + profileState.getUserYearOfBirth());
    }
}

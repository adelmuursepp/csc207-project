package main.view;

import main.interface_adapter.diagnosis.DiagnosisController;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;
import main.interface_adapter.symptom_checker.SymptomCheckerState;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SymptomCheckerView extends JPanel {
    public final String viewName = "symptom checker";

    private final SymptomCheckerViewModel symptomCheckerViewModel;
    private final JButton submit;
    private final JCheckBox cough;
    private final JCheckBox diarrhea;
    private final JCheckBox dizziness;
    private final JCheckBox drowsiness;
    private final JCheckBox fever;
    private final JCheckBox headache;
    private final JCheckBox jointPain;
    private final JCheckBox nausea;
    private final JCheckBox skinRash;
    private final JCheckBox sneezing;
    private final JCheckBox soreThroat;
    private final JCheckBox vomiting;
    private final JCheckBox wheezing;
    private final JCheckBox stuffyNose;
    private final JCheckBox palpitations;
    private final JCheckBox nosebleed;
    private final JCheckBox muscleWeakness;
    private final JCheckBox impairedBalance;
    private final JCheckBox cramps;
    private final JCheckBox pallor;
    private final DiagnosisController diagnosisController;

    public SymptomCheckerView(SymptomCheckerViewModel symptomCheckerViewModel, DiagnosisController diagnosisController)
    {
        this.symptomCheckerViewModel = symptomCheckerViewModel;
        this.diagnosisController = diagnosisController;

        JLabel title = new JLabel(SymptomCheckerViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        JPanel checkboxes1 = new JPanel();
        JPanel checkboxes2 = new JPanel();
        JPanel checkboxes3 = new JPanel();
        JPanel checkboxes4 = new JPanel();
        cough = new JCheckBox("Cough");
        checkboxes1.add(cough);

        cough.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(cough)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(15);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );
        diarrhea = new JCheckBox("Diarrhea");
        checkboxes1.add(diarrhea);

        diarrhea.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(diarrhea)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(50);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );
        dizziness = new JCheckBox("Dizziness");
        checkboxes1.add(dizziness);

        dizziness.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(dizziness)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(207);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        drowsiness = new JCheckBox("Drowsiness");
        checkboxes1.add(drowsiness);

        drowsiness.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(drowsiness)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(43);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        fever = new JCheckBox("Fever");
        checkboxes1.add(fever);

        fever.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(fever)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(11);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        headache = new JCheckBox("Headache");
        checkboxes2.add(headache);

        headache.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(headache)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(9);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        jointPain = new JCheckBox("Joint Pain");
        checkboxes2.add(jointPain);

        jointPain.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(jointPain)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(27);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        nausea = new JCheckBox("Nausea");
        checkboxes2.add(nausea);

        nausea.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(nausea)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(44);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        skinRash = new JCheckBox("Rash");
        checkboxes2.add(skinRash);

        skinRash.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(skinRash)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(124);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        sneezing = new JCheckBox("Sneezing");
        checkboxes2.add(sneezing);

        sneezing.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(sneezing)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(95);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        soreThroat = new JCheckBox("Sore Throat");
        checkboxes3.add(soreThroat);

        soreThroat.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(soreThroat)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(13);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        vomiting = new JCheckBox("Vomiting");
        checkboxes3.add(vomiting);

        vomiting.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(vomiting)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(101);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        wheezing = new JCheckBox("Wheezing");
        checkboxes3.add(wheezing);

        wheezing.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(wheezing)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(30);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        stuffyNose = new JCheckBox("Stuffy Nose");
        checkboxes3.add(stuffyNose);

        stuffyNose.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(stuffyNose)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(28);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        palpitations = new JCheckBox("Palpitations");
        checkboxes3.add(palpitations);

        palpitations.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(palpitations)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(37);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

         nosebleed = new JCheckBox("Nosebleed");
        checkboxes3.add(nosebleed);

        nosebleed.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(nosebleed)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(38);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        muscleWeakness = new JCheckBox("Muscle Weakness");
        checkboxes4.add(muscleWeakness);

        muscleWeakness.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(muscleWeakness)) {
                        SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                        currentState.togglesymptom(987);
                        symptomCheckerViewModel.setState(currentState);

                    }
                }
            }
        );

        impairedBalance = new JCheckBox("Impaired Balance");
        checkboxes4.add(impairedBalance);

        impairedBalance.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(impairedBalance)) {
                        SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                        currentState.togglesymptom(120);
                        symptomCheckerViewModel.setState(currentState);

                    }
                }
            }
        );

        cramps = new JCheckBox("Cramps");
        checkboxes4.add(cramps);

        cramps.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(cramps)) {
                        SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                        currentState.togglesymptom(94);
                        symptomCheckerViewModel.setState(currentState);

                    }
                }
            }
        );

        pallor = new JCheckBox("Pallor");
        checkboxes4.add(pallor);

        pallor.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(pallor)) {
                        SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                        currentState.togglesymptom(150);
                        symptomCheckerViewModel.setState(currentState);

                    }
                }
            }
        );
        this.add(checkboxes1);
        this.add(checkboxes2);
        this.add(checkboxes3);
        this.add(checkboxes4);

    }
}



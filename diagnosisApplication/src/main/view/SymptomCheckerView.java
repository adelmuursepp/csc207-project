package main.view;

import main.interface_adapter.diagnosis.DiagnosisController;
import main.interface_adapter.proposed_symptoms.ProposedSymptomsController;
import main.interface_adapter.glossary.GlossaryController;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;
import main.interface_adapter.symptom_checker.SymptomCheckerState;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;


public class SymptomCheckerView extends JPanel {
    public final String viewName = "symptom checker";

    private final SymptomCheckerViewModel symptomCheckerViewModel;
    private  final GlossaryController glossaryController;
    private final JButton submit;
    private final JButton proposedSymptoms;
    private final JButton glossary;
    private final JCheckBox cough;
    private final JCheckBox chestTightness;
    private final JCheckBox diarrhea;
    private final JCheckBox dizziness;
    private final JCheckBox drowsiness;
    private final JCheckBox fever;
    private final JCheckBox headache;
    private final JCheckBox jointPain;
    private final JCheckBox feelingFaint;
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
    private final JCheckBox chestPain;
    private final JCheckBox chills;
    private final JCheckBox earAche;
    private final JCheckBox hairLoss;
    private final JCheckBox heartBurn;
    private final JCheckBox moodSwings;
    private final JCheckBox nightSweats;
    private final JCheckBox tiredness;
    private final JCheckBox toothAche;
    private final JCheckBox wound;
    private final JCheckBox abdominalPain;
    private final JCheckBox backPain;
    private final JCheckBox hearingLoss;
    private final JCheckBox itchingEyes;

    private final DiagnosisController diagnosisController;

    private final ProposedSymptomsController proposedSymptomsController;

    // Convert hex color code to Color object
    public static Color hexToColor(String hex) {
        int intValue = Integer.parseInt(hex.substring(1), 16);
        return new Color(intValue);
    }

    public SymptomCheckerView(SymptomCheckerViewModel symptomCheckerViewModel, DiagnosisController diagnosisController,
                              ProposedSymptomsController proposedSymptomsController, GlossaryController glossaryController)
    {
        setBackground(hexToColor("#B8D2E4"));
        this.symptomCheckerViewModel = symptomCheckerViewModel;
        this.diagnosisController = diagnosisController;
        this.proposedSymptomsController = proposedSymptomsController;
        this.glossaryController = glossaryController;

        //main panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(20));

        //inner box to hold in place
        Box innerBox = Box.createVerticalBox();
        innerBox.add(Box.createVerticalStrut(20));
        innerBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        innerBox.setPreferredSize(new Dimension(655, 355));
        innerBox.setMinimumSize(new Dimension(655, 355));
        innerBox.setMaximumSize(new Dimension(655, 355));
        innerBox.setBackground(hexToColor("#B8D2E4"));

        //title
        JLabel title = new JLabel(SymptomCheckerViewModel.TITLE_LABEL);
        Font titleFont = new Font(title.getFont().getName(), Font.BOLD, title.getFont().getSize() + 1);
        title.setFont(titleFont);
        title.setAlignmentX(CENTER_ALIGNMENT);
        innerBox.add(title);
        innerBox.add(Box.createVerticalStrut(0));

        JLabel description = new JLabel(SymptomCheckerViewModel.DESCRIPTION_LABEL);
        Font descriptionFont = new Font(description.getFont().getName(), Font.ITALIC,
                description.getFont().getSize() - 1);
        description.setFont(descriptionFont);
        description.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        description.setAlignmentX(CENTER_ALIGNMENT);
        innerBox.add(description);
        innerBox.add(Box.createVerticalStrut(20));

        //checkboxes
        Box symptomsBox = Box.createHorizontalBox();
        symptomsBox.add(Box.createVerticalStrut(40));

        JPanel checkboxes1 = new JPanel();
        checkboxes1.setBackground(hexToColor("#B8D2E4"));
        checkboxes1.setLayout(new BoxLayout(checkboxes1, BoxLayout.Y_AXIS));
        symptomsBox.add(checkboxes1);

        JPanel checkboxes2 = new JPanel();
        checkboxes2.setBackground(hexToColor("#B8D2E4"));
        symptomsBox.add(checkboxes2);
        checkboxes2.setLayout(new BoxLayout(checkboxes2, BoxLayout.Y_AXIS));

        JPanel checkboxes3 = new JPanel();
        checkboxes3.setBackground(hexToColor("#B8D2E4"));
        symptomsBox.add(checkboxes3);
        checkboxes3.setLayout(new BoxLayout(checkboxes3, BoxLayout.Y_AXIS));

        JPanel checkboxes4 = new JPanel();
        checkboxes4.setBackground(hexToColor("#B8D2E4"));
        symptomsBox.add(checkboxes4);
        checkboxes4.setLayout(new BoxLayout(checkboxes4, BoxLayout.Y_AXIS));

        symptomsBox.add(Box.createVerticalStrut(40));
        symptomsBox.setBackground(hexToColor("#B8D2E4"));

        innerBox.add(symptomsBox);
        innerBox.add(Box.createVerticalStrut(20));

        //buttons
        JPanel buttons = new JPanel();
        buttons.setBackground(hexToColor("#B8D2E4"));
        submit = new JButton(SymptomCheckerViewModel.DIAGNOSES_BUTTON_LABEL);
        buttons.add(submit);
        proposedSymptoms = new JButton(SymptomCheckerViewModel.PROPOSED_SYMPTOMS_BUTTON_LABEL);
        buttons.add(proposedSymptoms);
        glossary = new JButton("Glossary");
        buttons.add(glossary);
        innerBox.add(buttons);
        innerBox.add(Box.createVerticalStrut(0));

        this.add(innerBox);

        // Checkbox ActionListeners
        submit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(submit)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();

                            diagnosisController.execute(currentState.getCheckedSymptoms());
                        }
                    }
                }
        );

        proposedSymptoms.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(proposedSymptoms)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            proposedSymptomsController.execute(currentState.getCheckedSymptoms());
                        }
                    }
                }
        );

        glossary.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == glossary) {
                            try {
                                glossaryController.execute();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        abdominalPain = new JCheckBox("Abdominal pain");
        checkboxes1.add(abdominalPain);

        abdominalPain.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(abdominalPain)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(10);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        backPain = new JCheckBox("Back pain");
        checkboxes1.add(backPain);

        backPain.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(backPain)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(104);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        chestPain = new JCheckBox("Chest pain");
        checkboxes1.add(chestPain);

        chestPain.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(chestPain)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(17);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        chestTightness = new JCheckBox("Chest tightness");
        checkboxes1.add(chestTightness);

        chestTightness.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(chestTightness)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(31);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        chills = new JCheckBox("Chills");
        checkboxes1.add(chills);

        chills.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(chills)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(175);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

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

        cramps = new JCheckBox("Cramps");
        checkboxes2.add(cramps);

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

        diarrhea = new JCheckBox("Diarrhea");
        checkboxes2.add(diarrhea);

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

        earAche = new JCheckBox("Earache");
        checkboxes2.add(earAche);

        earAche.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(earAche)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(87);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        dizziness = new JCheckBox("Dizziness");
        checkboxes2.add(dizziness);

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
        checkboxes2.add(drowsiness);

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

        feelingFaint = new JCheckBox("Feeling Faint");
        checkboxes2.add(feelingFaint);

        feelingFaint.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(feelingFaint)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(982);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        fever = new JCheckBox("Fever");
        checkboxes3.add(fever);

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

        hairLoss = new JCheckBox("Hair loss");
        checkboxes3.add(hairLoss);

        hairLoss.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(hairLoss)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(152);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        headache = new JCheckBox("Headache");
        checkboxes3.add(headache);

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

        hearingLoss = new JCheckBox("Hearing loss");
        checkboxes3.add(hearingLoss);

        hearingLoss.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(hearingLoss)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(206);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        heartBurn = new JCheckBox("Heartburn");
        checkboxes3.add(heartBurn);

        heartBurn.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(heartBurn)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(45);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        impairedBalance = new JCheckBox("Impaired Balance");
        checkboxes3.add(impairedBalance);

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

        itchingEyes = new JCheckBox("Itching eyes");
        checkboxes4.add(itchingEyes);

        itchingEyes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(itchingEyes)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(73);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        jointPain = new JCheckBox("Joint Pain");
        checkboxes4.add(jointPain);

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

        moodSwings = new JCheckBox("Mood swings");
        checkboxes4.add(moodSwings);

        moodSwings.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(moodSwings)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(85);
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

        nausea = new JCheckBox("Nausea");
        checkboxes4.add(nausea);

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

        nightSweats = new JCheckBox("Night sweats");
        checkboxes4.add(nightSweats);

        nightSweats.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(nightSweats)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(1004);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        nosebleed = new JCheckBox("Nosebleed");
        checkboxes1.add(nosebleed);

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

        palpitations = new JCheckBox("Palpitations");
        checkboxes1.add(palpitations);

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

        pallor = new JCheckBox("Pallor");
        checkboxes1.add(pallor);

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
        checkboxes2.add(soreThroat);

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

        tiredness = new JCheckBox("Tiredness");
        checkboxes3.add(tiredness);

        tiredness.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(tiredness)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(16);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        toothAche = new JCheckBox("Toothache");
        checkboxes3.add(toothAche);

        toothAche.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(toothAche)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(1008);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        wheezing = new JCheckBox("Wheezing");
        checkboxes4.add(wheezing);

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

        wound = new JCheckBox("Wound");
        checkboxes4.add(wound);

        wound.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(wound)) {
                            SymptomCheckerState currentState = symptomCheckerViewModel.getState();
                            currentState.togglesymptom(187);
                            symptomCheckerViewModel.setState(currentState);

                        }
                    }
                }
        );

        vomiting = new JCheckBox("Vomiting");
        checkboxes4.add(vomiting);

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

    }
}



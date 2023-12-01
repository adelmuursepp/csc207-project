package main.view;

import main.interface_adapter.diagnosis.DiagnosisState;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;

public class DiagnosisView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "diagnosis";

    private final DiagnosisViewModel diagnosisViewModel;
    private final SymptomCheckerController symptomCheckerController;

    private final JButton symptomChecker;

    public DiagnosisView(DiagnosisViewModel diagnosisViewModel, SymptomCheckerController symptomCheckerController) {
        this.diagnosisViewModel = diagnosisViewModel;
        this.symptomCheckerController = symptomCheckerController;
        diagnosisViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(DiagnosisViewModel.TITLE_LABEL);

        JPanel buttons = new JPanel();
        symptomChecker = new JButton(DiagnosisViewModel.SYMPTOM_CHECKER_BUTTON_LABEL);
        buttons.add(symptomChecker);

        symptomChecker.addActionListener(

                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(symptomChecker)) {
                            symptomCheckerController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DiagnosisState currentState = (DiagnosisState) evt.getNewValue();

        int n = currentState.getNumDiagnoses();
        System.out.println(n);
        if (n == 0) {
            JOptionPane.showMessageDialog(this, currentState.getNoDiagnosesError());
        }
        else {
            JPanel information = new JPanel();
            JPanel barChart = new JPanel();
            for (int i = 0; i < n; i++) {
                JPanel infoPanel = new JPanel();
                HashMap<String, Object> currentDiagnosis;
                if (i == 2) {
                    currentDiagnosis = currentState.getDiagnosis3();
                } else if (i == 1) {
                    currentDiagnosis = currentState.getDiagnosis2();
                    System.out.println(currentState.getDiagnosis2());
                } else {
                    currentDiagnosis = currentState.getDiagnosis1();
                }
                StringBuilder builder = new StringBuilder();
                builder.append(currentDiagnosis.get("Name")).append(" (")
                        .append(currentDiagnosis.get("Accuracy")).append("% likelihood").append(")").append("\n");
                builder.append("\t\t" + "Professional Name: ").append(currentDiagnosis.get("ProfName")).append("\n");
                builder.append("\t\t" + "ICD Number: ").append(currentDiagnosis.get("Icd")).append("\n");
                builder.append("\t\t" + "ICD Name: ").append(currentDiagnosis.get("IcdName")).append("\n");
                builder.append("Specialists:" + "\n");
                System.out.println(builder);
                for (String specialist : (List<String>) currentDiagnosis.get("Specializations")) {
                    builder.append("\t\t").append(specialist).append("\n");
                }
                System.out.println(builder);
                JLabel info = new JLabel(builder.toString());
                infoPanel.add(info);
                information.add(infoPanel, BorderLayout.SOUTH);
            }
            JLabel infoPanelLabel = new JLabel(DiagnosisViewModel.INFO_PANEL_LABEL);
            information.add(infoPanelLabel);
            this.add(information);


        // This is the code to create and add the bar chart on the condition that there is at least one diagnosis.
        // I will add something similar for the information panel.


            Float[] accuracies = new Float[n];
            String[] diagnoses = new String[n];

            accuracies[0] = (Float) currentState.getDiagnosis1().get("Accuracy");
            diagnoses[0] = (String) currentState.getDiagnosis1().get("Name");
            if (n >= 2) {
                accuracies[1] = (Float) currentState.getDiagnosis2().get("Accuracy");
                diagnoses[1] = (String) currentState.getDiagnosis2().get("Name");
            }
            if (n == 3) {
                accuracies[2] = (Float) currentState.getDiagnosis3().get("Accuracy");
                diagnoses[2] = (String) currentState.getDiagnosis3().get("Name");
            }

            barChart.add(new BarChart(accuracies, diagnoses, "Diagnoses and Accuracies"));
           // this.add(barChart);
        }
    }

    private class BarChart extends JPanel {
        private Float[] accuracies;
        private String[] diagnoses;
        private String title;

        public BarChart(Float[] accuracies, String[] diagnoses, String title) {
            this.accuracies = accuracies;
            this.diagnoses = diagnoses;
            this.title = title;
        }

        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            if (accuracies == null || accuracies.length == 0) {
                return;
            }

            double min = 0;
            double max = 0;
            for (Float accuracy : accuracies) {
                if (min > accuracy) {
                    min = accuracy;
                }
                if (max < accuracy) {
                    max = accuracy;
                }
            }

            // Create variables for the dimensions of the bar chart
            Dimension dim = getSize();
            int width = dim.width;
            int height = dim.height;
            int barWidth = width / accuracies.length;

            // Change to whatever font and/or size (this just creates font objects)
            Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
            FontMetrics titleFontMetrics = graphics.getFontMetrics(titleFont);
            Font labelFont = new Font("Book Antiqua", Font.PLAIN, 10);
            FontMetrics labelFontMetrics = graphics.getFontMetrics(labelFont);

            // Set the title and label size and set the fonts; position title
            int titleWidth = titleFontMetrics.stringWidth(title);
            int q = titleFontMetrics.getAscent();
            int p = (width - titleWidth) / 2;
            graphics.setFont(titleFont);
            graphics.drawString(title, p, q);
            int top = titleFontMetrics.getHeight();
            int bottom = labelFontMetrics.getHeight();
            if (min == max) {
                return;
            }

            // Setting the label font and positioning; setting the bar dimensions
            double scale = (double) (height - top - bottom) / (max - min);
            q = height - labelFontMetrics.getDescent();
            graphics.setFont(labelFont);
            for (int j = 0; j < accuracies.length; j++) {

                int r = j * barWidth + 1;
                int s = top;
                int barHeight = (int) (accuracies[j] * scale);
                if (accuracies[j] >= 0) {
                    s += (int) ((max - accuracies[j]) * scale);
                } else {
                    s = (int) (max * scale);
                    barHeight = -barHeight;
                }
                // set colour of bars (fill)
                graphics.setColor(Color.cyan);
                graphics.fillRect(r, s, barWidth - 2, barHeight);
                // set colour of bars (outline)
                graphics.setColor(Color.black);
                graphics.drawRect(r, s, barWidth - 2, barHeight);
                int labelWidth = labelFontMetrics.stringWidth(diagnoses[j]);
                p = j * barWidth + (barWidth - labelWidth) / 2;
                graphics.drawString(diagnoses[j], p, q);
            }
        }
    }
}

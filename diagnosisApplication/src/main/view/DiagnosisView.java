package main.view;

import main.interface_adapter.diagnosis.DiagnosisController;
import main.interface_adapter.diagnosis.DiagnosisState;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;

import javax.swing.*;
import java.awt.*;

public class DiagnosisView extends JPanel {

    public final String viewName = "diagnosis";

    private final DiagnosisViewModel diagnosisViewModel;
    private final DiagnosisController diagnosisController;
    private final SymptomCheckerController symptomCheckerController;
    private final DiagnosisState diagnosisState;

    public DiagnosisView(DiagnosisViewModel diagnosisViewModel, DiagnosisController diagnosisController,
                         SymptomCheckerController symptomCheckerController) {
        this.diagnosisViewModel = diagnosisViewModel;
        this.diagnosisController = diagnosisController;
        this.symptomCheckerController = symptomCheckerController;
        this.diagnosisState = diagnosisViewModel.getState();

        JLabel title = new JLabel(DiagnosisViewModel.TITLE_LABEL);

        JPanel information = new JPanel();

        // This is the code to create and add the bar chart on the condition that there is at least one diagnosis.
        // I will add something similar for the information panel.
        int n = diagnosisState.getNumDiagnoses();
        if (n > 0) {
            JPanel barChart = new JPanel();
            int[] accuracies = new int[n];
            String[] diagnoses = new String[n];
            accuracies[0] = (Integer) diagnosisState.getDiagnosis1("accuracy");
            diagnoses[0] = (String) diagnosisState.getDiagnosis1("name");
            if (n >= 2) {
                accuracies[1] = (Integer) diagnosisState.getDiagnosis2("accuracy");
                diagnoses[1] = (String) diagnosisState.getDiagnosis2("name");
            }
            if (n == 3) {
                accuracies[2] = (Integer) diagnosisState.getDiagnosis3("accuracy");
                diagnoses[2] = (String) diagnosisState.getDiagnosis3("name");
            }

            barChart.add(new BarChart(accuracies, diagnoses, "Diagnoses and Accuracies"));
            this.add(barChart);
        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // The way this is currently implemented, if there are no diagnoses, no bar chart or information panel will be
        // added. This is just a design choice that can be changed.
        this.add(title);
    }

    private class BarChart extends JPanel {
        private int[] accuracies;
        private String[] diagnoses;
        private String title;

        public BarChart(int[] accuracies, String[] diagnoses, String title) {
            this.accuracies = accuracies;
            this.diagnoses = diagnoses;
            this.title = title;
        }

        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            if (accuracies == null || accuracies.length == 0) {
                return;
            }

            int min = 0;
            int max = 0;
            for (int accuracy : accuracies) {
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

package main.view;

import main.interface_adapter.diagnosis.DiagnosisController;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;

import javax.swing.*;
import java.awt.*;

public class DiagnosisView extends JPanel {
    public final String viewName = "diagnosis";

    private final DiagnosisViewModel diagnosisViewModel;
    private final DiagnosisController diagnosisController;
    private final SymptomCheckerController symptomCheckerController;

    public DiagnosisView(DiagnosisViewModel diagnosisViewModel, DiagnosisController diagnosisController,
                         SymptomCheckerController symptomCheckerController) {
        this.diagnosisViewModel = diagnosisViewModel;
        this.diagnosisController = diagnosisController;
        this.symptomCheckerController = symptomCheckerController;

        JLabel title = new JLabel(DiagnosisViewModel.TITLE_LABEL);

        JPanel recommendations = new JPanel();

        JPanel barChart = new JPanel();
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
            for (int i = 0; i < accuracies.length; i++) {
                if (min > accuracies[i]) {
                    min = accuracies[i];
                }
                if (max < accuracies[i]) {
                    max = accuracies[i];
                }
            }

            Dimension dim = getSize();
            int width = dim.width;
            int height = dim.height;
            int barWidth = width / accuracies.length;

            // Change to whatever font and/or size
            Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
            FontMetrics titleFontMetrics = graphics.getFontMetrics(titleFont);
            Font labelFont = new Font("Book Antiqua", Font.PLAIN, 10);
            FontMetrics labelFontMetrics = graphics.getFontMetrics(labelFont);

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

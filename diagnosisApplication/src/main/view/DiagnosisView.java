package main.view;

import main.interface_adapter.diagnosis.DiagnosisState;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setAlignmentY(TOP_ALIGNMENT);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
        buttons.setAlignmentX(CENTER_ALIGNMENT);
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

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(title);
        this.add(buttons, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DiagnosisState currentState = (DiagnosisState) evt.getNewValue();

        int n = currentState.getNumDiagnoses();
        if (n == 0) {
            JOptionPane.showMessageDialog(this, currentState.getNoDiagnosesError());
        }
        else {
            JTabbedPane tabbedPane = new JTabbedPane();

            // This is the code to create and add the bar chart.
            Float[] accuracies = new Float[n];
            String[] diagnoses = new String[n];

            accuracies[0] = (Float) currentState.getDiagnosis1().get("Accuracy");
            diagnoses[0] = (String) currentState.getDiagnosis1().get("Name") + " " +
                    currentState.getDiagnosis1().get("Accuracy").toString() + "%";
            if (n >= 2) {
                accuracies[1] = (Float) currentState.getDiagnosis2().get("Accuracy");
                diagnoses[1] = (String) currentState.getDiagnosis2().get("Name") + " " +
                        currentState.getDiagnosis1().get("Accuracy").toString() + "%";
            }
            if (n == 3) {
                accuracies[2] = (Float) currentState.getDiagnosis3().get("Accuracy");
                diagnoses[2] = (String) currentState.getDiagnosis3().get("Name") + " " +
                        currentState.getDiagnosis1().get("Accuracy").toString() + "%";
            }
            BarChart barChart = new BarChart(accuracies, diagnoses, "Diagnoses and Accuracies");
            barChart.setPreferredSize(new Dimension(250, 300));
            tabbedPane.addTab("Bar Chart", barChart);

            // This is the code that adds the information panels.
            // JPanel information = new JPanel();
            // information.setLayout(new BoxLayout(information, BoxLayout.Y_AXIS));
            // JLabel infoPanelLabel = new JLabel(DiagnosisViewModel.INFO_PANEL_LABEL);
            // information.add(infoPanelLabel, BorderLayout.NORTH);
            // JTextArea infoPanel = new JTextArea();

            for (int i = 0; i < n; i++) {
                // JPanel information = new JPanel(false);
                JTextArea infoPanel = new JTextArea();
                infoPanel.setEnabled(false);

                HashMap<String, Object> currentDiagnosis;
                if (i == 2) {
                    currentDiagnosis = currentState.getDiagnosis3();
                } else if (i == 1) {
                    currentDiagnosis = currentState.getDiagnosis2();
                } else {
                    currentDiagnosis = currentState.getDiagnosis1();
                }
                infoPanel.append(currentDiagnosis.get("Name").toString().toUpperCase() + " (" +
                        currentDiagnosis.get("Accuracy") + "% likelihood".toUpperCase() + ")" + "\n");
                infoPanel.append("       -" + "Professional Name: " + currentDiagnosis.get("ProfName") + "\n");
                infoPanel.append("       -" + "ICD Number: " + currentDiagnosis.get("Icd") + "\n");
                infoPanel.append("       -" + "ICD Name: " + currentDiagnosis.get("IcdName") + "\n");
                infoPanel.append("   ~RECOMMENDED SPECIALISTS:" + "\n");
                for (String specialist : (List<String>) currentDiagnosis.get("Specializations")) {
                    infoPanel.append("       -" + specialist + "\n");
                }
                tabbedPane.addTab(currentDiagnosis.get("Name").toString().toUpperCase(), infoPanel);
            }

            if (this.getComponentCount() == 3) {
                this.remove(this.getComponent(2));
            }
            tabbedPane.setAlignmentX(CENTER_ALIGNMENT);
            tabbedPane.setAlignmentY(CENTER_ALIGNMENT);
            tabbedPane.setPreferredSize(new Dimension(350, 400));
            this.add(tabbedPane);
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
            int clientWidth = dim.width;
            int clientHeight = dim.height;
            int barWidth = clientWidth / accuracies.length;

            // Change to whatever font and/or size (this just creates font objects)
            Font titleFont = new Font("Book Antiqua", Font.BOLD, 10);
            FontMetrics titleFontMetrics = graphics.getFontMetrics(titleFont);
            Font labelFont = new Font("Book Antiqua", Font.PLAIN, 15);
            FontMetrics labelFontMetrics = graphics.getFontMetrics(labelFont);

            // Set the title and label size and set the fonts; position title
            int titleWidth = titleFontMetrics.stringWidth(title);
            int q = titleFontMetrics.getAscent();
            int p = (clientWidth - titleWidth) / 2;
            graphics.setFont(titleFont);
            graphics.drawString(title, p, q);
            int top = titleFontMetrics.getHeight();
            int bottom = labelFontMetrics.getHeight();
            if (max == min) {
                return;
            }

            // Setting the label font and positioning; setting the bar dimensions
            double scale = (double) (clientHeight - top - bottom) / (max - min);
            q = clientHeight - labelFontMetrics.getDescent();
            graphics.setFont(labelFont);
            for (int j = 0; j < accuracies.length; j++) {

                int valueP = j * barWidth + 1;
                int valueQ = top;
                int height = (int) (accuracies[j] * scale);
                if (accuracies[j] >= 0) {
                    valueQ += (int) ((max - accuracies[j]) * scale);
                } else {
                    valueQ = (int) (max * scale);
                    height = -height;
                }
                // set colour of bars (fill)
                graphics.setColor(Color.cyan);
                graphics.fillRect(valueP, valueQ, barWidth - 2, height);
                // set colour of bars (outline)
                graphics.setColor(Color.black);
                graphics.drawRect(valueP, valueQ, barWidth - 2, height);
                int labelWidth = labelFontMetrics.stringWidth(diagnoses[j]);
                p = j * barWidth + (barWidth - labelWidth) / 2;
                graphics.drawString(diagnoses[j], p, q);
            }
        }
    }
}

package main.view;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.interface_adapter.glossary.GlossaryState;
import main.interface_adapter.glossary.GlossaryViewModel;
import main.interface_adapter.glossary_search.GlossarySearchController;
import main.interface_adapter.signup.SignupViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;

import static main.view.SymptomCheckerView.hexToColor;

public class GlossaryView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "glossary";

    private final GlossaryViewModel glossaryViewModel;
    private final GlossarySearchController glossarySearchController;
    private final SymptomCheckerController symptomCheckerController;
    private final JButton topics;
    private final JTextField searchInputField = new JTextField(20);
    private final JButton search;
    private final JButton back;
    private JList<String> topicsList = new JList<>(new DefaultListModel<>());
    private JScrollPane listScroller = new JScrollPane(topicsList);

    public GlossaryView(GlossaryViewModel glossaryViewModel, GlossarySearchController glossarySearchController,
                        SymptomCheckerController symptomCheckerController) {

        this.glossaryViewModel = glossaryViewModel;
        this.glossarySearchController = glossarySearchController;
        this.symptomCheckerController = symptomCheckerController;
        glossaryViewModel.addPropertyChangeListener(this);

        //main panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(30));
        this.setBackground(hexToColor("#B8D2E4"));

        //inner box to hold in place
        Box innerBox = Box.createVerticalBox();
        innerBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        innerBox.setPreferredSize(new Dimension(400, 250));
        innerBox.setMinimumSize(new Dimension(400, 250));
        innerBox.setMaximumSize(new Dimension(400, 250));
        innerBox.setBackground(hexToColor("#B8D2E4"));

        //title
        innerBox.add(Box.createVerticalStrut(10));

        JLabel title = new JLabel(GlossaryViewModel.TITLE_LABEL);
        Font titleFont = new Font(title.getFont().getName(), Font.BOLD, title.getFont().getSize() + 1);
        title.setFont(titleFont);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        innerBox.add(title);

        innerBox.add(Box.createVerticalStrut(10));

        // Search bar
        LabelTextPanel searchInfo = new LabelTextPanel(
                new JLabel("Type a topic from the list"), searchInputField);
        searchInfo.setBackground(hexToColor("#B8D2E4"));
        searchInfo.setAlignmentX(CENTER_ALIGNMENT);
        searchInfo.setPreferredSize(new Dimension(400, 50));
        innerBox.add(searchInfo);
        innerBox.add(Box.createVerticalStrut(5));

        // Buttons
        JPanel buttons = new JPanel();
        buttons.setBackground(hexToColor("#B8D2E4"));
        buttons.setPreferredSize(new Dimension(350, 50));
        topics = new JButton(GlossaryViewModel.TOPICS_BUTTON_LABEL);
        buttons.add(topics);
        search = new JButton(GlossaryViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);
        back = new JButton(GlossaryViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);
        buttons.setAlignmentX(CENTER_ALIGNMENT);
        innerBox.add(buttons);
        innerBox.add(Box.createVerticalStrut(5));

        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == search) {
                            GlossaryState currentState = glossaryViewModel.getState();
                            if (searchInputField.getText().isEmpty() ) {
                                JOptionPane.showMessageDialog(null,
                                        "Please enter a topic");
                            } else {
                                try {
                                    glossarySearchController.execute(currentState.getSearch());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                        }
                    }

                    }
                }
        );

        searchInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        GlossaryState currentState = glossaryViewModel.getState();
                        currentState.setSearch(searchInputField.getText() + e.getKeyChar());
                        glossaryViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        topics.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == topics) {
                            listScroller.setVisible(!listScroller.isVisible());
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
                            symptomCheckerController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(innerBox);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        GlossaryState state = (GlossaryState) evt.getNewValue();
        // Make the list scrolling JComponenet for the topics
        if (((DefaultListModel) topicsList.getModel()).isEmpty()) {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String topic : GlossaryState.getTopics()) {
                listModel.addElement(topic);
            }

            Box topicsBox = Box.createVerticalBox();
            topicsBox.setPreferredSize(new Dimension(300, 100));
            topicsBox.setMinimumSize(new Dimension(300, 100));
            topicsBox.setMaximumSize(new Dimension(300, 100));
            topicsBox.setBackground(hexToColor("#B8D2E4"));
            topicsBox.setAlignmentX(CENTER_ALIGNMENT);

            topicsList = new JList<>(listModel);
            topicsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            topicsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            topicsList.setVisibleRowCount(-1);
            topicsList.setAlignmentX(CENTER_ALIGNMENT);

            listScroller = new JScrollPane(topicsList);
            listScroller.setPreferredSize(new Dimension(300, 100));
            listScroller.setBackground(hexToColor("#B8D2E4"));
            listScroller.setAlignmentX(CENTER_ALIGNMENT);
            topicsBox.add(listScroller);
            this.add(topicsBox);
        }
        // Make the popup window for the search results
        if (!state.getSearch().isEmpty()) {
            JInternalFrame contentFrame = getContentFrame(state);
            contentFrame.setAlignmentX(CENTER_ALIGNMENT);
            this.add(contentFrame);
            contentFrame.toFront();
            contentFrame.setVisible(true);
        }
    }

    private static JInternalFrame getContentFrame(GlossaryState state) {
        JInternalFrame contentFrame = new JInternalFrame("Results", true, true, true, true);
        contentFrame.setSize(300, 250);
        contentFrame.setBackground(hexToColor("#B8D2E4"));
        JTextArea content = new JTextArea(state.getContent(), 5, 20);
        JEditorPane editorPane = new JEditorPane();
        editorPane.setPreferredSize(new Dimension(280, 180));
        editorPane.setContentType("text/html");
        editorPane.setText(state.getContent());
        editorPane.setEditable(false);

        // content.setFont(new Font("Serif", Font.ITALIC, 16));
        content.setLineWrap(true);
        content.setWrapStyleWord(true);
        content.setEnabled(false);
        JScrollPane contentScroller = new JScrollPane(editorPane);
        contentScroller.setPreferredSize(new Dimension(280, 180));
        contentScroller.setBackground(hexToColor("#B8D2E4"));
        contentFrame.setContentPane(contentScroller);
        contentFrame.pack();
        return contentFrame;
    }
}

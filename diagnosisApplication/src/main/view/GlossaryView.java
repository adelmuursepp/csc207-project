package main.view;

import javax.swing.*;
import javax.swing.text.JTextComponent;
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
import main.interface_adapter.symptom_checker.SymptomCheckerController;

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
    private Icon icon;

    public GlossaryView(GlossaryViewModel glossaryViewModel, GlossarySearchController glossarySearchController,
                        SymptomCheckerController symptomCheckerController) {

        this.glossaryViewModel = glossaryViewModel;
        this.glossarySearchController = glossarySearchController;
        this.symptomCheckerController = symptomCheckerController;
        glossaryViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GlossaryViewModel.TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT);

        LabelTextPanel searchInfo = new LabelTextPanel(
                new JLabel("Type a topic from the list"), searchInputField);

        JPanel buttons = new JPanel();
        topics = new JButton(GlossaryViewModel.TOPICS_BUTTON_LABEL);
        buttons.add(topics);
        search = new JButton(GlossaryViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);
        back = new JButton(GlossaryViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

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

        this.add(title);
        this.add(searchInfo);
        this.add(buttons);

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
            topicsList = new JList<>(listModel);
            topicsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            topicsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            topicsList.setVisibleRowCount(-1);

            listScroller = new JScrollPane(topicsList);
            // listScroller.setPreferredSize(new Dimesnion(250, 80));
            this.add(listScroller);
        }
        // Make the popup window for the search results
        if (!state.getSearch().isEmpty()) {
            JInternalFrame contentFrame = getContentFrame(state);
            this.add(contentFrame);
            contentFrame.show();
        }
    }

    private static JInternalFrame getContentFrame(GlossaryState state) {
        JInternalFrame contentFrame = new JInternalFrame("Results", true, true, true, true);
        contentFrame.setSize(400, 300);
        JTextArea content = new JTextArea(state.getContent(), 5, 20);
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText(state.getContent());
        editorPane.setEditable(false);

        // content.setFont(new Font("Serif", Font.ITALIC, 16));
        content.setLineWrap(true);
        content.setWrapStyleWord(true);
        content.setEnabled(false);
        JScrollPane contentScroller = new JScrollPane(editorPane);
        contentFrame.setContentPane(contentScroller);
        contentFrame.pack();
        return contentFrame;
    }
}

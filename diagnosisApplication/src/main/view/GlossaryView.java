package main.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;

import main.interface_adapter.glossary.GlossaryViewModel;
import main.interface_adapter.glossary_search.GlossarySearchController;
import main.interface_adapter.glossary_search.GlossarySearchState;
import main.interface_adapter.glossary_search.GlossarySearchViewModel;
import main.interface_adapter.glossary.GlossaryController;
import main.interface_adapter.symptom_checker.SymptomCheckerController;

public class GlossaryView extends JPanel implements ActionListener, PropertyChangeListener {

    private final GlossaryViewModel glossaryViewModel;
    private final GlossarySearchViewModel glossarySearchViewModel;
    private final GlossarySearchController glossarySearchController;
    private final SymptomCheckerController symptomCheckerController;
    private final JButton topics;
    private final JTextField searchInputField = new JTextField(20);
    private final JButton search;
    private final JButton back;

    public GlossaryView(GlossaryViewModel glossaryViewModel, GlossarySearchController glossarySearchController,
                        GlossarySearchViewModel glossarySearchViewModel,
                        SymptomCheckerController symptomCheckerController) {

        this.glossaryViewModel = glossaryViewModel;
        this.glossarySearchController = glossarySearchController;
        this.glossarySearchViewModel = glossarySearchViewModel;
        this.symptomCheckerController = symptomCheckerController;
        glossarySearchViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Glossary");
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
                            GlossarySearchState currentState = glossarySearchViewModel.getState();
                            if (searchInputField.getText().isEmpty() ) {
                                JOptionPane.showMessageDialog(null,
                                        "Please enter a topic");
                            } else {
                                String contents = glossarySearchController.execute(
                                        currentState.getSearch()
                                );
                                JOptionPane.showMessageDialog(null, contents);
                        }
                    }

                    }
                }
        );

        searchInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        GlossarySearchState currentState = glossarySearchViewModel.getState();
                        currentState.setSearch(searchInputField.getText() + e.getKeyChar());
                        glossarySearchViewModel.setState(currentState);
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
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO: implement
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
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
        GlossarySearchState state = (GlossarySearchState) evt.getNewValue();
    }
}

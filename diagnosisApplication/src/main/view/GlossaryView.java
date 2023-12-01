package main.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.interface_adapter.glossary.GlossaryController;
import main.interface_adapter.glossary.GlossaryState;
import main.interface_adapter.glossary.GlossaryViewModel;
import main.interface_adapter.login.LoginState;
import main.interface_adapter.signup.SignupState;
import main.interface_adapter.signup.SignupViewModel;

public class GlossaryView extends JPanel implements ActionListener, PropertyChangeListener {

    private final GlossaryController glossaryController;
    private final GlossaryViewModel glossaryViewModel;
    private final JButton topics;
    private final JTextField searchInputField = new JTextField(20);
    private final JButton search;
    public GlossaryView(GlossaryController controller, GlossaryViewModel glossaryViewModel) {

        this.glossaryController = controller;
        this.glossaryViewModel = glossaryViewModel;
        glossaryViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Glossary");
        title.setAlignmentX(CENTER_ALIGNMENT);

        LabelTextPanel searchInfo = new LabelTextPanel(
                new JLabel("Type a topic from the list"), searchInputField);

        JPanel buttons = new JPanel();
        topics = new JButton("Click to get topics");
        buttons.add(topics);
        search = new JButton("Search");
        buttons.add(search);

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
                                String contents = glossaryController.execute(
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
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == topics) {
                            List<String> topicList = null;
                            try {
                                topicList = glossaryController.getTopics();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            String topicString = "";
                            for (String s : topicList) {
                                topicString += s + ", ";
                            }
                            JOptionPane.showMessageDialog(null, topicString);
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
    }
}

package main.view;

import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.signup.SignupController;
import main.interface_adapter.signup.SignupState;
import main.interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static main.view.SymptomCheckerView.hexToColor;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    SpinnerModel spinnerModel = new SpinnerNumberModel(2020, 1900, 2020, 1);
    private final JSpinner yearSpinner = new JSpinner(spinnerModel);
    String[] sexes = {"Male", "Female"};
    private final JComboBox sexComboBox = new JComboBox(sexes);
    private final SignupController signupController;

    private final JButton signUp;
    private final JButton login;

    public SignupView(SignupController controller, SignupViewModel signupViewModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        //main panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(30));
        this.setBackground(hexToColor("#B8D2E4"));

        //inner box to hold in place
        Box innerBox = Box.createVerticalBox();
        innerBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        innerBox.setPreferredSize(new Dimension(350, 300));
        innerBox.setMinimumSize(new Dimension(350, 300));
        innerBox.setMaximumSize(new Dimension(350, 300));
        innerBox.setBackground(hexToColor("#B8D2E4"));

        //title
        innerBox.add(Box.createVerticalStrut(10));

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        Font titleFont = new Font(title.getFont().getName(), Font.BOLD, title.getFont().getSize() + 1);
        title.setFont(titleFont);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        innerBox.add(title);

        innerBox.add(Box.createVerticalStrut(15));

        //input fields
        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        usernameInfo.setBackground(hexToColor("#B8D2E4"));
        innerBox.add(usernameInfo);

        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        passwordInfo.setBackground(hexToColor("#B8D2E4"));
        innerBox.add(passwordInfo);

        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);
        repeatPasswordInfo.setBackground(hexToColor("#B8D2E4"));
        innerBox.add(repeatPasswordInfo);
        innerBox.add(Box.createVerticalStrut(5));

        //panel for year and sex
        JPanel buttons = new JPanel();
        buttons.setBackground(hexToColor("#B8D2E4"));
        buttons.add(Box.createVerticalStrut(5));

        JLabel spinnerLabel = new JLabel("Year of birth:");
        buttons.add(spinnerLabel);
        JSpinner year = new JSpinner(spinnerModel);
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(year, "#");
        year.setEditor(editor);//removes comma hooray!
        buttons.add(year);

        JLabel sexLabel = new JLabel("Sex:");
        buttons.add(sexLabel);
        JComboBox sex = new JComboBox(sexes);
        buttons.add(sex);

        innerBox.add(buttons);
        innerBox.add(Box.createVerticalStrut(5));

        //panel for buttons
        JPanel buttons1 = new JPanel();
        buttons1.setLayout(new BoxLayout(buttons1, BoxLayout.Y_AXIS));
        buttons1.setBackground(hexToColor("#B8D2E4"));

        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        signUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons1.add(signUp);
        buttons1.add(Box.createVerticalStrut(15));

        JLabel loginLabel = new JLabel("Already have an account?");
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons1.add(loginLabel);
        login = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons1.add(login);

        innerBox.add(buttons1);
        innerBox.add(Box.createVerticalStrut(25));

        this.add(innerBox);

        login.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == login) {
                            signupController.switchLogin();
                        }
                    }
                }
        );

        year.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        //commented out the part that made year label dynamic
                        //spinnerLabel.setText("Year of Birth " + ((JSpinner)e.getSource()).getValue() );
                        if (e.getSource() == year) {
                            SignupState currentState = signupViewModel.getState();
                            currentState.setYearOfBirth((Integer) year.getValue());

                        }
                    }
                }
        );

        sex.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == sex) {
                            SignupState currentState = signupViewModel.getState();
                            currentState.setSex((String) sex.getSelectedItem());

                        }
                    }
                }
        );

                signUp.addActionListener(
                        // This creates an anonymous subclass of ActionListener and instantiates it.
                        new ActionListener(){
                            public void actionPerformed(ActionEvent evt) {
                                if (evt.getSource().equals(signUp)) {
                                    SignupState currentState = signupViewModel.getState();
                                    if (usernameInputField.getText().isEmpty() ) {
                                        JOptionPane.showMessageDialog(null,
                                                "Please enter a username");
                                    } else if(passwordInputField.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(null,
                                                "Please enter a password");
                                    } else {
                                        signupController.execute(
                                                currentState.getUsername(),
                                                currentState.getPassword(),
                                                currentState.getRepeatPassword(),
                                                currentState.getSex(),
                                                currentState.getYearOfBirth()
                                        );
                                    }
                                }
                            }
                        }
                );

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState); // Hmm, is this necessary?
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this,
                "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}


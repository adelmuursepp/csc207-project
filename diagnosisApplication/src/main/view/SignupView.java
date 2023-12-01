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
    private final JSpinner year;
    private final JComboBox<String> sex;


    public SignupView(SignupController controller, SignupViewModel signupViewModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);


        //added initializations
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        login = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);

        SpinnerModel spinnerModel = new SpinnerNumberModel(2020, 1900, 2020, 1);
        year = new JSpinner(spinnerModel);

        String[] sexes = {"Male", "Female"};
        sex = new JComboBox<>(sexes);

        //panel initialization 1 row, 2 columns, 10px gaps
        GridLayout buttons = new GridLayout(1, 2, 10, 10);

        //set preferred sizes for components
        usernameInputField.setPreferredSize(new Dimension(150, 20));
        passwordInputField.setPreferredSize(new Dimension(150, 20));
        repeatPasswordInputField.setPreferredSize(new Dimension(150, 20));
        //`year.setPreferredSize(new Dimension(80, 10));
        sex.setPreferredSize(new Dimension(80, 10));


        //main panel layout
        this.setLayout(buttons);

        //left panel for username and password
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(usernameInfo);
        leftPanel.add(passwordInfo);
        leftPanel.add(repeatPasswordInfo);
        leftPanel.add(signUp);

        //right panel for year, sex, and login
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.add(new JLabel("Year of birth: "));
        rightPanel.add(year);
        rightPanel.add(new JLabel("Sex: "));
        rightPanel.add(sex);
        rightPanel.add(login);

        //add subpanels to main panel
        this.add(leftPanel);
        this.add(rightPanel);

        //set minimum and preferred size for the main panel
        this.setMinimumSize(new Dimension(100, 100));
        this.setPreferredSize(new Dimension(150, 150));

        /*
        PREVIOUS CODE
        JPanel buttons = new JPanel();
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        JLabel spinnerLabel = new JLabel("Year of birth: ");
        buttons.add(spinnerLabel);
        JSpinner year = new JSpinner(spinnerModel);
        buttons.add(year);
        JLabel sexLabel = new JLabel("Sex: ");
        buttons.add(sexLabel);
        JComboBox sex = new JComboBox(sexes);
        buttons.add(sex);
        login = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(login);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
        */


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
                        //commented out the part of the code that made the "Year of Birth" label dynamic
                        //spinnerLabel.setText("Year of Birth: " + ((JSpinner)e.getSource()).getValue() );
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


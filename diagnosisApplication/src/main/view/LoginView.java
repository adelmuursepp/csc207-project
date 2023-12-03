package main.view;

import main.interface_adapter.login.LoginController;
import main.interface_adapter.login.LoginState;
import main.interface_adapter.login.LoginViewModel;
import main.interface_adapter.signup.SignupState;
import main.view.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    final JButton logIn;
    final JButton cancel;
    private final LoginController loginController;

    public LoginView(LoginViewModel loginViewModel, LoginController controller) {

        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        //main panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(60));

        //inner box to hold in place
        Box innerBox = Box.createVerticalBox();
        innerBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        innerBox.setPreferredSize(new Dimension(350, 150));
        innerBox.setMinimumSize(new Dimension(350, 200));
        innerBox.setMaximumSize(new Dimension(350, 200));

        //title
        innerBox.add(Box.createVerticalStrut(15));
        JLabel title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        innerBox.add(title);
        innerBox.add(Box.createVerticalStrut(20));

        //username and password
        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);
        innerBox.add(usernameInfo);
        innerBox.add(usernameErrorField);

        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);
        innerBox.add(passwordInfo);
        innerBox.add(passwordErrorField);
        innerBox.add(Box.createVerticalStrut(15));

        //buttons
        JPanel buttons = new JPanel();
        logIn = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);
        cancel = new JButton(loginViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        innerBox.add(buttons);
        innerBox.add(Box.createVerticalStrut(20));

        this.add(innerBox);

        logIn.addActionListener(

                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            LoginState currentState = loginViewModel.getState();

                            loginController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );
                        }
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == cancel) {
                            loginController.switchSignUp();
                        }
                    }
                }
        );

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                loginViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        LoginState currentState = loginViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        loginViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
    }

}
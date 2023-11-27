package main.view;

import main.interface_adapter.signup.SignupViewModel;

import javax.swing.*;

public class SignupView extends JPanel {

    public final String viewName = "Sign Up";
    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    SpinnerModel spinnerModel = new SpinnerNumberModel(2020, 1900, 2020, 1);
    private final JSpinner spinner = new JSpinner(spinnerModel);


    public SignupView(SignupController SignupViewModel signupViewModel) {
        this.signupViewModel = signupViewModel;
    }
}

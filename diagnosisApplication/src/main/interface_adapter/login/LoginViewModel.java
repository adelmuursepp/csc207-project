package main.interface_adapter.login;

import main.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class LoginViewModel extends ViewModel {

public final String TITLE_LABEL = "Log In View";

public final String USERNAME_LABEL = "Enter username";

public final String PASSWORD_LABEL = "Enter password";

public static final String LOGIN_BUTTON_LABEL = "Log in";

public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public LoginViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}

package main.interface_adapter.profile;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import main.interface_adapter.ViewModel;

public class ProfileViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Profile View";
    public static final String CHANGE_USERNAME_BUTTON_LABEL = "Change Username";
    public static final String CHANGE_PASSWORD_BUTTON_LABEL = "Change Password";
    public static final String CHANGE_SEX_BUTTON_LABEL = "Change User Sex";
    public static final String CHANGE_YEAR_OF_BIRTH_BUTTON_LABEL = "Change Year of Birth";
    public static final String SYMPTOM_CHECKER_BUTTON_LABEL = "Return to Symptom Checker";
    public static final String PAST_DIAGNOSES_BUTTON_LABEL = "See Past Diagnoses";
    private ProfileState state = new ProfileState();
    public ProfileViewModel() { super("profile");}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ProfileState getState() {return  state;}

    public void setState(ProfileState state) {this.state = state;}
}

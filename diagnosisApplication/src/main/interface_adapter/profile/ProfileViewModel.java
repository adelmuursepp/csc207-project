package main.interface_adapter.profile;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import main.interface_adapter.ViewModel;

public class ProfileViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Profile View";
    public static final String SYMPTOM_CHECKER_BUTTON_LABEL = "Return to Symptom Checker";
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
}

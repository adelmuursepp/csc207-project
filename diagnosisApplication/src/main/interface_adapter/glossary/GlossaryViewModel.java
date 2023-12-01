package main.interface_adapter.glossary;

import main.interface_adapter.ViewModel;
import main.interface_adapter.signup.SignupState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GlossaryViewModel extends ViewModel {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private GlossaryState state = new GlossaryState();

    public GlossaryViewModel() {
        super("glossary");
    }

    public void setState(GlossaryState state) { this.state = state; }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GlossaryState getState() {
        return state;
    }
}

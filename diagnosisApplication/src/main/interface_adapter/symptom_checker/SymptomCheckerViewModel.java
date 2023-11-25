package main.interface_adapter.symptom_checker;

import main.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SymptomCheckerViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Symptom Checker View";
    public static final String DIAGNOSES_BUTTON_LABEL = "Check for diagnoses";
    private SymptomCheckerState state = new SymptomCheckerState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SymptomCheckerViewModel() {
        super("symptom checker");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setState(SymptomCheckerState state) {
        this.state = state;
    }

    public SymptomCheckerState getState() {
        return state;
    }
}

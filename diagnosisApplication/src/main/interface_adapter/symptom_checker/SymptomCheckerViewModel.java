package main.interface_adapter.symptom_checker;

import main.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SymptomCheckerViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Symptom Checker View";
    public static final String DESCRIPTION_LABEL = "Check the symptoms you have been experiencing recently:";
    public static final String DIAGNOSES_BUTTON_LABEL = "Check for diagnoses";
    public static final String PROPOSED_SYMPTOMS_BUTTON_LABEL = "See proposed symptoms";
    public static final String PROFILE_BUTTON_LABEL = "Profile";
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

    /**
     * Allows the view model to update the state by setting this.state to state
     * @param state a new state to update to
     */
    public void setState(SymptomCheckerState state) {
        this.state = state;
    }

    /**
     * Gets the current state of the symptom checker
     * @return current SymptomCheckerState of the application saved in the SymptomCheckerViewModel
     */
    public SymptomCheckerState getState() {
        return state;
    }
}

package main.interface_adapter.past_diagnoses;

import main.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PastDiagnosesViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Past Diagnoses View";
    public static final String DESCRIPTION_LABEL = "See your past diagnoses and the corresponding times";
    public static final String SYMPTOM_CHECKER_BUTTON_LABEL = "Back to Diagnosis View";
    private PastDiagnosesState state = new PastDiagnosesState();
    public PastDiagnosesViewModel() {super("past-diagnoses");}

    public PastDiagnosesState getState() {
        return state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}

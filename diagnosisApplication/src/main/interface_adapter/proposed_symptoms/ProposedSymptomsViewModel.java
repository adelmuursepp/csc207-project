package main.interface_adapter.proposed_symptoms;

import main.interface_adapter.ViewModel;
import main.interface_adapter.diagnosis.DiagnosisState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProposedSymptomsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Proposed Symptoms View";
    public static final String SYMPTOM_CHECKER_BUTTON_LABEL = "Back to Diagnosis View";
    private ProposedSymptomsState state = new ProposedSymptomsState();

    public ProposedSymptomsViewModel() {
        super("proposed-symptoms");
    }

    public ProposedSymptomsState getState() {
        return this.state;
    }

    public void setState(ProposedSymptomsState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}

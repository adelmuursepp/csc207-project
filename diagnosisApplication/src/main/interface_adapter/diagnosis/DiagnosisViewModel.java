package main.interface_adapter.diagnosis;

import main.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class DiagnosisViewModel extends ViewModel{

    public static final String TITLE_LABEL = "Diagnosis View";
    public static final String SYMPTOM_CHECKER_BUTTON_LABEL = "Return to Symptom Checker";
    public static final String INFO_PANEL_LABEL = "Recommended Specialists";
    private DiagnosisState state = new DiagnosisState();

    public DiagnosisViewModel() {
        super("main/use_case/diagnosis");
    }

    public DiagnosisState getState() {
        return this.state;
    }

    public void setState(DiagnosisState state) {
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

package main.interface_adapter.diagnosis;

import main.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class DiagnosisViewModel extends ViewModel{

    public static final String TITLE_LABEL = "Diagnosis View";
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

    public void setDiagnosis(List<String> diagnosis) {
        this.diagnosis = diagnosis;
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

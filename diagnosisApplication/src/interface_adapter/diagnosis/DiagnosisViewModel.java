package interface_adapter.diagnosis;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class DiagnosisViewModel extends ViewModel{
    private DiagnosisState state = new DiagnosisState();

    private List<String> diagnosis;

    public DiagnosisViewModel() {
        super("use_case/diagnosis");
    }

    public DiagnosisState getState() {
        return this.state;
    }

    public void setState(DiagnosisState state) {
        this.state = state;
    }

    public List<String> showDiagnosis() {
        return diagnosis;
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

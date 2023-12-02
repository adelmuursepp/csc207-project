package main.interface_adapter.glossary;

import main.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GlossaryViewModel extends ViewModel {

    public static final String TITLE_LABEL = "HealthCare.gov Glossary";
    public static final String TOPICS_BUTTON_LABEL = "Click to get topics";
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String BACK_BUTTON_LABEL = "Return to Symptom Checker";

    private GlossaryState state = new GlossaryState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

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

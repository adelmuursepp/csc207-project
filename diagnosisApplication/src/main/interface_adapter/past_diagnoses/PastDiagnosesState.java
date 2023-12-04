package main.interface_adapter.past_diagnoses;

import java.util.List;

public class PastDiagnosesState {
    private List<String> pastDiagnosesList;
    public PastDiagnosesState() {}

    public void setPastDiagnosesList(List<String> pastDiagnosesList) {
        this.pastDiagnosesList = pastDiagnosesList;
    }

    public List<String> getPastDiagnosesList() {
        return pastDiagnosesList;
    }
}

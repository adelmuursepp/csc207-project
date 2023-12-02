package main.interface_adapter.proposed_symptoms;

import java.util.List;

public class ProposedSymptomsState {
    private List<String> proposedSymptomsList;
    public ProposedSymptomsState() {}

    public void setProposedSymptomsList(List<String> proposedSymptomsList) {
        this.proposedSymptomsList = proposedSymptomsList;
    }

    public List<String> getProposedSymptomsList() {
        return this.proposedSymptomsList;
    }
}

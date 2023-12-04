package main.use_case.proposed_symptoms;

import java.util.HashMap;
import java.util.List;

public class ProposedSymptomsOutputData {
    private final List<String> proposedSymptomsList;

    public ProposedSymptomsOutputData(List<String> proposedSymptomsList) {
        this.proposedSymptomsList = proposedSymptomsList;
    }

    public List<String> getProposedSymptomsList() {
        return this.proposedSymptomsList;
    }
}

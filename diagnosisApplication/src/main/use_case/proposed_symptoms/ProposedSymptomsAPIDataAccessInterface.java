package main.use_case.proposed_symptoms;

import main.entity.CommonSymptom;

import java.util.List;

public interface ProposedSymptomsAPIDataAccessInterface {
    List<CommonSymptom> getProposedSymptoms(List<Integer> checkedSymptoms);
}

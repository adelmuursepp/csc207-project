package main.use_case.proposed_symptoms;

import main.use_case.diagnosis.DiagnosisOutputData;

public interface ProposedSymptomsOutputBoundary {
    void prepareProposedSymptomsView(ProposedSymptomsOutputData outputData);
}

package main.use_case.proposed_symptoms;

import main.use_case.diagnosis.DiagnosisInputData;

public interface ProposedSymptomsInputBoundary {
    void execute(ProposedSymptomsInputData proposedSymptomsInputData);
}

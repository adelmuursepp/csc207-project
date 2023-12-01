package main.interface_adapter.proposed_symptoms;

import main.use_case.diagnosis.DiagnosisInputBoundary;
import main.use_case.diagnosis.DiagnosisInputData;
import main.use_case.proposed_symptoms.ProposedSymptomsInputBoundary;
import main.use_case.proposed_symptoms.ProposedSymptomsInputData;

import java.util.ArrayList;

public class ProposedSymptomsController {
    final ProposedSymptomsInputBoundary proposedSymptomsUseCaseInteractor;
    public ProposedSymptomsController(ProposedSymptomsInputBoundary proposedSymptomsUseCaseInteractor) {
        this.proposedSymptomsUseCaseInteractor = proposedSymptomsUseCaseInteractor;
    }

    public void execute(ArrayList<Integer> checkedSymptoms) {
        System.out.println("Proposed symptoms controller works");
        ProposedSymptomsInputData proposedSymptomsInputData = new ProposedSymptomsInputData(checkedSymptoms);
        proposedSymptomsUseCaseInteractor.execute(proposedSymptomsInputData);
    }
}

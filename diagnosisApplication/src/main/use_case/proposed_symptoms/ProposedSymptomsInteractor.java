package main.use_case.proposed_symptoms;

import main.entity.CommonSymptom;
import main.entity.HealthDiagnosis;
import main.use_case.diagnosis.DiagnosisInputData;
import main.use_case.diagnosis.DiagnosisOutputBoundary;
import main.use_case.diagnosis.DiagnosisOutputData;
import main.use_case.diagnosis.DiagnosisUserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class ProposedSymptomsInteractor implements ProposedSymptomsInputBoundary {
    final ProposedSymptomsOutputBoundary proposedSymptomsPresenter;
    private final ProposedSymptomsAPIDataAccessInterface medicAPIDiagnosisDataAccessObject;

    public ProposedSymptomsInteractor(
            ProposedSymptomsOutputBoundary proposedSymptomsOutputBoundary, ProposedSymptomsAPIDataAccessInterface medicAPIDiagnosisDataAccessObject) {
//        this.userDataAccessObject = userDataAccessObject;
        this.medicAPIDiagnosisDataAccessObject = medicAPIDiagnosisDataAccessObject;
        this.proposedSymptomsPresenter = proposedSymptomsOutputBoundary;
    }


    public void execute(ProposedSymptomsInputData proposedSymptomsInputData) {
        List<Integer> checkedSymptoms = proposedSymptomsInputData.getCheckedSymptoms();
        List<CommonSymptom> proposedSymptomsList;
        List<String> proposedSymptomsNames = new ArrayList<>();
        try {
            proposedSymptomsList = this.medicAPIDiagnosisDataAccessObject.getProposedSymptoms(checkedSymptoms);
            for (CommonSymptom proposedSymptom : proposedSymptomsList) {
                proposedSymptomsNames.add(proposedSymptom.getSymptomName());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("Inside interactor before presenter");
        ProposedSymptomsOutputData proposedSymptomsOutputData = new ProposedSymptomsOutputData(proposedSymptomsNames);
        proposedSymptomsPresenter.prepareProposedSymptomsView(proposedSymptomsOutputData);
    }
}

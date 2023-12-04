package main.use_case.past_diagnoses;

import main.use_case.diagnosis.DiagnosisFileDataAccessInterface;
import main.use_case.diagnosis.DiagnosisUserDataAccessInterface;

import java.time.LocalDateTime;
import java.util.HashMap;

public class PastDiagnosesInteractor implements PastDiagnosesInputBoundary {
    private final DiagnosisFileDataAccessInterface diagnosisFileDataAccessObject;
    final PastDiagnosesOutputBoundary pastDiagnosesPresenter;

    public PastDiagnosesInteractor(PastDiagnosesOutputBoundary pastDiagnosesOutputBoundary,
                                   DiagnosisFileDataAccessInterface diagnosisFileDataAccessObject) {
        this.pastDiagnosesPresenter = pastDiagnosesOutputBoundary;
        this.diagnosisFileDataAccessObject = diagnosisFileDataAccessObject;
    }

    public void execute() {
        HashMap<String, LocalDateTime> pastDiagnoses = this.diagnosisFileDataAccessObject.getPastDiagnoses();
        PastDiagnosesOutputData pastDiagnosesOutputData = new PastDiagnosesOutputData(pastDiagnoses);
        pastDiagnosesPresenter.preparePastDiagnosesView(pastDiagnosesOutputData);
    }
}

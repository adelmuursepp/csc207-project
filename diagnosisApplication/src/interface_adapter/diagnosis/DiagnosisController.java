package interface_adapter.diagnosis;

import use_case.diagnosis.DiagnosisInputBoundary;
import use_case.diagnosis.DiagnosisInputData;

import java.util.List;
public class DiagnosisController {
    final DiagnosisInputBoundary diagnosisUseCaseInteractor;
    public DiagnosisController(DiagnosisInputBoundary diagnosisUseCaseInteractor) {
        this.diagnosisUseCaseInteractor = diagnosisUseCaseInteractor;
    }

    public List<String> execute(Boolean diagnosisState) {
        DiagnosisInputData diagnosisInputData = new DiagnosisInputData(diagnosisState);
        return diagnosisUseCaseInteractor.execute(diagnosisInputData);
    }
}

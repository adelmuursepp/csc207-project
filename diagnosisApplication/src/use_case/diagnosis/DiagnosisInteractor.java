package use_case.diagnosis;
package interface_adapter.diagnosis;

import java.util.List;

public class DiagnosisInteractor {
    final DiagnosisInputBoundary diagnosisUseCaseInteractor;
    public DiagnosisController(DiagnosisInputBoundary diagnosisUseCaseInteractor) {
        this.diagnosisUseCaseInteractor = diagnosisUseCaseInteractor;
    }

    public List<String> execute(Boolean clearState) {
        DiagnosisInputData diagnosisInputData = new DiagnosisInputData(clearState);
        return diagnosisUseCaseInteractor.execute(diagnosisInputData);
    }
}

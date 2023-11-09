package use_case.diagnosis;
package interface_adapter.diagnosis;

import java.util.List;

public class DiagnosisInteractor implements DiagnosisInputBoundary{
    final DiagnosisInputBoundary diagnosisUseCaseInteractor;

    public DiagnosisInteractor(DiagnosisInputBoundary diagnosisUseCaseInteractor) {
        this.diagnosisUseCaseInteractor = diagnosisUseCaseInteractor;
    }

    public List<String> execute(Boolean clearState) {
        DiagnosisInputData diagnosisInputData = new DiagnosisInputData(clearState);
        return diagnosisUseCaseInteractor.execute(diagnosisInputData);
    }
}

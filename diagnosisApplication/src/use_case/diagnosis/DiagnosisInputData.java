package use_case.diagnosis;

public class DiagnosisInputData {

    final private Boolean diagnosisState;

    public DiagnosisInputData(Boolean diagnosisState) { this.diagnosisState = diagnosisState; }

    Boolean getDiagnosisState() { return diagnosisState; }
}

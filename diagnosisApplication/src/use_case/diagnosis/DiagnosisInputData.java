package use_case.diagnosis;

public class DiagnosisInputData {

    final private Boolean diagnosis;

    public DiagnosisInputData(Boolean diagnosis) { this.diagnosis = diagnosis; }

    Boolean getDiagnosisValue() { return diagnosis; }
}

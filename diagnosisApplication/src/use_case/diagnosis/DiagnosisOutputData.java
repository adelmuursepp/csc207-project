package use_case.diagnosis;

import java.util.List;

public class DiagnosisOutputData {

    private final List<String> diagnoses;

    public DiagnosisOutputData(List<String> diagnoses) { this.diagnoses = diagnoses; }

    public List<String> getDiagnosis() {
        return diagnoses;
    }
}

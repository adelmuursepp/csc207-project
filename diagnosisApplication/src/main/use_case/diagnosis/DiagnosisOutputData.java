package main.use_case.diagnosis;

import java.util.List;

public class DiagnosisOutputData {

    private final List<Integer> checkedSymptoms;

    public DiagnosisOutputData(List<Integer> checkedSymptoms) { this.checkedSymptoms = checkedSymptoms; }

    public List<Integer> getcheckedsypmtoms() {
        return checkedSymptoms;
    }
}

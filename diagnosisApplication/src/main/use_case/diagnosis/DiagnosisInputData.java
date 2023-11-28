package diagnosisApplication.src.main.use_case.diagnosis;

import java.util.ArrayList;

public class DiagnosisInputData {

    final private ArrayList<Integer> checkedSymptoms;

    public DiagnosisInputData (ArrayList<Integer> checkedSymptoms) { this.checkedSymptoms = checkedSymptoms; }

    ArrayList<Integer> getCheckedSymptoms() { return checkedSymptoms; }

}

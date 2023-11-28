package diagnosisApplication.src.main.use_case.symptom_checker;

import java.util.ArrayList;

public class SymptomCheckerOutputData {

    private ArrayList<Integer> checkedSymptoms;

    public SymptomCheckerOutputData(ArrayList<Integer> checkedSymptoms) {
        this.checkedSymptoms = checkedSymptoms;
    }

    public ArrayList<Integer> getCheckedSymptoms() {
        return checkedSymptoms;
    }

}

package main.interface_adapter.symptom_checker;

import java.util.ArrayList;

public class SymptomCheckerState {

    private Boolean showSymptoms = false;

    private ArrayList<Integer> checkedSymptoms = new ArrayList<Integer>();

    public Boolean getValue() {
        return showSymptoms;
    }

    public ArrayList<Integer> getCheckedSymptoms() { return checkedSymptoms; }

    public void togglesymptom(Integer sid) {
        if (! checkedSymptoms.contains(sid)) {
            checkedSymptoms.add(sid);
        } else {
            checkedSymptoms.remove(sid);
        }

    }

}

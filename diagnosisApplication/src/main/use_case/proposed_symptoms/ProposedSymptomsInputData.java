package main.use_case.proposed_symptoms;

import java.util.ArrayList;

public class ProposedSymptomsInputData {
    final private ArrayList<Integer> checkedSymptoms;

    public ProposedSymptomsInputData (ArrayList<Integer> checkedSymptoms) { this.checkedSymptoms = checkedSymptoms; }

    ArrayList<Integer> getCheckedSymptoms() { return checkedSymptoms; }
}

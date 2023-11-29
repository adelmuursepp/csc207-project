package main.interface_adapter.diagnosis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiagnosisState {

    private int numDiagnoses = 0;

    private HashMap<String, Object> diagnosis1;
    private HashMap<String, Object> diagnosis2;
    private HashMap<String, Object> diagnosis3;

    public DiagnosisState() {}

    public void setDiagnosis1(HashMap<String, Object> diagnosis1) {
        this.diagnosis1 = diagnosis1;
        numDiagnoses += 1;
    }

    public void setDiagnosis2(HashMap<String, Object> diagnosis2) {
        this.diagnosis2 = diagnosis2;
        numDiagnoses += 1;
    }

    public void setDiagnosis3(HashMap<String, Object> diagnosis3) {
        this.diagnosis3 = diagnosis3;
        numDiagnoses += 1;
    }

    public int getNumDiagnoses() {
        return numDiagnoses;
    }

    public Object getDiagnosis1(String key) {
        return diagnosis1.get(key);
    }

    public Object getDiagnosis2(String key) {
        return diagnosis2.get(key);
    }

    public Object getDiagnosis3(String key) {
        return diagnosis3.get(key);
    }

}

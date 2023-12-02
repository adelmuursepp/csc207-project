package main.interface_adapter.diagnosis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiagnosisState {

    private int numDiagnoses = 0;
    private static final String noDiagnosesMatchError = "No diagnoses match your current selected symptoms! " +
            "Try again with less symptoms or refer to a healthcare practitioner!";

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

    public HashMap<String, Object> getDiagnosis1() {
        return diagnosis1;
    }

    public HashMap<String, Object> getDiagnosis2() {
        return diagnosis2;
    }

    public HashMap<String, Object> getDiagnosis3() {
        return diagnosis3;
    }

    public String getNoDiagnosesError() {
        return noDiagnosesMatchError;
    }
}

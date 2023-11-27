package main.use_case.diagnosis;

import java.util.HashMap;

public class DiagnosisOutputData {

    private final HashMap<Integer, HashMap<java.lang.String, Object>> diagnosis1;
    private final HashMap<Integer, HashMap<java.lang.String, Object>> diagnosis2;
    private final HashMap<Integer, HashMap<java.lang.String, Object>> diagnosis3;

    public DiagnosisOutputData(HashMap<Integer, HashMap<String, Object>> diagnosis1,
                               HashMap<Integer, HashMap<String, Object>> diagnosis2,
                               HashMap<Integer, HashMap<String, Object>> diagnosis3) {
        this.diagnosis1 = diagnosis1;
        this.diagnosis2 = diagnosis2;
        this.diagnosis3 = diagnosis3;
    }

    public DiagnosisOutputData(HashMap<Integer, HashMap<String, Object>> diagnosis1,
                               HashMap<Integer, HashMap<String, Object>> diagnosis2) {
        this.diagnosis1 = diagnosis1;
        this.diagnosis2 = diagnosis2;
        this.diagnosis3 = null;
    }

    public DiagnosisOutputData(HashMap<Integer, HashMap<String, Object>> diagnosis1) {
        this.diagnosis1 = diagnosis1;
        this.diagnosis2 = null;
        this.diagnosis3 = null;
    }

    public DiagnosisOutputData() {
        this.diagnosis1 = null;
        this.diagnosis2 = null;
        this.diagnosis3 = null;
    }

    public HashMap<Integer, HashMap<String, Object>> getDiagnosis1() {
        return diagnosis1;
    }

    public HashMap<Integer, HashMap<String, Object>> getDiagnosis2() {
        return diagnosis2;
    }

    public HashMap<Integer, HashMap<String, Object>> getDiagnosis3() {
        return diagnosis3;
    }
}
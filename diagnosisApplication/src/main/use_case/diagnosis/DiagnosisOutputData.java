package diagnosisApplication.src.main.use_case.diagnosis;

import java.util.HashMap;

public class DiagnosisOutputData {

    private final HashMap<String, Object> diagnosis1;
    private final HashMap<String, Object> diagnosis2;
    private final HashMap<String, Object> diagnosis3;

    public DiagnosisOutputData(HashMap<String, Object> diagnosis1,
                               HashMap<String, Object> diagnosis2,
                               HashMap<String, Object> diagnosis3) {
        this.diagnosis1 = diagnosis1;
        this.diagnosis2 = diagnosis2;
        this.diagnosis3 = diagnosis3;
    }

    public DiagnosisOutputData(HashMap<String, Object> diagnosis1,
                               HashMap<String, Object> diagnosis2) {
        this.diagnosis1 = diagnosis1;
        this.diagnosis2 = diagnosis2;
        this.diagnosis3 = null;
    }

    public DiagnosisOutputData(HashMap<String, Object> diagnosis1) {
        this.diagnosis1 = diagnosis1;
        this.diagnosis2 = null;
        this.diagnosis3 = null;
    }

    public DiagnosisOutputData() {
        this.diagnosis1 = null;
        this.diagnosis2 = null;
        this.diagnosis3 = null;
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
}
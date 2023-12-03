package main.use_case.past_diagnoses;

import java.time.LocalDateTime;
import java.util.HashMap;

public class PastDiagnosesOutputData {


    private final HashMap<String, LocalDateTime> pastDiagnoses;

    public PastDiagnosesOutputData(HashMap<String, LocalDateTime> pastDiagnoses) {
        this.pastDiagnoses = pastDiagnoses;
    }
    public HashMap<String, LocalDateTime> getPastDiagnoses() {
        return pastDiagnoses;
    }
}

package main.use_case.past_diagnoses;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PastDiagnosesOutputDataTest {

    @Test
    public void getPastDiagnoses() {
        HashMap<String, LocalDateTime> info = new HashMap<>();
        info.put("diagnosis", LocalDateTime.now());
        PastDiagnosesOutputData data = new PastDiagnosesOutputData(info);
        assert data.getPastDiagnoses() == info;
    }
}
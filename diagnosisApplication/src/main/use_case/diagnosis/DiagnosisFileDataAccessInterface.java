package main.use_case.diagnosis;

import main.entity.DiagnosedIssue;
import main.entity.User;

import java.time.LocalDateTime;
import java.util.HashMap;

public interface DiagnosisFileDataAccessInterface {
    void save(DiagnosedIssue diagnosedIssue);

    HashMap<String, LocalDateTime> getPastDiagnoses();
}

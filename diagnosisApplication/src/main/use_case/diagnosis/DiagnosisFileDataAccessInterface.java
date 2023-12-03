package main.use_case.diagnosis;

import main.entity.DiagnosedIssue;
import main.entity.User;

public interface DiagnosisFileDataAccessInterface {
    void save(DiagnosedIssue diagnosedIssue);
}

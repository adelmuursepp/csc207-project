package main.use_case.diagnosis;

import main.entity.HealthDiagnosis;

import java.util.List;

public interface DiagnosisUserDataAccessInterface {
    List<HealthDiagnosis> getDiagnoses(List<Integer> symptomsList);
}

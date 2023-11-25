package use_case.diagnosis;

import java.util.List;

public interface DiagnosisInputBoundary {
    List<Integer> execute(DiagnosisInputData diagnosisInputData);
}

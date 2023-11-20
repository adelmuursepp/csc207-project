package use_case.diagnosis;

import java.util.List;

public interface DiagnosisInputBoundary {
    List<String> execute(DiagnosisInputData diagnosisInputData);
}

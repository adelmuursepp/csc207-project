package main.use_case.diagnosis;

public interface DiagnosisOutputBoundary {
    void prepareDiagnosisView(DiagnosisOutputData outputData);

    void present(DiagnosisOutputData diagnosisOutputData);
}

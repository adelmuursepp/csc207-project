package interface_adapter.diagnosis;

import use_case.diagnosis.DiagnosisOutputBoundary;
import use_case.diagnosis.DiagnosisOutputData;

import java.util.List;

public class DiagnosisPresenter implements DiagnosisOutputBoundary {
    @Override
    public void present(DiagnosisOutputData outputData) {
        List<String> diagnosis = outputData.getDiagnosis();
    }
}
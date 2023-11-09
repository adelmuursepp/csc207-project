package interface_adapter.diagnosis;

import use_case.diagnosis.DiagnosisOutputBoundary;
import use_case.diagnosis.DiagnosisOutputData;

import java.util.List;

public class DiagnosisPresenter implements DiagnosisOutputBoundary {
    @Override
    public void present(DiagnosisOutputData outputData) {
        List<String> diagnosis = outputData.getDiagnosis();

        SymptomCheckerState symptomCheckerState = SymptomCheckerViewModel.getState();

        DiagnosisState diagnosisState = DiagnosisViewModel.getState();
        //whatever changes to dianosis state
        diagnosisViewModel.setState(diagnosisState);
        diagnosisViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(diagnosisViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
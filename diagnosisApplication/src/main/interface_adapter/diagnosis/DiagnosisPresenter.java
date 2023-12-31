package main.interface_adapter.diagnosis;

import main.interface_adapter.ViewManagerModel;
import main.use_case.diagnosis.DiagnosisOutputBoundary;
import main.use_case.diagnosis.DiagnosisOutputData;

import java.util.List;

public class DiagnosisPresenter implements DiagnosisOutputBoundary {
    private final DiagnosisViewModel diagnosisViewModel;
    private final ViewManagerModel viewManagerModel;

    public DiagnosisPresenter(DiagnosisViewModel diagnosisViewModel, ViewManagerModel viewManagerModel) {
        this.diagnosisViewModel = diagnosisViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareDiagnosisView(DiagnosisOutputData outputData) {
       DiagnosisState diagnosisState = new DiagnosisState();

       diagnosisState.setDiagnosis1(outputData.getDiagnosis1());

       if (outputData.getDiagnosis2() != null) {
           diagnosisState.setDiagnosis2(outputData.getDiagnosis2());
       }

       if (outputData.getDiagnosis3() != null) {
           diagnosisState.setDiagnosis3(outputData.getDiagnosis3());
       }

       diagnosisViewModel.setState(diagnosisState);
       this.diagnosisViewModel.firePropertyChanged();

       viewManagerModel.setActiveView(diagnosisViewModel.getViewName());
       this.viewManagerModel.firePropertyChanged();
    }

    // possibly add a view for if all three diagnoses are null; ex. "No diagnosis match; refer to doctor" or something
}
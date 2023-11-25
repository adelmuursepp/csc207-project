package main.interface_adapter.diagnosis;

<<<<<<< HEAD:diagnosisApplication/src/main/interface_adapter/diagnosis/DiagnosisPresenter.java
import main.use_case.diagnosis.DiagnosisOutputBoundary;
import main.use_case.diagnosis.DiagnosisOutputData;
=======
import interface_adapter.ViewManagerModel;
import use_case.diagnosis.DiagnosisOutputBoundary;
import use_case.diagnosis.DiagnosisOutputData;
>>>>>>> origin/diagnosis-interface-adapters:diagnosisApplication/src/interface_adapter/diagnosis/DiagnosisPresenter.java

import java.util.List;

public class DiagnosisPresenter implements DiagnosisOutputBoundary {
    private final DiagnosisViewModel diagnosisViewModel;
    private ViewManagerModel viewManagerModel;

    public DiagnosisPresenter(DiagnosisViewModel diagnosisViewModel) {
        this.diagnosisViewModel = diagnosisViewModel;
    }
    @Override
    public void prepareDiagnosisView(DiagnosisOutputData outputData) {
       DiagnosisState diagnosisState = diagnosisViewModel.getState();

       diagnosisState.setDiagnosis1(outputData.getDiagnosis1());

       if (outputData.getDiagnosis2() != null) {
           diagnosisState.setDiagnosis2(outputData.getDiagnosis2());
       }

       if (outputData.getDiagnosis3() != null) {
           diagnosisState.setDiagnosis3(outputData.getDiagnosis3());
       }
        this.diagnosisViewModel.firePropertyChanged();

       viewManagerModel.setActiveView(diagnosisViewModel.getViewName());
       this.viewManagerModel.firePropertyChanged();
    }

    // possibly add a view for if all three diagnoses are null; ex. "No diagnosis match; refer to doctor" or something
}
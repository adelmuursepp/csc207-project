package main.interface_adapter.past_diagnoses;

import main.interface_adapter.ViewManagerModel;
import main.use_case.past_diagnoses.PastDiagnosesOutputBoundary;
import main.use_case.past_diagnoses.PastDiagnosesOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PastDiagnosesPresenter implements PastDiagnosesOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final PastDiagnosesViewModel pastDiagnosesViewModel;

    public PastDiagnosesPresenter(PastDiagnosesViewModel pastDiagnosesViewModel, ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
        this.pastDiagnosesViewModel = pastDiagnosesViewModel;
    }

    public void preparePastDiagnosesView(PastDiagnosesOutputData pastDiagnosesOutputData) {
        PastDiagnosesState pastDiagnosesState = pastDiagnosesViewModel.getState();
        List<String> pastDiagnosesList = new ArrayList<>();
        HashMap<String, LocalDateTime> pastDiagnoses = pastDiagnosesOutputData.getPastDiagnoses();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (String pastDiagnosisName : pastDiagnoses.keySet()) {
            String creationTime = pastDiagnoses.get(pastDiagnosisName).format(formatter);
            String pastDiagnosisString = pastDiagnosisName + ", created at " + creationTime;
            pastDiagnosesList.add(pastDiagnosisString);
        }
        pastDiagnosesState.setPastDiagnosesList(pastDiagnosesList);
        pastDiagnosesViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(pastDiagnosesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

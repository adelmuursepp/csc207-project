package main.interface_adapter.diagnosis;

import main.use_case.diagnosis.DiagnosisInputBoundary;
import main.use_case.diagnosis.DiagnosisInputData;
import main.use_case.diagnosis.DiagnosisUserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;
public class DiagnosisController {
    final DiagnosisInputBoundary diagnosisUseCaseInteractor;
    public DiagnosisController(DiagnosisInputBoundary diagnosisUseCaseInteractor) {
        this.diagnosisUseCaseInteractor = diagnosisUseCaseInteractor;
    }

    public void execute(ArrayList<Integer> checkedSymptoms) {
        System.out.println("Controller works");
        DiagnosisInputData diagnosisInputData = new DiagnosisInputData(checkedSymptoms);
        diagnosisUseCaseInteractor.execute(diagnosisInputData);
    }

}

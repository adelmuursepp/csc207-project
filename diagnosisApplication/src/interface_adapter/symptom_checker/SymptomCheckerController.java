package interface_adapter.symptom_checker;

import use_case.diagnosis.SymptomCheckerInputBoundary;
import use_case.diagnosis.SymptomCheckerInputData;

import java.util.List;

public class SymptomCheckerController {

    final SymptomCheckerInputBoundary SymptomCheckerUseCaseInteractor;
    public void SymptomCheckerController(SymptomCheckerInputBoundary symptomCheckerUseCaseInteractor) {
        this.symptomCheckerUseCaseInteractor = symptomCheckerUseCaseInteractor;
    }

    public List<String> execute(Boolean diagnosisState) {
        SymptomCheckerInputData diagnosisInputData = new SymptomCheckerInputData(diagnosisState);
        return symptomCheckerUseCaseInteractor.execute(symptomCheckerInputData);
    }
}

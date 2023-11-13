package interface_adapter.symptom_checker;

import use_case.symptom_checker.SymptomCheckerInputBoundary;
import use_case.symptom_checker.SymptomCheckerInputData;

import java.util.List;

public class SymptomCheckerController {

    final SymptomCheckerInputBoundary SymptomCheckerUseCaseInteractor;
    public void SymptomCheckerController(SymptomCheckerInputBoundary symptomCheckerUseCaseInteractor) {
        this.symptomCheckerUseCaseInteractor = symptomCheckerUseCaseInteractor;
    }

    public List<String> execute(Boolean diagnosisState) {
        SymptomCheckerInputData symptomCheckerInputData = new SymptomCheckerInputData(diagnosisState);
        return symptomCheckerUseCaseInteractor.execute(symptomCheckerInputData);
    }
}

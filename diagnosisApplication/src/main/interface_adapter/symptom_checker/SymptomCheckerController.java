package main.interface_adapter.symptom_checker;

import main.use_case.symptom_checker.SymptomCheckerInputBoundary;
import main.use_case.symptom_checker.SymptomCheckerInputData;
import main.use_case.symptom_checker.SymptomCheckerInteractor;

public class SymptomCheckerController {

    SymptomCheckerInputBoundary symptomCheckerInteractor;

    public SymptomCheckerController(SymptomCheckerInputBoundary symptomCheckerInteractor) {
        System.out.println("controller initialized");
        this.symptomCheckerInteractor = symptomCheckerInteractor;
    }

    public void execute() {
        SymptomCheckerInputData symptomCheckerInputData = new SymptomCheckerInputData();
        symptomCheckerInteractor.execute(symptomCheckerInputData);
    }
}

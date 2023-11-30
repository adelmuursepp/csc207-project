package main.interface_adapter.symptom_checker;

import main.use_case.symptom_checker.SymptomCheckerInputBoundary;
import main.use_case.symptom_checker.SymptomCheckerInteractor;

public class SymptomCheckerController {

    SymptomCheckerInputBoundary symptomCheckerInteractor;

    public SymptomCheckerController(SymptomCheckerInputBoundary symptomCheckerInteractor) {
        this.symptomCheckerInteractor = symptomCheckerInteractor;
    }

}

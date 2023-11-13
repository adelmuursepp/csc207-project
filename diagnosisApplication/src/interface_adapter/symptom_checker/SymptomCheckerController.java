package interface_adapter.symptom_checker;

import use_case.symptom_checker.SCDataAccessInterface;
import use_case.symptom_checker.SCInteractor;

public class SymptomCheckerController {

    SCInteractor symptomCheckerInteractor;

    public SymptomCheckerController(SCInteractor symptomCheckerInteractor) {
        this.symptomCheckerInteractor = symptomCheckerInteractor;
    }
    void checkSymptom(String Symptom){



    }
}

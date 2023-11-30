package main.use_case.symptom_checker;

import use_case.symptom_checker.SymptomCheckerDataAccessInterface;

public class SymptomCheckerInteractor implements SymptomCheckerInputBoundary {

    final SymptomCheckerDataAccessInterface symptomCheckerDataAccessObject;

    public SymptomCheckerInteractor(SymptomCheckerDataAccessInterface symptomCheckerDataAccessInterface) {
        this.symptomCheckerDataAccessObject = symptomCheckerDataAccessInterface;
    }
}

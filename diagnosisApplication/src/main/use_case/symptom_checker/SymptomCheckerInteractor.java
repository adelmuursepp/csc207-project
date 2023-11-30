package main.use_case.symptom_checker;

import use_case.symptom_checker.SymptomCheckerDataAccessInterface;

public class SymptomCheckerInteractor implements SymptomCheckerInputBoundary {

    final SymptomCheckerOutputBoundary symptomCheckerPresenter;

    public SymptomCheckerInteractor(SymptomCheckerOutputBoundary symptomCheckerPresenter) {
        this.symptomCheckerPresenter = symptomCheckerPresenter;
    }
}

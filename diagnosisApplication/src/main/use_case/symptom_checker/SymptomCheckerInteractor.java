package main.use_case.symptom_checker;

import main.use_case.signup.SignupOutputData;
import use_case.symptom_checker.SymptomCheckerDataAccessInterface;

public class SymptomCheckerInteractor implements SymptomCheckerInputBoundary {

    final SymptomCheckerOutputBoundary symptomCheckerPresenter;

    public SymptomCheckerInteractor(SymptomCheckerOutputBoundary symptomCheckerPresenter) {
        this.symptomCheckerPresenter = symptomCheckerPresenter;
    }

    public void execute(SymptomCheckerInputData symptomCheckerInputData) {
        SymptomCheckerOutputData symptomCheckerOutputData = new SymptomCheckerOutputData();
    }
}

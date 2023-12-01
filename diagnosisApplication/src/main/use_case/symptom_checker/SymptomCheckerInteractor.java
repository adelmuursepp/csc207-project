package main.use_case.symptom_checker;

public class SymptomCheckerInteractor implements SymptomCheckerInputBoundary {

    final SymptomCheckerOutputBoundary symptomCheckerPresenter;

    public SymptomCheckerInteractor(SymptomCheckerOutputBoundary symptomCheckerPresenter) {
        System.out.println("interactor initialized");
        this.symptomCheckerPresenter = symptomCheckerPresenter;
    }

    public void execute(SymptomCheckerInputData symptomCheckerInputData) {
        SymptomCheckerOutputData symptomCheckerOutputData = new SymptomCheckerOutputData();
        symptomCheckerPresenter.present(symptomCheckerOutputData);
    }
}

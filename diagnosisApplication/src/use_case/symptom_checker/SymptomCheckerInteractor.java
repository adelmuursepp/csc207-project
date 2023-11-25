package use_case.symptom_checker;

public class SymptomCheckerInteractor implements SymptomCheckerInputBoundary {

    final SymptomCheckerDataAccessInterface symptomCheckerDataAccessObject;

    public SymptomCheckerInteractor(SymptomCheckerDataAccessInterface symptomCheckerDataAccessInterface) {
        this.symptomCheckerDataAccessObject = symptomCheckerDataAccessInterface;
    }

    public void toggle(String symptom) {

        symptomCheckerDataAccessObject.toggle(getID(symptom));
    }

    public void getID(String symptom) {
        return symptomCheckerDataAccessObject.getID(symptom);
    }

}

package use_case.symptom_checker;

public class SCInteractor implements SCInputBoundary {

    final SCDataAccessInterface scDataAccessObject;

    public SCInteractor(SCDataAccessInterface scDataAccessInterface) {
        this.scDataAccessObject = scDataAccessInterface;
    }

    public void getID(String symptom) {
        return SCDataAccessObject.getID(symptom);
    }

}

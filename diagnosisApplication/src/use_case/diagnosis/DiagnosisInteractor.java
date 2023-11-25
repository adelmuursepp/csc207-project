package use_case.diagnosis;

import java.util.List;
//don't know entity name yet

public class DiagnosisInteractor implements DiagnosisInputBoundary {
    //assuming existance of diagnosis data access object
    final DiagnosisUserDataAccessObject userDataAccessObject;
    final DiagnosisOutputBoundary diagnosisPresenter;

    public DiagnosisInteractor(DiagnosisUserDataAccessObject userDataAccessObject,
                               DiagnosisOutputBoundary diagnosisOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.diagnosisPresenter = diagnosisOutputBoundary;
    }

    //
    @Override
    public List<Integer> execute(DiagnosisInputData diagnosisInputData) {

        List<Integer> checkedSymptoms = diagnosisInputData.getCheckedSymptoms();

        if (! checkedSymptoms.isEmpty()) {

            DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData(checkedSymptoms);
            diagnosisPresenter.present(diagnosisOutputData);

            //assuming diagnosis entity function
            //need to figure out array list of ids



            //draft code
            //for (id: userDataAccessObject.getIds()); {
            //    diagnoses = diagnosis.getDiagnosis();
        } else {

            System.out.println("Please select symptoms");

        }

        return checkedSymptoms;

    }
}

package use_case.diagnosis;

import java.util.ArrayList;
import java.util.List;
//don't know entity name yet
import entity.

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
    public List<String> execute(DiagnosisInputData diagnosisInputData) {
        Boolean diagnosisValue = diagnosisInputData.getDiagnosisValue();
        List<String> diagnoses = new ArrayList<>();

        if (diagnosisValue) {
            //assuming diagnosis entity function
            //need to figure out array list of ids



            //draft code
            //for (id: userDataAccessObject.getIds()); {
            //    diagnoses = diagnosis.getDiagnosis();
            }

        DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData(diagnoses);
        diagnosisPresenter.present(diagnosisOutputData);
        return diagnoses;
    }
}

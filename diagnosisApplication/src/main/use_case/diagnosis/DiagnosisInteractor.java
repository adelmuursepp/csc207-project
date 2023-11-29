package main.use_case.diagnosis;

import main.data_access.MedicAPIDiagnosisDataAccessObject;
import main.entity.DiagnosedIssue;
import main.entity.DiagnosedSpecialization;
import main.entity.HealthDiagnosis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//don't know entity name yet


public class DiagnosisInteractor implements DiagnosisInputBoundary {
    //assuming existance of diagnosis data access object
//    final DiagnosisUserDataAccessObject userDataAccessObject;
    final DiagnosisOutputBoundary diagnosisPresenter;
    private final MedicAPIDiagnosisDataAccessObject medicAPIDiagnosisDataAccessObject;

    public DiagnosisInteractor(
                               DiagnosisOutputBoundary diagnosisOutputBoundary, MedicAPIDiagnosisDataAccessObject medicAPIDiagnosisDataAccessObject) {
//        this.userDataAccessObject = userDataAccessObject;
        this.medicAPIDiagnosisDataAccessObject = medicAPIDiagnosisDataAccessObject;
        this.diagnosisPresenter = diagnosisOutputBoundary;
    }


    this.medicAPIDiagnosisDataAccessObject.getDiagnoses(List<Integer> symptomsList)

    public void execute((DiagnosisInputData diagnosisInputData) throws IOException, InterruptedException {
        List<Integer> checkedSymptoms = diagnosisInputData.getCheckedSymptoms();
        List<HealthDiagnosis> healthDiagnosisList = this.medicAPIDiagnosisDataAccessObject.getDiagnoses(checkedSymptoms);

        if (healthDiagnosisList.size() == 0) {
            DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData();
            diagnosisPresenter.prepareDiagnosisView(diagnosisOutputData);
        }
        else if (healthDiagnosisList.size() == 1) {
            HealthDiagnosis diagnosis1 = healthDiagnosisList.get(0);
            DiagnosedIssue issue1 = diagnosis1.getIssue();
            List<String> specializationNameList = new ArrayList<>();
            List<DiagnosedSpecialization> specializations1 = diagnosis1.getSpecializations();
            for (DiagnosedSpecialization specialization: specializations1) {
                specializationNameList.add(specialization.getName());
            }

            HashMap<String, Object> issue1Hash = new HashMap();
            issue1Hash.put("Name", issue1.getName());
            issue1Hash.put("IcdName", issue1.getIcdName());
            issue1Hash.put("Icd", issue1.getIcd());
            issue1Hash.put("ProfName", issue1.getProfName());
            issue1Hash.put("Accuracy", issue1.getAccuracy());
            issue1Hash.put("Specializations", specializationNameList);

            HashMap<Integer, HashMap<String, Object>> diagnosis1Hash = new HashMap();

            diagnosis1Hash.put(1, issue1Hash);

            DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData(diagnosis1Hash);
            diagnosisPresenter.prepareDiagnosisView(diagnosisOutputData);
        }
        else if (healthDiagnosisList.size() == 2) {
            HealthDiagnosis diagnosis1 = healthDiagnosisList.get(0);
            DiagnosedIssue issue1 = diagnosis1.getIssue();
            List<String> specialization1NameList = new ArrayList<>();
            List<DiagnosedSpecialization> specializations1 = diagnosis1.getSpecializations();
            for (DiagnosedSpecialization specialization: specializations1) {
                specialization1NameList.add(specialization.getName());
            }

            HashMap<String, Object> issue1Hash = new HashMap();
            issue1Hash.put("Name", issue1.getName());
            issue1Hash.put("IcdName", issue1.getIcdName());
            issue1Hash.put("Icd", issue1.getIcd());
            issue1Hash.put("ProfName", issue1.getProfName());
            issue1Hash.put("Accuracy", issue1.getAccuracy());
            issue1Hash.put("Specializations", specialization1NameList);

            HashMap<Integer, HashMap<String, Object>> diagnosis1Hash = new HashMap();

            diagnosis1Hash.put(1, issue1Hash);

            // Diagnosis 2
            HealthDiagnosis diagnosis2 = healthDiagnosisList.get(0);
            DiagnosedIssue issue2 = diagnosis1.getIssue();
            List<String> specialization2NameList = new ArrayList<>();
            List<DiagnosedSpecialization> specializations2 = diagnosis2.getSpecializations();
            for (DiagnosedSpecialization specialization: specializations2) {
                specialization2NameList.add(specialization.getName());
            }

            HashMap<String, Object> issue2Hash = new HashMap();
            issue1Hash.put("Name", issue2.getName());
            issue1Hash.put("IcdName", issue2.getIcdName());
            issue1Hash.put("Icd", issue2.getIcd());
            issue1Hash.put("ProfName", issue2.getProfName());
            issue1Hash.put("Accuracy", issue2.getAccuracy());
            issue1Hash.put("Specializations", specialization2NameList);

            HashMap<Integer, HashMap<String, Object>> diagnosis2Hash = new HashMap();

            diagnosis1Hash.put(2, issue2Hash);

            DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData(diagnosis1Hash, diagnosis2Hash);
            diagnosisPresenter.prepareDiagnosisView(diagnosisOutputData);
        } else if (healthDiagnosisList.size() == 3) {
            HealthDiagnosis diagnosis1 = healthDiagnosisList.get(0);
            DiagnosedIssue issue1 = diagnosis1.getIssue();
            List<String> specialization1NameList = new ArrayList<>();
            List<DiagnosedSpecialization> specializations1 = diagnosis1.getSpecializations();
            for (DiagnosedSpecialization specialization: specializations1) {
                specialization1NameList.add(specialization.getName());
            }

            HashMap<String, Object> issue1Hash = new HashMap();
            issue1Hash.put("Name", issue1.getName());
            issue1Hash.put("IcdName", issue1.getIcdName());
            issue1Hash.put("Icd", issue1.getIcd());
            issue1Hash.put("ProfName", issue1.getProfName());
            issue1Hash.put("Accuracy", issue1.getAccuracy());
            issue1Hash.put("Specializations", specialization1NameList);

            HashMap<Integer, HashMap<String, Object>> diagnosis1Hash = new HashMap();

            diagnosis1Hash.put(1, issue1Hash);

            // Diagnosis 2
            HealthDiagnosis diagnosis2 = healthDiagnosisList.get(0);
            DiagnosedIssue issue2 = diagnosis1.getIssue();
            List<String> specialization2NameList = new ArrayList<>();
            List<DiagnosedSpecialization> specializations2 = diagnosis2.getSpecializations();
            for (DiagnosedSpecialization specialization: specializations2) {
                specialization2NameList.add(specialization.getName());
            }

            HashMap<String, Object> issue2Hash = new HashMap();
            issue1Hash.put("Name", issue2.getName());
            issue1Hash.put("IcdName", issue2.getIcdName());
            issue1Hash.put("Icd", issue2.getIcd());
            issue1Hash.put("ProfName", issue2.getProfName());
            issue1Hash.put("Accuracy", issue2.getAccuracy());
            issue1Hash.put("Specializations", specialization2NameList);

            HashMap<Integer, HashMap<String, Object>> diagnosis2Hash = new HashMap();

            diagnosis1Hash.put(2, issue2Hash);

            // Diagnosis 3
            HealthDiagnosis diagnosis3 = healthDiagnosisList.get(0);
            DiagnosedIssue issue3 = diagnosis1.getIssue();
            List<String> specialization3NameList = new ArrayList<>();
            List<DiagnosedSpecialization> specializations3 = diagnosis3.getSpecializations();
            for (DiagnosedSpecialization specialization: specializations3) {
                specialization3NameList.add(specialization.getName());
            }

            HashMap<String, Object> issue3Hash = new HashMap();
            issue1Hash.put("Name", issue3.getName());
            issue1Hash.put("IcdName", issue3.getIcdName());
            issue1Hash.put("Icd", issue3.getIcd());
            issue1Hash.put("ProfName", issue3.getProfName());
            issue1Hash.put("Accuracy", issue3.getAccuracy());
            issue1Hash.put("Specializations", specialization3NameList);

            HashMap<Integer, HashMap<String, Object>> diagnosis3Hash = new HashMap();

            diagnosis1Hash.put(3, issue2Hash);

            DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData(diagnosis1Hash, diagnosis2Hash, diagnosis3Hash);
            diagnosisPresenter.prepareDiagnosisView(diagnosisOutputData);
        }

    }

    @Override
    public List<Integer> execute(DiagnosisInputData diagnosisInputData) {

        List<Integer> checkedSymptoms = diagnosisInputData.getCheckedSymptoms();

        if (! checkedSymptoms.isEmpty()) {

            DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData();
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

package main.use_case.diagnosis;

import main.data_access.MedicAPIDiagnosisDataAccessObject;
import main.entity.DiagnosedIssue;
import main.entity.DiagnosedSpecialization;
import main.entity.HealthDiagnosis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiagnosisInteractor implements DiagnosisInputBoundary {
//    final DiagnosisUserDataAccessObject userDataAccessObject;
    final DiagnosisOutputBoundary diagnosisPresenter;
    private final DiagnosisUserDataAccessInterface medicAPIDiagnosisDataAccessObject;

    public DiagnosisInteractor(
            DiagnosisOutputBoundary diagnosisOutputBoundary, DiagnosisUserDataAccessInterface medicAPIDiagnosisDataAccessObject) {
//        this.userDataAccessObject = userDataAccessObject;
        this.medicAPIDiagnosisDataAccessObject = medicAPIDiagnosisDataAccessObject;
        this.diagnosisPresenter = diagnosisOutputBoundary;
    }

    public void execute(DiagnosisInputData diagnosisInputData) {
        List<Integer> checkedSymptoms = diagnosisInputData.getCheckedSymptoms();
        List<HealthDiagnosis> healthDiagnosisList;
        try {
            healthDiagnosisList = this.medicAPIDiagnosisDataAccessObject.getDiagnoses(checkedSymptoms);
        } catch (Exception e) {
            throw new RuntimeException();
        }

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

            DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData(issue1Hash);
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

            DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData(issue1Hash, issue2Hash);
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

            DiagnosisOutputData diagnosisOutputData = new DiagnosisOutputData(issue1Hash, issue2Hash, issue3Hash);
            diagnosisPresenter.prepareDiagnosisView(diagnosisOutputData);
        }

    }

}
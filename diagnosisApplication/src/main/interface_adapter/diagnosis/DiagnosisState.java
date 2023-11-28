package main.interface_adapter.diagnosis;

import java.util.HashMap;
import java.util.List;

public class DiagnosisState {
    private  Integer diagnosis1Ranking = null;
    private  String diagnosis1Name = null;
    private  Integer diagnosis1Accuracy = null;
    private  String diagnosis1Icd = null;
    private  String diagnosis1ProfName = null;
    private List<String> diagnosis1Specializations = null;

    private  Integer diagnosis2Ranking = null;
    private  String diagnosis2Name = null;
    private  Integer diagnosis2Accuracy = null;
    private  String diagnosis2Icd = null;
    private  String diagnosis2ProfName = null;
    private List<String> diagnosis2Specializations = null;

    private  Integer diagnosis3Ranking = null;
    private  String diagnosis3Name = null;
    private  Integer diagnosis3Accuracy = null;
    private  String diagnosis3Icd = null;
    private  String diagnosis3ProfName = null;
    private List<String> diagnosis3Specializations = null;

    public DiagnosisState() {

    }

    public void setDiagnosis1(HashMap<Integer, HashMap<String, Object>> diagnosis1) {
        this.diagnosis1Ranking = 1;
        this.diagnosis1Name = diagnosis1.get("name");
        this.diagnosis1Accuracy = diagnosis1.get("accuracy");
        this.diagnosis1Icd = diagnosis1.get("icd");
        this.diagnosis1ProfName = diagnosis1.get("profName");
        this.diagnosis1Specializations = diagnosis1.get("specializations");
    }

    public void setDiagnosis2(HashMap<Integer, HashMap<String, Object>> diagnosis2) {
        this.diagnosis2Ranking = 2;
        this.diagnosis2Name = diagnosis2.get("name");
        this.diagnosis2Accuracy = diagnosis2.get("accuracy");
        this.diagnosis2Icd = diagnosis2.get("icd");
        this.diagnosis2ProfName = diagnosis2.get("profName");
        this.diagnosis2Specializations = diagnosis2.get("specializations");
    }

    public void setDiagnosis3(HashMap<Integer, HashMap<String, Object>> diagnosis3) {
        this.diagnosis3Ranking = 3;
        this.diagnosis3Name = diagnosis3.get("name");
        this.diagnosis3Accuracy = diagnosis3.get("accuracy");
        this.diagnosis3Icd = diagnosis3.get("icd");
        this.diagnosis3ProfName = diagnosis3.get("profName");
        this.diagnosis3Specializations = diagnosis3.get("specializations");
    }

    public Integer getDiagnosis1Ranking() {
        return diagnosis1Ranking;
    }

    public String getDiagnosis1Name() {
        return diagnosis1Name;
    }

    public Integer getDiagnosis1Accuracy() {
        return diagnosis1Accuracy;
    }

    public String getDiagnosis1Icd() {
        return diagnosis1Icd;
    }

    public String getDiagnosis1ProfName() {
        return diagnosis1ProfName;
    }

    public List<String> getDiagnosis1Specializations() {
        return diagnosis1Specializations;
    }

    public Integer getDiagnosis2Ranking() {
        return diagnosis1Ranking;
    }

    public String getDiagnosis2Name() {
        return diagnosis1Name;
    }

    public Integer getDiagnosis2Accuracy() {
        return diagnosis1Accuracy;
    }

    public String getDiagnosis2Icd() {
        return diagnosis1Icd;
    }

    public String getDiagnosis2ProfName() {
        return diagnosis1ProfName;
    }

    public List<String> getDiagnosis2Specializations() {
        return diagnosis1Specializations;
    }

    public Integer getDiagnosis3Ranking() {
        return diagnosis1Ranking;
    }

    public String getDiagnosis3Name() {
        return diagnosis1Name;
    }

    public Integer getDiagnosis3Accuracy() {
        return diagnosis1Accuracy;
    }

    public String getDiagnosis3Icd() {
        return diagnosis1Icd;
    }

    public String getDiagnosis3ProfName() {
        return diagnosis1ProfName;
    }

    public List<String> getDiagnosis3Specializations() {
        return diagnosis1Specializations;
    }
}

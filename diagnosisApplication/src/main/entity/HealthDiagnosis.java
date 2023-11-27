package main.entity;
import java.util.List;

public class HealthDiagnosis {
    private DiagnosedIssue issue;
    private List<DiagnosedSpecialization> specializationList;

    public void setIssue(DiagnosedIssue issue) {
        this.issue = issue;
    }

    public void setSpecializationList(List<DiagnosedSpecialization> specializationList) {
        this.specializationList = specializationList;
    }

    public List<DiagnosedSpecialization> getSpecializations() {
        return this.specializationList;
    }

    public DiagnosedIssue getIssue() {
        return this.issue;
    }
}

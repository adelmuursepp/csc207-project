package main.entity;
import java.util.List;

public class HealthDiagnosis {
    public DiagnosedIssue issue;
    public List<DiagnosedSpecialization> specializationList;

    public void setIssue(DiagnosedIssue issue) {
        this.issue = issue;
    }

    public void setSpecializationList(List<DiagnosedSpecialization> specializationList) {
        this.specializationList = specializationList;
    }
}

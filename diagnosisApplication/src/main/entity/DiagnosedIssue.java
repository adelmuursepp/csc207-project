package diagnosisApplication.src.main.entity;

public class DiagnosedIssue {
    private String icd;
    private String icdName;
    private String profName;
    private float accuracy;
    private float ranking;
    private int id;
    private String name;

    public DiagnosedIssue(String icd, String icdName, String profName, float accuracy, float ranking, int id, String name) {
        this.icd = icd;
        this.icdName = icdName;
        this.profName = profName;
        this.accuracy = accuracy;
        this.ranking = ranking;
        this.id = id;
        this.name = name;
    }
}

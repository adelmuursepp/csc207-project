package main.entity;

public class DiagnosedIssue {
    private String icd;
    private String icdName;
    private String profName;
    private float accuracy;
    private float ranking;
    private int id;
    private String name;

    public DiagnosedIssue(String icd, String icdName, String profName, float accuracy, float ranking, int id, String name) {
        System.out.println("Inside issue constructor");
        this.icd = icd;
        this.icdName = icdName;
        this.profName = profName;
        this.accuracy = accuracy;
        this.ranking = ranking;
        this.id = id;
        this.name = name;
    }

    public String getIcd() {
        return this.icd;
    }

    public String getIcdName() {
        return this.icdName;
    }

    public String getProfName() {
        return this.profName;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public float getRanking() {
        return this.ranking;
    }

    public String getName() {
        return this.name;
    }


}


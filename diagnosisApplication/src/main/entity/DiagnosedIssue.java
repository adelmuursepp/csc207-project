package main.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DiagnosedIssue {
    private String icd;
    private String icdName;
    private String profName;
    private float accuracy;
    private float ranking;
    private int id;
    private String name;
    private LocalDateTime creationTime;

    public DiagnosedIssue(String icd, String icdName, String profName, float accuracy, float ranking, int id, String name) {
        this.icd = icd;
        this.icdName = icdName;
        this.profName = profName;
        this.accuracy = accuracy;
        this.ranking = ranking;
        this.id = id;
        this.name = name;
        this.creationTime = LocalDateTime.now();
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

    public LocalDateTime getCreationTime() {return this.creationTime;}
}


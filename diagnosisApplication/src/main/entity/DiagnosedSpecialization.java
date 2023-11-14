package main.entity;

public class DiagnosedSpecialization {
    private int id;
    private String name;
    private int specialistId;
    private float accuracy;
    private String ranking;

    public DiagnosedSpecialization(int id, String name, int specialistId, float accuracy, String ranking) {
        this.id = id;
        this.name = name;
        this.specialistId = specialistId;
        this.accuracy = accuracy;
        this.ranking = ranking;
    }

}

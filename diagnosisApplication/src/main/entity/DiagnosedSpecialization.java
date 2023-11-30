package main.entity;

public class DiagnosedSpecialization {
    private int id;
    private String name;
    private int specialistId;

    public DiagnosedSpecialization(int ID, String Name, int SpecialistID) {
        this.id = ID;
        this.name = Name;
        this.specialistId = SpecialistID;
    }

    public String getName() {
        return this.name;
    }

}

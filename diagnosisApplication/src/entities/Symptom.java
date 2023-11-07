package entities;
/**
 * A representation of a medically relevant symptom. The symptom has a name and state. The state indicates whether
 * the symptom is present. The default state of a symptom is not present. Symptoms can be selected and deselected.
 */

public class Symptom {

    private final String symptomName;
    private boolean present;

    /**
     * Creates a symptom with the specified name and sets present (state) to false.
     * @param symptomName the name of the symptom
     */
    public Symptom(String symptomName) {
        this.symptomName = symptomName;
        this.present = false;
    }

    /**
     * Returns the name of the symptom.
     * @return value of name property
     */
    public String getSymptomName() {
        return symptomName;
    }

    /**
     * Returns whether this symptom is present/state of the symptom.
     * @return value of the present property
     */
    public boolean isPresent() {
        return present;
    }

    /**
     * Changes the state of the symptom and returns the changed value.
     * @return new value of the present property
     */
    public boolean select() {
        this.present = !present;
        return present;
    }

}

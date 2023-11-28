package diagnosisApplication.src.main.entity;
/**
 * A representation of a medically relevant common symptom. An implementation of Symptom interface. The symptom has a
 * name, an ID number (corresponding to its ID number given by the healthgprahic API), and state. The state indicates
 * whether the symptom is present. The default state of a symptom is not present. Symptoms can be selected and
 * deselected.
 */

public class CommonSymptom implements Symptom {

    private final String symptomName;
    private final int idNum;
    private boolean present;

    /**
     * Creates a symptom with the specified name and sets present (state) to false.
     * @param symptomName the name of the symptom
     */
    public CommonSymptom(String symptomName, int idNum) {
        this.symptomName = symptomName;
        this.idNum = idNum;
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
     * Return the ID number given by the healthgraphic API for this symptom.
     * @return value of idNum property
     */
    public int getIdNum() {
        return idNum;
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

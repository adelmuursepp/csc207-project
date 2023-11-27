package main.entity;

/**
 * Interface for various symptoms. All implementations of symptoms must use this interface. It contains two methods that
 * represent its most basic functions: a method to get the symptom name and a method that indicates whether this symptom
 * is present.
 */

public interface Symptom {

    /**
     * Returns the name of this symptom.
     * @return symptom name
     */
    String getSymptomName();

    /**
     * Returns the state of this symptom (whether it is present)
     * @return symptom presence
     */
    boolean isPresent();

}

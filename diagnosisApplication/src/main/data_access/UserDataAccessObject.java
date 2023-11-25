package main.data_access;

import java.io.*;

public class UserDataAccessObject {

    private File symptomList;

    private File checkedSymptoms;

    public Integer getID(String symptom) {
        //Access csv file to get the ID of the symptom here
        return null;
    }

    public void toggle(Integer sID) {
        //Toggles boolean in csv file for the symptom with the given ID
    }

}
package data_access;

import use_case.symptom_checker.SCDataAccessInterface;

import java.io.*;

public class UserDataAccessObject implements SCDataAccessInterface {

    private File symptomList;

    private File checkedSymptoms;

    public Integer getID(String symptom) {
        //Access csv file to get the ID of the symptom here
    }

    public void toggle(Integer sID) {
        //Toggles boolean in csv file for the symptom with the given ID
    }

}
package main.data_access;

import main.use_case.signup.SignupUserDataAccessInterface;

import java.io.*;

public class UserDataAccessObject implements SignupUserDataAccessInterface {

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
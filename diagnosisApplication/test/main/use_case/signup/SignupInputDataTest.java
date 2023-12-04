package main.use_case.signup;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignupInputDataTest {
   SignupInputData data = new SignupInputData("username", "password",
           "password", "male", 2000);

    @Test
    public void getUsername() {
        assert data.getUsername() == "username";
    }

    @Test
    public void getPassword() {
        assert data.getPassword() == "password";
    }

    @Test
    public void getRepeatPassword() {
        assert data.getRepeatPassword() == "password";
    }

    @Test
    public void getSex() {
        assert data.getSex() == "male";
    }

    @Test
    public void getYearOfBirth() {
        assert data.getYearOfBirth() == 2000;
    }
}
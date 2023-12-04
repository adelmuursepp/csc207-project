package main.use_case.login;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginOutputDataTest {

    @Test
    public void getUsername() {
        LoginOutputData data = new LoginOutputData("username", false);
        data.getUsername();
    }
}
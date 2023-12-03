package main.interface_adapter.profile;

import main.interface_adapter.login.LoginState;

import java.time.LocalDateTime;

public class ProfileState {
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserYearOfBirth(Integer userYearOfBirth) {
        this.userYearOfBirth = userYearOfBirth;
    }

    public void setUserCreationTime(LocalDateTime userCreationTime) {
        this.userCreationTime = userCreationTime;
    }

    public String getUsername() {
        return username;
    }

    public String getUserSex() {
        return userSex;
    }

    public Integer getUserYearOfBirth() {
        return userYearOfBirth;
    }

    public LocalDateTime getUserCreationTime() {
        return userCreationTime;
    }

    private String username = "";
    private String userSex = "";
    private Integer userYearOfBirth = null;
    private LocalDateTime userCreationTime = null;

    public ProfileState(ProfileState copy) {
        username = copy.username;
        userSex = copy.userSex;
        userYearOfBirth = copy.userYearOfBirth;
        userCreationTime = copy.userCreationTime;
    }


    public ProfileState() {}


}

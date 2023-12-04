package main.use_case.profile;

import java.time.LocalDateTime;

public class ProfileOutputData {
    private String username;
    private String password;
    private String userSex;
    private  Integer userYearOfBirth;
    private LocalDateTime userCreationTime;
    public ProfileOutputData(String currUsername, String currUserPassword, String currUserSex,
                             Integer currUserYearOfBirth, LocalDateTime currUserCreationTime) {
        this.username = currUsername;
        this.password = currUserPassword;
        this.userSex = currUserSex;
        this.userYearOfBirth = currUserYearOfBirth;
        this.userCreationTime = currUserCreationTime;
    }

    public String getUsername() {
        return username;
    }

    public String getUserPassword() {
        return password;
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

}

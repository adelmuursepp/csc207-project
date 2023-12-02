package main.use_case.profile;

import java.time.LocalDateTime;

public class ProfileOutputData {
    private String username;
    private String userSex;
    private  Integer userYearOfBirth;
    private LocalDateTime userCreationTime;
    public ProfileOutputData(String currUsername, String currUserSex, Integer currUserYearOfBirth, LocalDateTime currUserCreationTime) {
        this.username = currUsername;
        this.userSex = currUserSex;
        this.userYearOfBirth = currUserYearOfBirth;
        this.userCreationTime = currUserCreationTime;
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

}

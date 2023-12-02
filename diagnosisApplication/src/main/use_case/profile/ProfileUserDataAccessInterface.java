package main.use_case.profile;

import main.entity.User;

public interface ProfileUserDataAccessInterface {
    String getCurrentUser();

    User get(String currUserName);
}

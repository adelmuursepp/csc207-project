package main.entity;

import java.time.LocalDateTime;

public class CommonUserFactory implements UserFactory {
    /**
     * Requires: password is valid.
     * @param name
     * @param password
     * @return
     */

    @Override
    public User create(String name, String password, String sex, Integer yearOfBirth, LocalDateTime ltd) {
        return new CommonUser(name, password, sex, yearOfBirth, ltd);
    }
}

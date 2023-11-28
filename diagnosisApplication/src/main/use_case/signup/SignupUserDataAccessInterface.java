package main.use_case.signup;

import main.entity.User;

public interface SignupUserDataAccessInterface {

    boolean existsByName(String identifier);

    void save(User user);

}

package diagnosisApplication.src.main.use_case.login;

import diagnosisApplication.src.main.entity.User;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}

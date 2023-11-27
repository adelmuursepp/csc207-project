package diagnosisApplication.src.main.use_case.signup;

import diagnosisApplication.src.main.entity.User;

public interface SignupUserDataAccessInterface {

    boolean existsByName(String identifier);

    void save(User user);

}

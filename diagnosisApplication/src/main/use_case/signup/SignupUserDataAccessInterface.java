package diagnosisApplication.src.main.use_case.signup;

public interface SignupUserDataAccessInterface {

    boolean existsByName(String identifier);

    void save(User user);

}

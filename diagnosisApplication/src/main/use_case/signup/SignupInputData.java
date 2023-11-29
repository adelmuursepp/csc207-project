package main.use_case.signup;

public class SignupInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;
    final private String sex;
    final private Integer yearOfBirth;

    public SignupInputData(String username, String password, String repeatPassword, String sex, Integer yearOfBirth) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.sex = sex;
        this.yearOfBirth = yearOfBirth;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
    public String getSex() { return sex; }
    public Integer getYearOfBirth() { return yearOfBirth; }
}

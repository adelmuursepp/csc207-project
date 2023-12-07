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

    /**
     * Getter function for the username field in the sign up
     * @return string representation of the profile username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter function for the password field in the sign up
     * @return string representation of the profile password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter function for the repeat password field in the sign up
     * @return string representation of the repeated password field
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Getter function for the sex combobox in the sign up
     * @return string representation of the sex of the profile
     */
    public String getSex() { return sex; }

    /**
     * Getter function for the year of birth in the sign up
     * @return integer representation of year of birth ranging from 1900 to 2023
     */
    public Integer getYearOfBirth() { return yearOfBirth; }
}

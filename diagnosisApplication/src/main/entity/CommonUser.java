package main.entity;


import java.time.LocalDateTime;

class CommonUser implements User {

    private final String name;
    private final String password;
    private final String sex;
    private final Integer yearOfBirth;
    private final LocalDateTime creationTime;

    /**
     * Requires: password is valid.
     * @param name
     * @param password
     */
    CommonUser(String name, String password, String sex, Integer yearOfBirth, LocalDateTime creationTime) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.yearOfBirth = yearOfBirth;
        this.creationTime = creationTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getSex() { return sex; }

    public Integer getYearOfBirth() { return yearOfBirth; }
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}

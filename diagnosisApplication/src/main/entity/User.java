package main.entity;

import java.time.LocalDateTime;

public interface User {

    String getName();

    String getPassword();

    String getSex();

    Integer getYearOfBirth();

    LocalDateTime getCreationTime();
}

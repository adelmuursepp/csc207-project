package main.data_access;

import main.entity.User;
import main.entity.UserFactory;
import main.use_case.login.LoginUserDataAccessInterface;
import main.use_case.profile.ProfileUserDataAccessInterface;
import main.use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface,
        ProfileUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();
    private String currentUser;

    private UserFactory userFactory;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;
        this.currentUser = null; // If no one is logged in, null, otherwise, username

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("sex", 2);
        headers.put("yearOfBirth", 3);
        headers.put("creation_time", 4);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,password,sex,yearOfBirth,creation_time");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String sex = String.valueOf(col[headers.get("sex")]);
                    Integer yearOfBirth = Integer.valueOf(col[headers.get("yearOfBirth")]);
                    String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                    User user = userFactory.create(username, password, sex, yearOfBirth, ldt);
                    accounts.put(username, user);
                }
            }
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    public void setCurrentUser(String username) {
        this.currentUser = username;
    }

    public String getCurrentUser() {return this.currentUser;}

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s",
                        user.getName(), user.getPassword(), user.getSex(), user.getYearOfBirth(),
                        user.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

}

package main.data_access;

import main.entity.DiagnosedIssue;
import main.entity.User;
import main.use_case.diagnosis.DiagnosisFileDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileDiagnosisDataAccessObject implements DiagnosisFileDataAccessInterface
            {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final List<DiagnosedIssue> diagnoses = new ArrayList<>();
    private String currentUser;
    private FileUserDataAccessObject fileUserDataAccessObject;
    private final String csvPath;

    public FileDiagnosisDataAccessObject(String csvPath, FileUserDataAccessObject fileUserDataAccessObject) throws IOException {
        this.csvPath = csvPath;
        csvFile = new File(csvPath);
        this.fileUserDataAccessObject = fileUserDataAccessObject;
        headers.put("username", 0);
        headers.put("diagnosis_name", 1);
        headers.put("creation_time", 2);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();
                assert header.equals("username,diagnosis_name,creation_time");

                String row;
                // Currently a bit confusing
//                while ((row = reader.readLine()) != null) {
//                    String[] col = row.split(",");
//                    String username = String.valueOf(col[headers.get("username")]);
//                    String diagnosis_name = String.valueOf(col[headers.get("diagnosis_name")]);
//                    String creation_time = String.valueOf(col[headers.get("creation_time")]);
//
//                }
            }
        }
    }

    public void save(DiagnosedIssue diagnosis) {
        diagnoses.add(diagnosis);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            String currentUsername = fileUserDataAccessObject.getCurrentUser();

            for (DiagnosedIssue diagnosis: diagnoses) {
                String line = String.format("%s, %s, %s", currentUsername, diagnosis.getName(), diagnosis.getCreationTime());
                writer.write(line);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, LocalDateTime> getPastDiagnoses() {
        HashMap<String, LocalDateTime> pastDiagnoses = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.csvPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String username = data[0].trim();

                if (currentUser.equals(username)) {
                    String diagnosisName = data[1].trim();
                    LocalDateTime diagnosisCreationTime = LocalDateTime.parse(data[2].trim());
                    pastDiagnoses.put(diagnosisName, diagnosisCreationTime);
                }
            }
            return pastDiagnoses;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

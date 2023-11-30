package main.data_access;

import main.entity.DiagnosedIssue;
import main.entity.DiagnosedSpecialization;
import main.entity.HealthDiagnosis;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.use_case.diagnosis.DiagnosisUserDataAccessInterface;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MedicAPIDiagnosisDataAccessObject implements DiagnosisUserDataAccessInterface {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    //public static void main(String[] args) throws IOException, InterruptedException {
    //    List<Integer> symptomsList = new ArrayList<>();
    //
    //    // Add integers to the list
    //    symptomsList.add(5);
    //    symptomsList.add(10);
    //
    //   getDiagnoses(symptomsList);
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImFkZWwubXV1cnNlcHBAZ21haWwuY29tIiwicm9sZSI6IlVzZXIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiIxMDM1OCIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvdmVyc2lvbiI6IjEwOSIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbGltaXQiOiIxMDAiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL21lbWJlcnNoaXAiOiJCYXNpYyIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbGFuZ3VhZ2UiOiJlbi1nYiIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvZXhwaXJhdGlvbiI6IjIwOTktMTItMzEiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL21lbWJlcnNoaXBzdGFydCI6IjIwMjMtMTAtMDIiLCJpc3MiOiJodHRwczovL2F1dGhzZXJ2aWNlLnByaWFpZC5jaCIsImF1ZCI6Imh0dHBzOi8vaGVhbHRoc2VydmljZS5wcmlhaWQuY2giLCJleHAiOjE2OTg2ODkzMTQsIm5iZiI6MTY5ODY4MjExNH0.LNsuW1zXz522pHUn_6N9vd9EwmtXHzbhCe-P_TLLsPU";
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
//                .uri(URI.create("https://healthservice.priaid.ch/diagnosis?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImFkZWwubXV1cnNlcHBAZ21haWwuY29tIiwicm9sZSI6IlVzZXIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiIxMDM1OCIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvdmVyc2lvbiI6IjEwOSIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbGltaXQiOiIxMDAiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL21lbWJlcnNoaXAiOiJCYXNpYyIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbGFuZ3VhZ2UiOiJlbi1nYiIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvZXhwaXJhdGlvbiI6IjIwOTktMTItMzEiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL21lbWJlcnNoaXBzdGFydCI6IjIwMjMtMTAtMDIiLCJpc3MiOiJodHRwczovL2F1dGhzZXJ2aWNlLnByaWFpZC5jaCIsImF1ZCI6Imh0dHBzOi8vaGVhbHRoc2VydmljZS5wcmlhaWQuY2giLCJleHAiOjE2OTk1ODg3MjEsIm5iZiI6MTY5OTU4MTUyMX0.h5RWkDvWEQAqVaeiWPGa4XHqCWUKDvoMm_UROcC_xnY&language=en-gb&symptoms=[233]&gender=male&year_of_birth=1988"))
//                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
//                .build();
//
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//        // print response headers
//        HttpHeaders headers = response.headers();
//        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
//
//        // print status code
//        System.out.println(response.statusCode());
//
//        // print response body
//        System.out.println(response.body());

    //}

    public List<HealthDiagnosis> getDiagnoses(List<Integer> symptomsList) throws RuntimeException {
        // TODO: Add gender and year
        // Create a string of symptoms list to pass to URI
        StringBuilder symptomString = new StringBuilder("[");
        for (int i = 0; i < symptomsList.size(); i++) {
            symptomString.append(symptomsList.get(i));
            if (i < symptomsList.size() - 1) {
                symptomString.append(",");
            }
        }
        symptomString.append("]");
        // Retrieve API token
        String APIToken = getAPIToken();

        // Create a request object
        String uri = String.format("https://healthservice.priaid.ch/diagnosis?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImFkZWwubXV1cnNlcHBAZ21haWwuY29tIiwicm9sZSI6IlVzZXIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiIxMjk4NyIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvdmVyc2lvbiI6IjIwMCIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbGltaXQiOiI5OTk5OTk5OTkiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL21lbWJlcnNoaXAiOiJQcmVtaXVtIiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9sYW5ndWFnZSI6ImVuLWdiIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9leHBpcmF0aW9uIjoiMjA5OS0xMi0zMSIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbWVtYmVyc2hpcHN0YXJ0IjoiMjAyMy0xMC0wMiIsImlzcyI6Imh0dHBzOi8vc2FuZGJveC1hdXRoc2VydmljZS5wcmlhaWQuY2giLCJhdWQiOiJodHRwczovL2hlYWx0aHNlcnZpY2UucHJpYWlkLmNoIiwiZXhwIjoxNzAwODA1MDE2LCJuYmYiOjE3MDA3OTc4MTZ9.TW_27Es5vlJ2Ghg0RZeXAHO0ITOjYuYjWOIFFNKVQWI&language=de-ch&symptoms=[233]&gender=male&year_of_birth=1988");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // print response body
            System.out.println(response.body());
            System.out.println(response.statusCode());
            if (response.statusCode() == 200) {
                // Parse JSON using Jackson
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(response.body());

                // Convert JSON to a list of HealthDiagnosis entities
                List<HealthDiagnosis> healthDiagnosisList = new ArrayList<>();

                for (JsonNode diagnosisNode : jsonNode) {
                    JsonNode issueNode = diagnosisNode.get("Issue");
                    JsonNode specializationNode = diagnosisNode.get("Specialisation");

                    DiagnosedIssue diagnosedIssue = objectMapper.readValue(issueNode.toString(), DiagnosedIssue.class);
                    List<DiagnosedSpecialization> specializationList = objectMapper.readValue(specializationNode.toString(),
                            objectMapper.getTypeFactory().constructCollectionType(List.class, DiagnosedSpecialization.class));

                    HealthDiagnosis healthDiagnosis = new HealthDiagnosis();
                    healthDiagnosis.setIssue(diagnosedIssue);
                    healthDiagnosis.setSpecializationList(specializationList);

                    healthDiagnosisList.add(healthDiagnosis);
                }

                // Now you have a list of HealthDiagnosis entities
                for (HealthDiagnosis diagnosis : healthDiagnosisList) {
                    System.out.println(diagnosis);
                }
                return healthDiagnosisList;
            } else {
                throw new RuntimeException("Failed to process the request. Server responded with: " + response.body());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getAPIToken() {
        // For now, hardcoded but TODO: implement the auth method
        return "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImFkZWwubXV1cnNlcHBAZ21haWwuY29tIiwicm9sZSI6IlVzZXIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiIxMjk4NyIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvdmVyc2lvbiI6IjIwMCIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbGltaXQiOiI5OTk5OTk5OTkiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL21lbWJlcnNoaXAiOiJQcmVtaXVtIiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9sYW5ndWFnZSI6ImVuLWdiIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9leHBpcmF0aW9uIjoiMjA5OS0xMi0zMSIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbWVtYmVyc2hpcHN0YXJ0IjoiMjAyMy0xMC0wMiIsImlzcyI6Imh0dHBzOi8vc2FuZGJveC1hdXRoc2VydmljZS5wcmlhaWQuY2giLCJhdWQiOiJodHRwczovL2hlYWx0aHNlcnZpY2UucHJpYWlkLmNoIiwiZXhwIjoxNzAwODA0NzkzLCJuYmYiOjE3MDA3OTc1OTN9.Fz2tdACgVxEx3g27ezmwlcWv8EyZpF2oxeRR-Lq_EWQ";
    }

}


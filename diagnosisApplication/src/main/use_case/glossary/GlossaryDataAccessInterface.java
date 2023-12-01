package main.use_case.glossary;

import java.io.IOException;
import java.util.List;

public interface GlossaryDataAccessInterface {
    List<String> getTopics() throws IOException, InterruptedException;

    String search(String search);
}

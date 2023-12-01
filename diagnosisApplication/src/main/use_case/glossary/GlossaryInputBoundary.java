package main.use_case.glossary;

import java.io.IOException;
import java.util.List;

public interface GlossaryInputBoundary {

    List<String> getTopics() throws IOException, InterruptedException;

    String execute(String search);
}

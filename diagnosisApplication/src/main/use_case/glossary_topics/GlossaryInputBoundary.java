package main.use_case.glossary_topics;

import java.io.IOException;
import java.util.List;

public interface GlossaryInputBoundary {
    void execute() throws IOException, InterruptedException;
}

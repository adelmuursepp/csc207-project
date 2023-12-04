package main.use_case.glossary;

import java.io.IOException;

public interface GlossaryInputBoundary {
    void execute(GlossaryInputData glossaryInputData) throws IOException, InterruptedException;
}

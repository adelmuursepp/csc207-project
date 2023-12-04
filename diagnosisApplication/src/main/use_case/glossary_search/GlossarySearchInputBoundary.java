package main.use_case.glossary_search;

import java.io.IOException;
import java.util.List;

public interface GlossarySearchInputBoundary {
    void execute(GlossarySearchInputData glossarySearchInputData) throws IOException, InterruptedException;
}

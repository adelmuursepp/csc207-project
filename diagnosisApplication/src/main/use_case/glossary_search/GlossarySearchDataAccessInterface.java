package main.use_case.glossary_search;

import java.io.IOException;
import java.util.List;

public interface GlossarySearchDataAccessInterface {
    String search(String search) throws IOException, InterruptedException;
}

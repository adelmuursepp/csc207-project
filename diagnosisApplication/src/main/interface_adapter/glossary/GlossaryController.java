package main.interface_adapter.glossary;

import main.use_case.glossary_topics.GlossaryInputBoundary;

import java.io.IOException;
import java.util.List;

public class GlossaryController {

    final GlossaryInputBoundary glossaryInteractor;

    public GlossaryController(GlossaryInputBoundary glossaryInteractor) {
        this.glossaryInteractor = glossaryInteractor;
    }

    public void execute() throws IOException, InterruptedException {
        glossaryInteractor.execute();
    }
}

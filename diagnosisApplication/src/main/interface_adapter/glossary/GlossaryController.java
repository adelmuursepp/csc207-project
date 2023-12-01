package main.interface_adapter.glossary;

import main.use_case.glossary.GlossaryInputBoundary;

import java.io.IOException;
import java.util.List;

public class GlossaryController {

    final GlossaryInputBoundary glossaryUseCaseInteractor;

    public GlossaryController(GlossaryInputBoundary glossaryUseCaseInteractor) {
        this.glossaryUseCaseInteractor = glossaryUseCaseInteractor;
    }

    public List<String> getTopics() throws IOException, InterruptedException {
        return glossaryUseCaseInteractor.getTopics();
    }

    public String execute(String search) {
        return glossaryUseCaseInteractor.execute(search);
    }
}

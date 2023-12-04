package main.interface_adapter.glossary_search;

import main.use_case.glossary_search.GlossarySearchInputBoundary;
import main.use_case.glossary_search.GlossarySearchInputData;

import java.io.IOException;
import java.util.List;

public class GlossarySearchController {

    final GlossarySearchInputBoundary glossaryUseCaseInteractor;

    public GlossarySearchController(GlossarySearchInputBoundary glossaryUseCaseInteractor) {
        this.glossaryUseCaseInteractor = glossaryUseCaseInteractor;
    }

    public void execute(String search) throws IOException, InterruptedException {
        GlossarySearchInputData glossarySearchInputData = new GlossarySearchInputData(search);
        glossaryUseCaseInteractor.execute(glossarySearchInputData);
    }
}

package main.use_case.glossary_search;

import main.use_case.glossary_search.GlossarySearchOutputBoundary;

import java.io.IOException;
import java.util.List;

public class GlossarySearchInteractor implements GlossarySearchInputBoundary {

    final GlossarySearchDataAccessInterface glossaryDataAccessObject;
    final GlossarySearchOutputBoundary glossarySearchPresenter;

    public GlossarySearchInteractor(GlossarySearchDataAccessInterface glossarySearchDataAccessInterface,
                                    GlossarySearchOutputBoundary glossarySearchPresenter) {
        this.glossaryDataAccessObject = glossarySearchDataAccessInterface;
        this.glossarySearchPresenter = glossarySearchPresenter;
    }

    public void execute(GlossarySearchInputData glossarySearchInputData) throws IOException, InterruptedException {
        String content = glossaryDataAccessObject.search(glossarySearchInputData.getSearch());

        GlossarySearchOutputData glossarySearchOutputData = new GlossarySearchOutputData(content);

        glossarySearchPresenter.prepareSearchResults(glossarySearchOutputData);
    }
}

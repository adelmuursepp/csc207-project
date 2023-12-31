package main.use_case.glossary;

import java.io.IOException;
import java.util.List;

public class GlossaryInteractor implements GlossaryInputBoundary {

    final GlossaryDataAccessInterface glossaryDataAccessObject;
    final GlossaryOuputBoundary glossaryPresenter;

    public GlossaryInteractor(GlossaryDataAccessInterface glossaryDataAccessObject,
                              GlossaryOuputBoundary glossaryPresenter) {
        this.glossaryDataAccessObject = glossaryDataAccessObject;
        this.glossaryPresenter = glossaryPresenter;
    }
    @Override
    public void execute(GlossaryInputData glossaryInputData) throws IOException, InterruptedException {
        List<String> topics = glossaryDataAccessObject.getTopics();

        GlossaryOutputData glossaryOutputData = new GlossaryOutputData(topics);

        glossaryPresenter.prepareGlossaryView(glossaryOutputData);
    }
}

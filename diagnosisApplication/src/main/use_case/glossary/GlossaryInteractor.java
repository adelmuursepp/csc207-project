package main.use_case.glossary;

import main.data_access.GlossaryDataAccessObject;

import java.io.IOException;
import java.util.List;

public class GlossaryInteractor implements GlossaryInputBoundary {

    final GlossaryDataAccessInterface glossaryDataAccessObject;

    public String execute(String search) {
        return this.glossaryDataAccessObject.search(search);
    }
    public GlossaryInteractor(GlossaryDataAccessInterface glossaryDataAccessInterface) {
        this.glossaryDataAccessObject = glossaryDataAccessInterface;
    }
    @Override
    public List<String> getTopics() throws IOException, InterruptedException {
        return this.glossaryDataAccessObject.getTopics();
    }
}

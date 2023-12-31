package main.interface_adapter.glossary;

import main.use_case.glossary.GlossaryInputBoundary;
import main.use_case.glossary.GlossaryInputData;

import java.io.IOException;

public class GlossaryController {

    final GlossaryInputBoundary glossaryInteractor;

    public GlossaryController(GlossaryInputBoundary glossaryInteractor) {
        this.glossaryInteractor = glossaryInteractor;
    }

    public void execute() throws IOException, InterruptedException {
        GlossaryInputData glossaryInputData = new GlossaryInputData();
        glossaryInteractor.execute(glossaryInputData);
    }
}

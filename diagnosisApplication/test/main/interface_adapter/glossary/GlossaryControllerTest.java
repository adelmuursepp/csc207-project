package main.interface_adapter.glossary;

import main.data_access.GlossaryDataAccessObject;
import main.interface_adapter.ViewManagerModel;
import main.use_case.glossary.GlossaryDataAccessInterface;
import main.use_case.glossary.GlossaryInputBoundary;
import main.use_case.glossary.GlossaryInteractor;
import main.use_case.glossary.GlossaryOuputBoundary;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GlossaryControllerTest {

    @Test
    public void execute() throws IOException, InterruptedException {
        GlossaryViewModel viewModel = new GlossaryViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GlossaryOuputBoundary presenter = new GlossaryPresenter(viewModel, viewManagerModel);
        GlossaryDataAccessInterface glossaryDAO = new GlossaryDataAccessObject();
        GlossaryInputBoundary interactor = new GlossaryInteractor(glossaryDAO, presenter);
        GlossaryController controller = new GlossaryController(interactor);
        controller.execute();
    }
}
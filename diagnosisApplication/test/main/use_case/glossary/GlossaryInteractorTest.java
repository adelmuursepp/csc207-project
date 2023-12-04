package main.use_case.glossary;

import main.data_access.GlossaryDataAccessObject;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.glossary.GlossaryController;
import main.interface_adapter.glossary.GlossaryPresenter;
import main.interface_adapter.glossary.GlossaryViewModel;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GlossaryInteractorTest {

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
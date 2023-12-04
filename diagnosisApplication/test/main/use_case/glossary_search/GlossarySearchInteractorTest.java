package main.use_case.glossary_search;

import main.data_access.GlossaryDataAccessObject;
import main.interface_adapter.glossary.GlossaryViewModel;
import main.interface_adapter.glossary_search.GlossarySearchController;
import main.interface_adapter.glossary_search.GlossarySearchPresenter;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GlossarySearchInteractorTest {

    @Test
    public void execute() throws IOException, InterruptedException {
        GlossarySearchOutputBoundary presenter = new GlossarySearchPresenter(new GlossaryViewModel());
        GlossarySearchDataAccessInterface searchDAO = new GlossaryDataAccessObject();
        GlossarySearchInputBoundary interactor = new GlossarySearchInteractor(searchDAO, presenter);
        GlossarySearchController controller = new GlossarySearchController(interactor);
        controller.execute("TTY");
    }
}
package main.app;

import main.data_access.GlossaryDataAccessObject;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.glossary.GlossaryController;
import main.interface_adapter.glossary.GlossaryViewModel;
import main.interface_adapter.signup.SignupController;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.glossary.GlossaryDataAccessInterface;
import main.use_case.glossary.GlossaryInputBoundary;
import main.use_case.glossary.GlossaryInteractor;
import main.view.GlossaryView;
import main.view.SignupView;

import javax.swing.*;
import java.io.IOException;

public class GlossaryUseCaseFactory {

    private GlossaryUseCaseFactory() {}

    public static GlossaryView create(ViewManagerModel viewManagerModel,
                                      SymptomCheckerViewModel symptomCheckerViewModel,
                                      GlossaryViewModel glossaryViewModel,
                                      GlossaryDataAccessInterface glossaryDataAccessObject) {
        GlossaryController glossaryController = createGlossaryUseCase(glossaryDataAccessObject);
        return new GlossaryView(glossaryController, glossaryViewModel);

    }

    public static GlossaryController createGlossaryUseCase(GlossaryDataAccessInterface glossaryDataAccessObject) {

        GlossaryInputBoundary glossaryUseCaseInteractor = new GlossaryInteractor(glossaryDataAccessObject);

        return new GlossaryController(glossaryUseCaseInteractor);
    }
}

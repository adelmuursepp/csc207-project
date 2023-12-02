package main.app;

import main.data_access.GlossaryDataAccessObject;
import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.glossary.GlossaryViewModel;
import main.interface_adapter.glossary_search.GlossarySearchController;
import main.interface_adapter.glossary_search.GlossarySearchPresenter;
import main.interface_adapter.symptom_checker.SymptomCheckerController;
import main.interface_adapter.symptom_checker.SymptomCheckerPresenter;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.glossary_search.*;
import main.use_case.symptom_checker.SymptomCheckerInputBoundary;
import main.use_case.symptom_checker.SymptomCheckerInteractor;
import main.use_case.symptom_checker.SymptomCheckerOutputBoundary;
import main.view.GlossaryView;

import javax.swing.*;
import java.io.IOException;

public class GlossaryUseCaseFactory {
    private GlossaryUseCaseFactory() {}

    public static GlossaryView create(ViewManagerModel viewManagerModel,
                                      GlossaryViewModel glossaryViewModel,
                                      SymptomCheckerViewModel symptomCheckerViewModel) {
        try {
            GlossarySearchController glossarySearchController = createGlossarySearchUseCase(glossaryViewModel);
            SymptomCheckerController symptomCheckerController = createSymptomCheckerUseCase(symptomCheckerViewModel, viewManagerModel);
            return new GlossaryView(glossaryViewModel, glossarySearchController, symptomCheckerController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not retrieve glossary");
        }
        return null;
    }

    public static GlossarySearchController createGlossarySearchUseCase(GlossaryViewModel glossarySearchViewModel)
            throws IOException {

        GlossarySearchOutputBoundary glossarySearchPresenter = new GlossarySearchPresenter(glossarySearchViewModel);
        GlossarySearchDataAccessInterface glossarySearchDataAccessObject = new GlossaryDataAccessObject();

        GlossarySearchInputBoundary glossaryUseCaseInteractor = new GlossarySearchInteractor(glossarySearchDataAccessObject,
                glossarySearchPresenter);

        return new GlossarySearchController(glossaryUseCaseInteractor);
    }

    private static SymptomCheckerController createSymptomCheckerUseCase(SymptomCheckerViewModel symptomCheckerViewModel,
                                                                        ViewManagerModel viewManagerModel) throws IOException {

        SymptomCheckerOutputBoundary symptomCheckerPresenter = new SymptomCheckerPresenter(symptomCheckerViewModel,
                viewManagerModel);

        SymptomCheckerInputBoundary symptomCheckerInteractor = new SymptomCheckerInteractor(symptomCheckerPresenter);

        return new SymptomCheckerController(symptomCheckerInteractor);
    }
}

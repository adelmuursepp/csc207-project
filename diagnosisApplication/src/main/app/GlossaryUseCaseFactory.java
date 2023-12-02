package main.app;

import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.glossary.GlossaryController;
import main.interface_adapter.glossary.GlossaryViewModel;
import main.interface_adapter.glossary_search.GlossarySearchController;
import main.interface_adapter.glossary_search.GlossarySearchViewModel;
import main.interface_adapter.symptom_checker.SymptomCheckerController;
import main.interface_adapter.symptom_checker.SymptomCheckerPresenter;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import main.use_case.glossary_search.GlossarySearchDataAccessInterface;
import main.use_case.glossary_search.GlossarySearchInputBoundary;
import main.use_case.glossary_search.GlossarySearchInteractor;
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
                                      GlossarySearchViewModel glossarySearchViewModel,
                                      SymptomCheckerViewModel symptomCheckerViewModel,
                                      GlossarySearchDataAccessInterface glossarySearchDataAccessObject) {
        try {
            GlossarySearchController glossarySearchController = createGlossarySearchUseCase(glossarySearchDataAccessObject);
            SymptomCheckerController symptomCheckerController = createSymptomCheckerUseCase(symptomCheckerViewModel, viewManagerModel);
            return new GlossaryView(glossaryViewModel, glossarySearchController, glossarySearchViewModel, symptomCheckerController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not retrieve glossary");
        }
        return null;
    }

    public static GlossarySearchController createGlossarySearchUseCase(
            GlossarySearchDataAccessInterface glossaryDataAccessObject) throws IOException {

        GlossarySearchInputBoundary glossaryUseCaseInteractor = new GlossarySearchInteractor(glossaryDataAccessObject);

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

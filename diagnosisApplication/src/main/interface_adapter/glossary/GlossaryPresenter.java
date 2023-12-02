package main.interface_adapter.glossary;

import main.interface_adapter.ViewManagerModel;
import main.use_case.glossary.GlossaryOuputBoundary;
import main.use_case.glossary.GlossaryOutputData;

public class GlossaryPresenter implements GlossaryOuputBoundary {
    private final GlossaryViewModel glossaryViewModel;
    private final ViewManagerModel viewManagerModel;

    public GlossaryPresenter(GlossaryViewModel glossaryViewModel, ViewManagerModel viewManagerModel) {
        this.glossaryViewModel = glossaryViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareGlossaryView(GlossaryOutputData glossaryOutputData) {
        GlossaryState glossaryState = glossaryViewModel.getState();
        glossaryState.setTopics(glossaryOutputData.getTopics());
        glossaryViewModel.setState(glossaryState);
        glossaryViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(glossaryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

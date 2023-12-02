package main.interface_adapter.glossary_search;

import main.interface_adapter.glossary.GlossaryState;
import main.interface_adapter.glossary.GlossaryViewModel;
import main.use_case.glossary_search.GlossarySearchOutputBoundary;
import main.use_case.glossary_search.GlossarySearchOutputData;

public class GlossarySearchPresenter implements GlossarySearchOutputBoundary {
    final GlossaryViewModel glossarySearchViewModel;

    public GlossarySearchPresenter(GlossaryViewModel glossarySearchViewModel) {
        this.glossarySearchViewModel = glossarySearchViewModel;
    }

    @Override
    public void prepareSearchResults(GlossarySearchOutputData glossaryOutputData) {
        GlossaryState glossarySearchState = glossarySearchViewModel.getState();
        glossarySearchState.setContent(glossaryOutputData.getContent());

        glossarySearchViewModel.setState(glossarySearchState);
        glossarySearchViewModel.firePropertyChanged();
    }
}

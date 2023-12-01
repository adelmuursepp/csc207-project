package main.interface_adapter.proposed_symptoms;

import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.diagnosis.DiagnosisState;
import main.interface_adapter.diagnosis.DiagnosisViewModel;
import main.use_case.proposed_symptoms.ProposedSymptomsOutputBoundary;
import main.use_case.proposed_symptoms.ProposedSymptomsOutputData;

public class ProposedSymptomsPresenter implements ProposedSymptomsOutputBoundary {
    private final ProposedSymptomsViewModel proposedSymptomsViewModel;
    private ViewManagerModel viewManagerModel;
    public ProposedSymptomsPresenter(ProposedSymptomsViewModel proposedSymptomsViewModel) {
        this.proposedSymptomsViewModel = proposedSymptomsViewModel;
    }

    public void prepareProposedSymptomsView(ProposedSymptomsOutputData outputData) {
        ProposedSymptomsState proposedSymptomsState = proposedSymptomsViewModel.getState();

        proposedSymptomsState.setProposedSymptomsList(outputData.getProposedSymptomsList());

        this.proposedSymptomsViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(proposedSymptomsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}

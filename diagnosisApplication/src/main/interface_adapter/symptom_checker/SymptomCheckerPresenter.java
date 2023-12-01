package main.interface_adapter.symptom_checker;

import main.interface_adapter.ViewManagerModel;
import main.use_case.symptom_checker.SymptomCheckerOutputBoundary;
import main.use_case.symptom_checker.SymptomCheckerOutputData;

import java.util.List;

public class SymptomCheckerPresenter implements SymptomCheckerOutputBoundary {
    private final SymptomCheckerViewModel symptomCheckerViewModel;
    private final ViewManagerModel viewManagerModel;

    public SymptomCheckerPresenter(SymptomCheckerViewModel symptomCheckerViewModel, ViewManagerModel viewManagerModel) {
        System.out.println("presenter initialized");
        this.symptomCheckerViewModel = symptomCheckerViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void present(SymptomCheckerOutputData outputData) {
        SymptomCheckerState symptomCheckerState = symptomCheckerViewModel.getState();
        symptomCheckerViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(symptomCheckerViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

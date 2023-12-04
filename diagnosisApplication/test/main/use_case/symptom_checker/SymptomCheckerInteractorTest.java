package main.use_case.symptom_checker;

import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.symptom_checker.SymptomCheckerPresenter;
import main.interface_adapter.symptom_checker.SymptomCheckerViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class SymptomCheckerInteractorTest {
    SymptomCheckerViewModel viewModel = new SymptomCheckerViewModel();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    SymptomCheckerOutputBoundary presenter = new SymptomCheckerPresenter(viewModel, viewManagerModel);
    SymptomCheckerInputBoundary interactor = new SymptomCheckerInteractor(presenter);

    @Test
    public void execute() {
        SymptomCheckerInputData data = new SymptomCheckerInputData();
        interactor.execute(data);
    }
}
package main.interface_adapter.symptom_checker;

import main.interface_adapter.ViewManagerModel;
import main.interface_adapter.signup.SignupPresenter;
import main.use_case.signup.SignupOutputBoundary;
import main.use_case.symptom_checker.SymptomCheckerInputBoundary;
import main.use_case.symptom_checker.SymptomCheckerInteractor;
import main.use_case.symptom_checker.SymptomCheckerOutputBoundary;
import org.junit.Test;

import static org.junit.Assert.*;

public class SymptomCheckerControllerTest {
    SymptomCheckerViewModel viewModel = new SymptomCheckerViewModel();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    SymptomCheckerOutputBoundary presenter = new SymptomCheckerPresenter(viewModel, viewManagerModel);
    SymptomCheckerInputBoundary interactor = new SymptomCheckerInteractor(presenter);
    SymptomCheckerController controller = new SymptomCheckerController(interactor);

    @Test
    public void execute() {
        controller.execute();
    }
}
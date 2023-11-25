package main.interface_adapter.symptom_checker;

import main.use_case.symptom_checker.SymptomCheckerOutputBoundary;
import main.use_case.symptom_checker.SymptomCheckerOutputData;

import java.util.List;

public class SymptomCheckerPresenter implements SymptomCheckerOutputBoundary {

    @Override
    public void present(SymptomCheckerOutputData outputData) {

        List<String> symptoms = outputData.getSymptoms();
    }
}

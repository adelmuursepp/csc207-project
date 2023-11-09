package interface_adapter.symptom_checker;

import use_case.diagnosis.SymptomCheckerOutputBoundary;
import use_case.diagnosis.SymptomCheckerOutputData;

import java.util.List;

public class SymptomCheckerPresenter implements SymptomCheckerOutputBoundary {

    @Override
    public void present(SymptomCheckerOutputData outputData) {
        List<String> symptoms = outputData.getSymptoms();
    }
}

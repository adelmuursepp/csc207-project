package diagnosisApplication.src.main.interface_adapter.symptom_checker;

import diagnosisApplication.src.main.use_case.symptom_checker.SymptomCheckerOutputBoundary;
import diagnosisApplication.src.main.use_case.symptom_checker.SymptomCheckerOutputData;

import java.util.List;

public class SymptomCheckerPresenter implements SymptomCheckerOutputBoundary {

    @Override
    public void present(SymptomCheckerOutputData outputData) {

        List<Integer> symptoms = outputData.getCheckedSymptoms();
    }
}

package diagnosisApplication.src.main.interface_adapter.symptom_checker;

import main.use_case.symptom_checker.SymptomCheckerInteractor;

public class SymptomCheckerController {

    SymptomCheckerInteractor symptomCheckerInteractor;

    public SymptomCheckerController(SymptomCheckerInteractor symptomCheckerInteractor) {
        this.symptomCheckerInteractor = symptomCheckerInteractor;
    }

//    void toggleSymptom(String Symptom){
//
//        symptomCheckerInteractor.toggle(Symptom);

   // }
}

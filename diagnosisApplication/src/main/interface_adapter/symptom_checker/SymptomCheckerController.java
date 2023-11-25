package main.interface_adapter.symptom_checker;
import main.use_case.symptom_checker.SCInteractor;

public class SymptomCheckerController {

    SCInteractor symptomCheckerInteractor;

    public SymptomCheckerController(SCInteractor symptomCheckerInteractor) {
        this.symptomCheckerInteractor = symptomCheckerInteractor;
    }

//    void toggleSymptom(String Symptom){
//
//        symptomCheckerInteractor.toggle(Symptom);

   // }
}

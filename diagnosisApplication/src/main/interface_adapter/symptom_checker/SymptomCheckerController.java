package main.interface_adapter.symptom_checker;

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

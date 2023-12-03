package main.interface_adapter.past_diagnoses;

import main.use_case.past_diagnoses.PastDiagnosesInputBoundary;

public class PastDiagnosesController {
    final PastDiagnosesInputBoundary pastDiagnosesUseCaseInteractor;

    public PastDiagnosesController(PastDiagnosesInputBoundary pastDiagnosesUseCaseInteractor) {
        this.pastDiagnosesUseCaseInteractor = pastDiagnosesUseCaseInteractor;
    }

    public void execute() { pastDiagnosesUseCaseInteractor.execute();}
}

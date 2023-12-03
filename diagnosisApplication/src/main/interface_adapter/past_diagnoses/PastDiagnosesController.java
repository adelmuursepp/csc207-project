package main.interface_adapter.past_diagnoses;

public class PastDiagnosesController {
    final PastDiagnosesInputBoundary pastDiagnosesUseCaseInteractor;

    public PastDiagnosesController(PastDiagnosesInputBoundary pastDiagnosesUseCaseInteractor) {
        this.pastDiagnosesUseCaseInteractor = pastDiagnosesUseCaseInteractor;
    }

    public void execute() { pastDiagnosesUseCaseInteractor.execute();}
}

package Patient;

public class choosePatientController {
    private patientModel model;
    private PatientView view;

    public choosePatientController(patientModel model, PatientView view){
        this.setModel(model);
        this.setView(view);
    }

    public patientModel getModel() {
        return model;
    }

    public void setModel(patientModel model) {
        this.model = model;
    }

    public PatientView getView() {
        return view;
    }

    public void setView(PatientView view) {
        this.view = view;
    }

}

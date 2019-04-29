import Prescription.prescriptionModel;
import java.sql.Timestamp;

public class medicineModel extends prescriptionModel{

    private String medicationName;
    private enum administrationRoute{
        OR,
        IM,
        IV;
    }
    private String administrationRoute;
    private int ATC;

    public medicineModel(int dosage, String frequency, Timestamp startDate, Timestamp endDate, int unit, String medicationName,
                              String administrationRoute, int ATC){
        super(dosage, frequency, startDate, endDate, unit);
        this.setMedicationName(medicationName);
        this.setAdministrationRoute(administrationRoute);
        this.setATC(ATC);
    }

/*
Metoder:
- showPrescriptionInfo ()
- pullRecordInfo ()
*/
    private String getMedicationName() { return medicationName; }

    private void setMedicationName(String medicationName) { this.medicationName = medicationName; }

    private String getAdministrationRoute() { return administrationRoute; }

    private void setAdministrationRoute(String administrationRoute) { this.administrationRoute = administrationRoute; }

    private int getATC() { return ATC; }

    private void setATC(int ATC) { this.ATC = ATC; }

}
package ST6404;

import java.sql.Timestamp;

public class drugModel {
    private String medicationName;
    private String routeOfAdministration;
    private String atcCode;

    public drugModel(String medicineName, String atcCode, String routeOfAdministration) {
        this.setMedicationName(medicineName);
        this.setAtcCode(atcCode);
        this.setRouteOfAdministration(routeOfAdministration);
    }

/*
Metoder:
- showPrescriptionInfo ()
- pullRecordInfo ()
*/
    public String getMedicationName() { return medicationName; }

    public void setMedicationName(String medicationName) {this.medicationName = medicationName; }

    public String getRouteOfAdministration() { return routeOfAdministration; }

    public void setRouteOfAdministration(String administrationRoute) { this.routeOfAdministration = routeOfAdministration; }

    public String getAtcCode() { return atcCode; }

    public void setAtcCode(String atcCode) { this.atcCode = atcCode; }
}
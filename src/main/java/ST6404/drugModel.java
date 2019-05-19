package ST6404;

public class drugModel {
    public String medicationName;
    private String routeOfAdministration;
    private String atcCode;

    public drugModel(String medicineName, String atcCode, String routeOfAdministration) {
        this.setMedicationName(medicineName);
        this.setAtcCode(atcCode);
        this.setRouteOfAdministration(routeOfAdministration);
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getRouteOfAdministration() {
        return routeOfAdministration;
    }

    public void setRouteOfAdministration(String routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }

    public String getAtcCode() {
        return atcCode;
    }

    public void setAtcCode(String atcCode) {
        this.atcCode = atcCode;
    }
}
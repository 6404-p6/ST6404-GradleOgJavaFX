package ST6404;

import java.sql.Timestamp;

public class drugModel {



    private String medicationName;
    private String administrationRoute;
    private String ATC;

    public drugModel( String medicationName, String administrationRoute, String ATC){
        this.medicationName = medicationName;
        this.administrationRoute = administrationRoute;
        this.ATC = ATC;
    }

/*
Metoder:
- showPrescriptionInfo ()
- pullRecordInfo ()
*/
    public String getMedicationName() { return medicationName; }

    public String getAdministrationRoute() { return administrationRoute; }

    public void setAdministrationRoute(String administrationRoute) { this.administrationRoute = administrationRoute; }

    public String getATC() { return ATC; }

}
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
    private String getMedicationName() { return medicationName; }

    private String getAdministrationRoute() { return administrationRoute; }

    private void setAdministrationRoute(String administrationRoute) { this.administrationRoute = administrationRoute; }

    private String getATC() { return ATC; }

}
package ST6404;

import java.sql.Timestamp;

// ALT HERINDE SKAL LIGE ÆNDRES: EXTEND ER FORKERT RÆKKEFØLGE OG VI SNAKKER OM NOGLE ÆNDRER VED VEJLEDERMØDET

public class medicineModel {



    private String medicationName;
    private String administrationRoute;
    private String ATC;

    public medicineModel( String medicationName, String administrationRoute, String ATC){
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
package ST6404;
import ST6404.prescriptedDrugModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.*;
import java.util.stream.*;

public class medicineCardModel extends databaseConnectorController {
    private List medicineList;
    private String CPRNumber;
    private static medicineCardModel medicineCardModelObject;
    public String medicineName;
    public String atcCode;
    public String routeOfAdministration;

    public medicineCardController(String medicineName, String atcCode, String routeOfAdministration) {
        this.setMedicineName(medicineName);
        this.setAtcCode(atcCode);
        this.setRouteOfAdministration(routeOfAdministration);
    }

    public String getMedicineName() {return medicineName; }

    private void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getAtcCode() {return atcCode; }

    private void setAtcCode(String atcCode) {
        this.atcCode = atcCode;
    }

    public String getRouteOfAdministration() {return routeOfAdministration; }

    private void setRouteOfAdministration(String routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }





    // Til Tim: Denne skal lige kigges på efter ny
    //static List<prescriptedDrugModel> prescriptedDrugList = new ArrayList<>();
    //static List<prescriptedDrugModel> prescriptedDrugList = new ArrayList<>();

    //public static medicineCardModel getInstance(){
    //    if (medicineCardModelObject == null)
    //        medicineCardModelObject = new medicineCardModel();
    //    return medicineCardModel;
    //}

    /*
    public List<String> getMedicineListController;
    private List medicineListController;

    public medicineListController(List<String> medicineListController){
        this.getMedicineListController();
    }

    private List<String> getMedicineListController() { return medicineListController;}

    public void setMedicineList(List<String> medicineList) {
        this.medicineListController = medicineListController;
    }


    public medicineListModel (List medicineList, String CPRnumber, List availableMedicineList){
        this.medicineList = medicineList;
        this.CPRNumber = CPRnumber;
        this.availableMedicineList = availableMedicineList;
    }
*/
/*
Metoder:
- showMedicineList ()
- getFMKList ()
- createPrescription ()
- editMedicineList ()
- deleteMedicine ()
- updateExternalFMK ()
- getAvailableMedicineList ()
 */
    //public static void createPrescription(String a, String b, String c,int d, String e, String f, String g, String h){
    //    prescriptedDrugModel newPrescription = new prescriptedDrugModel(a,b,c,d,e,f,g,h);
    //    prescriptedDrugList.add(newPrescription);
    //}




}

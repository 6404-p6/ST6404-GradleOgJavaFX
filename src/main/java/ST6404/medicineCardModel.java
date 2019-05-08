package ST6404;
import ST6404.prescriptedDrugModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class medicineCardModel {
    private List medicineList;
    private String CPRNumber;
    private List availableMedicineList;

    // Til Tim: Denne skal lige kigges på efter ny
    static List<prescriptedDrugModel> prescriptedDrugList = new ArrayList<>();



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
public static void createPrescription(String a, String b, String c,int d, String e, String f, String g, String h){
prescriptedDrugModel newPrescription = new prescriptedDrugModel(a,b,c,d,e,f,g,h);
prescriptedDrugList.add(newPrescription);
}



}

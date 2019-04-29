package MedicineList;

import java.util.List;

public class medicineListModel {
    private List medicineList;
    private String CPRNumber;
    private List availableMedicineList;

    public medicineListModel (List medicineList, String CPRnumber, List availableMedicineList){
        this.medicineList = medicineList;
        this.CPRNumber = CPRnumber;
        this.availableMedicineList = availableMedicineList;
    }

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

}

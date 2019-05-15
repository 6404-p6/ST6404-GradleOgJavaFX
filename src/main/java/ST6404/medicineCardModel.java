package ST6404;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.List;

public class medicineCardModel{
    public List medicineList;


    public medicineCardModel(List medicineList) {
        this.medicineList = medicineList;
    }

    public List getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List medicineList) {
        this.medicineList = medicineList;
    }

    public void addToMedicineList(prescriptedDrugModel drugToAdd){
        medicineList.add(drugToAdd);
    }


}

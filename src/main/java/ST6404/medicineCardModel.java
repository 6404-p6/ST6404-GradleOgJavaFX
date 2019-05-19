package ST6404;

import javafx.collections.ObservableList;


public class medicineCardModel{
    public ObservableList medicineList;


    public medicineCardModel(ObservableList medicineList) {this.medicineList = medicineList;}

    public ObservableList getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(ObservableList medicineList) {
        this.medicineList = medicineList;
    }

    public void addToMedicineList(prescriptedDrugModel drugToAdd){
        medicineList.add(drugToAdd);
    }
}

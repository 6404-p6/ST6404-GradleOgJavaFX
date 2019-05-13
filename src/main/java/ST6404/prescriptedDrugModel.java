package ST6404;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Timestamp;

public class prescriptedDrugModel extends drugModel {
    private int dosage;
    private String frequency;
    // TD: Jeg kan ikke få dem indsat i tabellen endnu. Forstår ikke hvordan jeg laver dem i constructoren
    private String startDate;
    private String endDate;
    private String unit;

    public prescriptedDrugModel(String medicationName,int dosage, String unit, String frequency, String startDate, String endDate,String administrationRoute, String ATC){
        super (medicationName, administrationRoute, ATC);
        this.dosage = dosage;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.unit = unit;
    }
    //Metoder:
    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public static ObservableList<prescriptedDrugModel> getprescriptedDrugModelList(){
        ObservableList<prescriptedDrugModel> prescriptedDrugModelList = FXCollections.observableArrayList();
        //prescriptedDrugModelList.add(new prescriptedDrugModel("Warfarin", 10, "mg", "1 dagligt", "11-10-2019", "11-11-2019", "OR", "CDA131"));
        //prescriptedDrugModelList.add(new prescriptedDrugModel("Hyaliksin", 50, "ml", "i timen nar vagen", "13-11-2019", "15-11-2019", "IV", "FGB111"));
        //prescriptedDrugModelList.add(new prescriptedDrugModel("Warfarin", 5, "mg", "3 dagligt", "01-07-2019", "01-01-2020", "OR", "DEF221"));
        //prescriptedDrugModelList.add(new prescriptedDrugModel("Dicoumarol", 20, "mg", "1 dagligt", "01-07-2019", "01-01-2020", "OR", "ABC562"));
        return prescriptedDrugModelList;
    }



}



package ST6404;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class prescriptedDrugModel extends drugModel {
    private int dosage;
    private String frequency;
    // TD: Jeg kan ikke få dem indsat i tabellen endnu. Forstår ikke hvordan jeg laver dem i constructoren
    private String startDate;
    private String endDate;
    private String unit;

    public prescriptedDrugModel(String medicationName, String administrationRoute, String ATC, int dosage, String frequency, String startDate, String endDate, String unit){
        super (medicationName, administrationRoute, ATC);
        this.dosage = dosage;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.unit = unit;
    }

    //prescriptedDrugModel test = new prescriptedDrugModel("Placebo", "numse","AB001A01",100,"2 Dagligt","06-05-2019","06-06-2020","mL");

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
        prescriptedDrugModelList.add(new prescriptedDrugModel("Warfarin", "OR", "ABC131", 5, "1 dagligt", "Idag", "Imorgen", "mL"));
        return prescriptedDrugModelList;
    }
}



package ST6404;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Timestamp;
import java.util.ArrayList;

public class prescriptedDrugModel extends drugModel {
    private int dosage;
    private String frequency;
    private String startDate;
    private String endDate;
    private String unit;

    public prescriptedDrugModel(String medicineName, String atcCode, String routeOfAdministration, int dosage, String frequency, String startDate, String endDate, String unit) {
        super(medicineName, atcCode, routeOfAdministration);
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
}



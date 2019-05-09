package ST6404;

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
    /*

    private Timestamp getStartDate() {
        return startDate;
    }

    private void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    private Timestamp getEndDate() {
        return endDate;
    }

    private void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
    */

    }



package Prescription;

import java.sql.Timestamp;

public class prescriptionModel {
    private int dosage;
    private String frequency;
    private Timestamp startDate;
    private Timestamp endDate;
    private enum unit{
        mg,
        ml;
    }
    private int unit;

    public prescriptionModel (int dosage, String frequency, Timestamp startDate, Timestamp endDate, int unit){
        this.setDosage(dosage);
        this.setFrequency(frequency);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

//Metoder:
    private int getDosage() {
        return dosage;
    }

    private void setDosage(int dosage) {
        this.dosage = dosage;
    }

    private String getFrequency() {
        return frequency;
    }

    private void setFrequency(String frequency) {
        this.frequency = frequency;
    }

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


}

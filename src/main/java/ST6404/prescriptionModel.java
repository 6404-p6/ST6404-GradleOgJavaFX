package ST6404;

import java.sql.Timestamp;

// ALT HERINDE SKAL LIGE ÆNDRES: EXTEND ER FORKERT RÆKKEFØLGE OG VI SNAKKER OM NOGLE ÆNDRER VED VEJLEDERMØDET

public class prescriptionModel {
    private int dosage;
    private String frequency;
    // TD: Jeg kan ikke få dem indsat i tabellen endnu. Forstår ikke hvordan jeg laver dem i constructoren
    //private Timestamp startDate;
    //private Timestamp endDate;
    /*private enum unit{
        mg,
        ml;
    }
    private int unit;
    */

    public prescriptionModel (int dosage, String frequency/*Timestamp startDate, Timestamp endDate, int unit*/){
        this.setDosage(dosage);
        this.setFrequency(frequency);
        //this.setStartDate(startDate);
        //this.setEndDate(endDate);
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

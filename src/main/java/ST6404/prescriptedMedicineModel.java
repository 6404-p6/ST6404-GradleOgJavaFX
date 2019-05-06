package ST6404;

import java.sql.Timestamp;


public class prescriptedMedicineModel extends medicineModel {
    private int dosage;
    private String frequency;
    // TD: Jeg kan ikke få dem indsat i tabellen endnu. Forstår ikke hvordan jeg laver dem i constructoren
    private Timestamp startDate;
    private Timestamp endDate;
    String unit;

    public prescriptedMedicineModel( String medicationName, String administrationRoute, int ATC,int dosage, String frequency, Timestamp startDate, Timestamp endDate, String unit){
        super (medicationName, administrationRoute, ATC);
        this.dosage = dosage;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.unit = unit;
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

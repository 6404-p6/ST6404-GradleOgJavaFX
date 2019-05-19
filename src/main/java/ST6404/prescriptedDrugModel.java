package ST6404;


public class prescriptedDrugModel extends drugModel {
    private int dosage;
    private String frequency;
    private String startDate;
    private String endDate;
    private String unit;
    private boolean exampleForVisualization;

    public prescriptedDrugModel(String medicineName, String atcCode, String routeOfAdministration, int dosage, String frequency, String startDate, String endDate, String unit) {
        super(medicineName, atcCode, routeOfAdministration);
        this.dosage = dosage;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.unit = unit;
    }

    //Metoder:


    public boolean isExampleForVisualization() {
        return exampleForVisualization;
    }

    public void setExampleForVisualization(boolean exampleForVisualization) {
        this.exampleForVisualization = exampleForVisualization;
    }

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



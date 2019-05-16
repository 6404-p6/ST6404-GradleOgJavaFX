package ST6404;

/*
* Dette er model-klassen for patient.
 */

public class patientModel {

    private String firstName;
    private String lastName;
    private String CPRNumber;
    public medicineCardModel medicineCard;

    public patientModel(String firstName, String lastName, String CPRNumber, medicineCardModel medicineCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CPRNumber = CPRNumber;
        this.medicineCard = medicineCard;
    }

    // Getters og setters
    public String getPatientIdentification() {return firstName + " " + lastName + ", CPR: " + CPRNumber;}

    public String getFirstName() { return firstName; }

    // Bruges i Databasecontroller
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    // Bruges i Databasecontroller
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCPRNumber() { return CPRNumber; }

    // Bruges i Databasecontroller
    public void setCPRNumber(String CPRNumber) { this.CPRNumber = CPRNumber; }

}

package ST6404;


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

    public String getPatientIdentification() {return firstName + " " + lastName + ", CPR: " + CPRNumber;}

    public String getCPRNumber() { return CPRNumber; }

}

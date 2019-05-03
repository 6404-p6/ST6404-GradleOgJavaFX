package ST6404;

/*
* Dette er model-klassen for patient.
 */

public class patientModel{
    public static databaseConnectorController patientModel;
    // Klassen har attributterne fornavn, efternavn og cpr-nummer
    private String firstName;
    private String lastName;
    private String CPRNumber;

    // Atributterne opstilles i en contruktur for at kunne instantieres senere i main.
    public patientModel(String firstName, String lastName, String CPRNumber){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCPRNumber(CPRNumber);
    }

    // Returnere attributten firstname
    private String getFirstName() { return firstName; }

    private void setFirstName(String firstName) { this.firstName = firstName; }

    // Returnere attributten lastname
    private String getLastName() { return lastName; }

    private void setLastName(String lastName) { this.lastName = lastName; }

    // Returnere attributten getCPRnumber
    private String getCPRNumber() { return CPRNumber; }

    private void setCPRNumber(String CPRNumber) { this.CPRNumber = CPRNumber; }





}

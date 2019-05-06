package ST6404;

/*
* Dette er model-klassen for patient.
 */

public class patientModel {
    public static databaseConnectorController patientModel;
    // Klassen har attributterne fornavn, efternavn og cpr-nummer
    public String firstName;
    public String lastName;
    public String CPRNumber;

    // Atributterne opstilles i en contruktur for at kunne instantieres senere i main.
    public patientModel(String firstName, String lastName, String CPRNumber){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCPRNumber(CPRNumber);
    }

    // LoadedPatientData


    public String getPatientIdentification() {return firstName + " " + lastName + ", CPR: " + CPRNumber;}

    // Returnere attributten firstname
    public String getFirstName() { return firstName; }

    // Bruges i Databasecontroller
    public void setFirstName(String firstName) { this.firstName = firstName; }

    // Returnere attributten lastname
    public String getLastName() { return lastName; }

    // Bruges i Databasecontroller
    public void setLastName(String lastName) { this.lastName = lastName; }

    // Returnere attributten getCPRnumber
    public String getCPRNumber() { return CPRNumber; }

    // Bruges i Databasecontroller
    public void setCPRNumber(String CPRNumber) { this.CPRNumber = CPRNumber; }


    





}

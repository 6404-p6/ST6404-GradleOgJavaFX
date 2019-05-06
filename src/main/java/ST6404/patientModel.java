package ST6404;

/*
* Dette er model-klassen for patient.
 */

public class patientModel {
    public static databaseConnectorController patientModel;
    //Singleton objekt
    private static patientModel patientModelObject;
    // Klassen har attributterne fornavn, efternavn og cpr-nummer
    public String firstName;
    public String lastName;
    public String CPRNumber;

    // Atributterne opstilles i en contruktur for at kunne instantieres senere i main.
    private patientModel(){

    }

    public static patientModel getInstance(){
        if (patientModelObject == null)
            patientModelObject = new patientModel();
        return patientModelObject;
    }


    public String getPatientIdentification() {return firstName + " " + lastName + ", CPR: " + CPRNumber;}


    // Returnere attributten firstname
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    // Returnere attributten lastname
    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    // Returnere attributten getCPRnumber
    public String getCPRNumber() { return CPRNumber; }

    public void setCPRNumber(String CPRNumber) { this.CPRNumber = CPRNumber; }


    





}

package ST6404;

/*
* Dette er model-klassen for patient.
 */

public class patientModel extends databaseConnectorController {
    public static databaseConnectorController patientModel;
    // Klassen har attributterne fornavn, efternavn og cpr-nummer
    public static String firstName;
    public static String lastName;
    public String CPRNumber;

    // Atributterne opstilles i en contruktur for at kunne instantieres senere i main.
    public patientModel(String firstName, String lastName, String CPRNumber){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCPRNumber(CPRNumber);
    }

    // LoadedPatientData
    public static void getPatientInfo(){
        try {
            patientModel LoadedPatientData = databaseConnectorController.loadPatientData();
            System.out.println("Name: " + firstName + " " + lastName);
        } catch (Exception e) {
            System.out.println("Something went wrong..." + e.getMessage());
        }
    }


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

package ST6404;

/*
* Dette er model-klassen for patient.
 */

public class patientModel {
    //Singleton objekt for at kunne instantiere den
    private static patientModel patientModelObject;

    public static String firstName;
    public static String lastName;
    public String CPRNumber;
    private medicineCardModel medicineCard;

    // Tom Singleton constructor. Den er tom, så den er nemmere at skrive i metoden getInstance
    // sådan at det fylder mindre og er hurtigere. first, lastName og CPR sættes med setters
    // i stykket lige efter den instantieres første gang, nemlig efter kald til SQL i
    // databaseConnectorController.loadPatientData()
    private patientModel(){
    }

    public static patientModel getInstance(){
        if (patientModelObject == null)
            patientModelObject = new patientModel();
        return patientModelObject;
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

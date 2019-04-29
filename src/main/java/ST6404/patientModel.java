package Patient;

public class patientModel {

    private String firstName;
    private String lastName;
    private String CPRNumber;

    public patientModel(String firstName, String lastName, String CPRNumber){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCPRNumber(CPRNumber);
    }

    private String getFirstName() { return firstName; }

    private void setFirstName(String firstName) { this.firstName = firstName; }

    private String getLastName() { return lastName; }

    private void setLastName(String lastName) { this.lastName = lastName; }

    private String getCPRNumber() { return CPRNumber; }

    private void setCPRNumber(String CPRNumber) { this.CPRNumber = CPRNumber; }





}

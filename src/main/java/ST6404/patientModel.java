package ST6404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* Dette er model-klassen for patient.
 */


public class patientModel {
    // Klassen har attributterne fornavn, efternavn og cpr-nummer
    private String firstName;
    private String lastName;
    private String CPRNumber;

    public static void getPatientdatafromSQL () throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl =
                "https://db.course.hst.aau.dk/phpmyadmin/sql.php?server=1&db=hst_2019_19gr6404&table=patientdatabase&pos=0&token=76c8a524756aa73ade2e664ae9d13ef1";
        Connection conn = DriverManager.getConnection(connectionUrl);
        //ResultSet rs = conn.prepareStatement("show tables").executeQuery();
        ResultSet rs = conn.prepareStatement("SELECT * FROM `patientdatabase`").executeQuery();
        while(rs.next()) {
            String s = rs.getString(1);
            System.out.println(s);
        }
    }

    public void loadPatientInfo (){

    }

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

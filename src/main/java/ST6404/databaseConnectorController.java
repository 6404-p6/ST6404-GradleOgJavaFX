package ST6404;
//import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class databaseConnectorController {
    public static void databaseConnectorController() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        ResultSet patient = connection.prepareStatement("SELECT * FROM `patientdatabase`").executeQuery();
        ResultSet praeparatdatabase = connection.prepareStatement("SELECT * FROM `praeparatdatabase`").executeQuery();
        ResultSet MIdatabase = connection.prepareStatement("SELECT * FROM `MIdatabase`").executeQuery();
        while (patient.next()) {
            String a = patient.getString(1);
            System.out.println(a);
        }
        while (praeparatdatabase.next()) {
            String b = praeparatdatabase.getString(2);
            System.out.println(b);
        }
        while (MIdatabase.next()) {
            String c = MIdatabase.getString(2);
            System.out.println(c);
        }
    }

    /* Denne metode skal hente patientdata fra MySQL.
     */

    public static void loadPatientData(String CPRInput) throws ClassNotFoundException, SQLException {
        Statement st;
        st = null;
        ResultSet rs;
        rs = null;
        String CPR;          // Patientens CPR
        String FirstName;    // Patientens fornavn
        String LastName;     // Patientens efternavn
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        ArrayList<>
        try {
            String SQL1 = ("select *FROM patientdatabase WHERE CPR = " + CPRInput);
            connection.createStatement().executeQuery(SQL1);   // Forbindes til vores URL.
            st = connection.createStatement();          //
            rs = st.executeQuery(SQL1);                 //
            if (rs.next()) {                            // Hvis CPR genkendes, så gemmes CPR, fornavn og efternavn.
                CPR = rs.getString(1);              // Finder CPR i første kolonne.
                FirstName = rs.getString(2);        // Finder fornavn i anden kolonne.
                LastName = rs.getString(3);         // Finder efternavn i tredje kolonne.
                //patientModel loadedPatientData = new patientModel(FirstName,LastName,CPR);
                patientModel chosenPatient = patientModel.getInstance();
                chosenPatient.setFirstName(FirstName);
                chosenPatient.setLastName(LastName);
                chosenPatient.setCPRNumber(CPR);
                //new patientModel(FirstName, LastName, CPR);
            } else {
                System.out.println("CPR eksisterer ikke. Prøv igen.");     // Hvis systemet ikke finder CPR, skal der skrives fejl.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL FEJL");    // Hvis forbindelse ikke kan oprettes.
        }
    }
    public void loadMedicineList() throws ClassNotFoundException, SQLException {
        Statement st;
        st = null;
        ResultSet rs;
        rs = null;
        String navn;
        int dosis;
        String enhed;
        String hyppighed;
        String startdato;
        String slutdato;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        List<List>list = new ArrayList<List>();
        try {
            String SQL2 = ("SELECT * FROM `FMKdatabase`  WHERE CPR = ");
            connection.createStatement().executeQuery(SQL2);   // Forbindes til vores URL.
            st = connection.createStatement();
            rs = st.executeQuery(SQL2);
            if (rs.next()) {
                navn = rs.getString(2);
                dosis = rs.getInt(3);
                enhed = rs.getString(4);
                hyppighed = rs.getString(5);
                startdato = rs.getString(6);
                slutdato = rs.getString(7);
                //prescriptedDrugModel prescriptedDrugModel = new prescriptedDrugModel();
                list.add(navn);
                list.add(dosis);
                list.add(enhed);
                list.add(hyppighed);
                list.add(startdato);
                list.add(slutdato);
            } else {
                System.out.println("Forkert CPR");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL ERROR");    // Hvis forbindelse ikke kan oprettes.
        }
    }
}
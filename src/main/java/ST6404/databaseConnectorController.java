package ST6404;
//import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

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
    }*/
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
        try {
            String SQL = ("select *FROM patientdatabase WHERE CPR = " + CPRInput);
            connection.createStatement().executeQuery(SQL);   // Forbindes til vores URL.
            st = connection.createStatement();
            rs = st.executeQuery(SQL1);
            if (rs.next()) {
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
        String ATC;
        String administrationsvej;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        try {
            String SQL2 = ("select *FROM praeparatdatabase WHERE atc = B01AA02"); // B01AA02
            connection.createStatement().executeQuery(SQL2);   // Forbindes til vores URL.
            st = connection.createStatement();
            rs = st.executeQuery(SQL2);
            if (rs.next()) {
                navn = rs.getString(1);
                ATC = rs.getString(2);
                administrationsvej = rs.getString(3);
                //medicineInteractionModel LoadedMedicine = new medicineListModel(navn,ATC,administrationsvej);
            } else {
                System.out.println("Medikament eksisterer ikke");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL ERROR");    // Hvis forbindelse ikke kan oprettes.
        }
    }

    /*public static void loadMedicationError() throws ClassNotFoundException, SQLException {
        Statement st = null;
        ResultSet rs = null;
        String MedikamentA;
        String MedikamentB;
        String alvorlighedsgrad;
        String dokumentationsgrad;
        String anbefaling;
        String beskrivelse;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
    }*/
}
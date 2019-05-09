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
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        try {
            String SQL1 = ("select *FROM patientdatabase WHERE CPR = " + CPRInput);
            connection.createStatement().executeQuery(SQL1);   // Forbindes til vores URL.
            st = connection.createStatement();          //
            rs = st.executeQuery(SQL1);                 //
            if (rs.next()) {                            // Hvis CPR genkendes, så gemmes CPR, fornavn og efternavn.
                String CPR = rs.getString(1);              // Finder CPR i første kolonne.
                String FirstName = rs.getString(2);        // Finder fornavn i anden kolonne.
                String LastName = rs.getString(3);         // Finder efternavn i tredje kolonne.
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

    /*public static void loadMedicineList() throws ClassNotFoundException, SQLException {
        Statement st;
        st = null;
        ResultSet rs;
        rs = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        try {
            String SQL2 = ("SELECT * FROM `FMKdatabase`  WHERE CPR = 1122335678");
            connection.createStatement().executeQuery(SQL2);   // Forbindes til vores URL.
            st = connection.createStatement();
            rs = st.executeQuery(SQL2);
            if (rs.next()) {
                String navn = rs.getString(2);
                int dosis = rs.getInt(3);
                String enhed = rs.getString(4);
                String hyppighed = rs.getString(5);
                String startdato = rs.getString(6);
                String slutdato = rs.getString(7);
                } else {
                System.out.println("Forkert CPR");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL ERROR");    // Hvis forbindelse ikke kan oprettes.
        }
    }*/

    public static ArrayList<prescriptedDrugModel> loadMedicineList() throws ClassNotFoundException, SQLException {
        Statement st;
        st = null;
        ResultSet rs;
        rs = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        try {
            String SQL2 = ("SELECT * FROM `FMKdatabase`  WHERE CPR = 1122335678");
            connection.createStatement().executeQuery(SQL2);   // Forbindes til vores URL.
            st = connection.createStatement();
            rs = st.executeQuery(SQL2);
            if (rs.next()) {
                ArrayList<prescriptedDrugModel> prescriptedDrugList = new ArrayList<>();
                prescriptedDrugModel prescriptedDrugModel = new prescriptedDrugModel(rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(7), rs.getString(7)); // Indsæt til construktor.
                prescriptedDrugList.add(prescriptedDrugModel);
                return prescriptedDrugList;
            } else {
                System.out.println("Forkert CPR");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL ERROR");    // Hvis forbindelse ikke kan oprettes.
        }
        return null;
    }
}

// prescriptedDrugModel prescriptedDrugModel
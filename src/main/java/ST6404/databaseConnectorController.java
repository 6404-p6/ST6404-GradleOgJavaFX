package ST6404;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class databaseConnectorController {

    //static patientModel patientModel = new patientModel();

    public static void databaseConnectorController() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connect = DriverManager.getConnection(connectionUrl);
        ResultSet patient = connect.prepareStatement("SELECT * FROM `patientdatabase`").executeQuery();
        ResultSet praeparatdatabase = connect.prepareStatement("SELECT * FROM `praeparatdatabase`").executeQuery();
        ResultSet MIdatabase = connect.prepareStatement("SELECT * FROM `MIdatabase`").executeQuery();
        while (patient.next()) {
            String a = patient.getString(2);
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
        // Dette er koden, som volder problemer!!!
        // Bemærk at linje 11 også skal bruges til koden.
        /*public static void loadPatientData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(connectionUrl);
        Statement st = null; //
        ResultSet rs = null; //
        String CPR;          // Patientens CPR
        String FirstName;    // Patientens fornavn
        String LastName;     // Patientens efternavn
        try {
            String SQL =("select *FROM patientdatabase WHERE CPR = 1122335678");
            conn().createStatement().executeQuery(SQL);   // Forbindes til vores URL.
            st = conn().createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                CPR = rs.getString(1);              // Finder CPR i første kolonne.
                FirstName = rs.getString(2);        // Finder fornavn i anden kolonne.
                LastName = rs.getString(3);         // Finder efternavn i tredje kolonne.
                patientModel.setCPRNumber(CPR);
                patientModel.setFirstName(FirstName);
                patientModel.setLastName(LastName);
            } else {
                System.out.println("fejl");     // Hvis systemet ikke finder CPR, skal der skrives fejl.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL ERROR");    // Hvis forbindelse ikke kan oprettes.
        }
    }*/
}
    /*
    Metoder
    - loadPatientData () // Igangsat af Marianne.
    - loadMedicineList ()
    - loadMedicineInteractions ()
     */

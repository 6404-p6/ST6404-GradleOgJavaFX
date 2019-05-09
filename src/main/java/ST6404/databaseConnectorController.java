package ST6404;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;

public class databaseConnectorController {

    /*public static void databaseConnectorController() throws ClassNotFoundException, SQLException {
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
            rs = st.executeQuery(SQL);
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
                System.out.println("CPR eksistere ikke. Prøv igen.");     // Hvis systemet ikke finder CPR, skal der skrives fejl.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL ERROR");    // Hvis forbindelse ikke kan oprettes.
        }
    }

    public static void loadPatienloadMedicineListtData() throws ClassNotFoundException, SQLException {
        Statement st = null;
        ResultSet rs = null;
        String navn;
        String ATC;
        String administrationsvej;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        try {
            String SQL = ("select *FROM MIdatabase WHERE navn = warfarin"); //skal vel være vores FMKdatabase? (SA)
            connection.createStatement().executeQuery(SQL);   // Forbindes til vores URL.
            st = connection.createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                navn = rs.getString(1);              // Finder CPR i første kolonne.
                ATC = rs.getString(2);        // Finder fornavn i anden kolonne.
                administrationsvej = rs.getString(3);         // Finder efternavn i tredje kolonne.
            } else {
                System.out.println("Medikament eksistere ikke");     // Hvis systemet ikke finder CPR, skal der skrives fejl.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL ERROR");    // Hvis forbindelse ikke kan oprettes.
        }
    }
/*
    public static void loadMedicationError() throws ClassNotFoundException, SQLException {
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

    public static void interactionList() {
        try {
            // create our mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT medikamentA, medikamentB, alvorlighedsgrad, dokumentationsgrad, anbefaling, beskrivelse FROM MIdatabase WHERE MedikamentA = 'dicoumarol' AND MedikamentB = 'ergotamine'";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                String medicamentA = rs.getString("medikamentA");
                String medicamentB = rs.getString("medikamentB");
                int severity = rs.getInt("alvorlighedsgrad");
                int documentationLevel = rs.getInt("dokumentationsgrad");
                String recommendationText = rs.getString("anbefaling");
                String descriptionOfEffect = rs.getString("beskrivelse");

                medicineInteractionModel interactionList = new medicineInteractionModel(medicamentA, medicamentB, documentationLevel, severity, recommendationText, descriptionOfEffect);

                System.out.println(interactionList.getMedicamentA());
                System.out.println(interactionList.getMedicamentB());
                System.out.println(interactionList.getDocumentationLevel());
                System.out.println(interactionList.getSeverity());
                System.out.println(interactionList.getRecommendationText());
                System.out.println(interactionList.getDescriptionOfEffect());
                // print the results
               // System.out.format("%s, %s, %s, %s, %s, %s\n", medicamentA, medicamentB, severity, probability, recommendationText, descriptionOfEffect);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}
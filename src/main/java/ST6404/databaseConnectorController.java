package ST6404;
//import javax.swing.plaf.nimbus.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.Date;

public class databaseConnectorController {
    /*
    loadPatientData (MGS + TD) skal hente patientdata fra MySQL. Den har 2 throws, som gør at ...
    Koden laver et Try, hvor den søger efter et CPR-input fra brugeren. Hvis CPR-inputtet stemmer overens
    med et CPR-nr. fra patientdatabase vil fornavn og efternavn blive vist.
     */
    public patientModel loadPatientData(String CPRInput) throws ClassNotFoundException, SQLException {
        Statement st;           // Deklarer et statement til st.
        st = null;              // Fortæller, at ST = null ->
        ResultSet rs;           // Deklarer vores ResultSet til rs.
        rs = null;              // Fortæller, at ST = null ->
        Class.forName("com.mysql.cj.jdbc.Driver"); // Vores driver.
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        try {
            String SQL1 = ("select *FROM patientdatabase WHERE CPR = " + CPRInput); // Søger efter et CPR i patientdatabase, som stemmer overens med det indtastede
            connection.createStatement().executeQuery(SQL1);   // Forbinder til vores URL.
            st = connection.createStatement();          // ST får nu betydning.
            rs = st.executeQuery(SQL1);                 // Rs bliver sat til en SQL Query. Den kan nu indeholder info fra vores MySQL database, som ikke var en mulighed før.
            if (rs.next()) {                            // Hvis CPR genkendes, så hentes CPR, fornavn og efternavn.
                String CPR = rs.getString(1);              // Finder CPR i første kolonne.
                String FirstName = rs.getString(2);        // Finder fornavn i anden kolonne.
                String LastName = rs.getString(3);         // Finder efternavn i tredje kolonne.

                patientModel tempPatientModel = new patientModel(FirstName, LastName, CPR, null);
                return tempPatientModel;
            } else {
                System.out.println("CPR eksisterer ikke. Prøv igen.");     // Hvis systemet ikke finder CPR, skal der skrives fejl.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL FEJL");    // Hvis forbindelse ikke kan oprettes.
        }   return null;
    }

    public static void interactionList() {
        try {
            // create our mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM MIdatabase WHERE MedikamentA = 'dicoumarol' AND MedikamentB = 'ergotamine'";

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

   /* public static void availableMedicineList() {
        try {
            // create our mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM praeparatdatabase";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                String medicineName = rs.getString("navn");
                String atcCode = rs.getString("atc");
                String routeOfAdministration = rs.getString("administrationsvej");

                drugModel availableMedicineList = new drugModel(medicineName, atcCode, routeOfAdministration);

                System.out.println(availableMedicineList.getMedicationName());
                System.out.println(availableMedicineList.getAtcCode());
                System.out.println(availableMedicineList.getRouteOfAdministration());

            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

// Nedenstående virker. Den sletter medikamenter fra patientens FMK
    public static void deleteDrugRow() {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "DELETE FROM FMKdatabase WHERE CPR = '3003965678' AND navn = 'reserpine'";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC",
                    "hst_2019_19gr6404", "agipheethohwiquiteam");
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void addRow () {
        try {
            String url = "com.mysql.cj.jdbc.Driver";
            Connection conn = DriverManager.getConnection("jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC",
                    "hst_2019_19gr6404", "agipheethohwiquiteam");
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO FMKdatabase  VALUES ('3003965678', 50, 'mg', '3 gange dagligt', 2019-02-03, 2019-02-04)");

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }
    public static void updateRow () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC",
                    "hst_2019_19gr6404", "agipheethohwiquiteam");
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE FMKdatabase SET navn = disedase, dosis = 5 WHERE CPR = 3003965678");

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }*/

}

    //edit

    //insert eller add


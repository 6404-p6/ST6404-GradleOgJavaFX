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

public class databaseConnectorController { // Dette er en testerkode. Den skal slettes ind aflevering og kan tjekke forbindelsen til MySQL.
    /*public static void databaseConnectorController() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        ResultSet patient = connection.prepareStatement("SELECT * FROM `patientdatabase`").executeQuery();
        ResultSet praeparatdatabase = connection.prepareStatement("SELECT * FROM `praeparatdatabase`").executeQuery();
        ResultSet MIdatabase = connection.prepareStatement("SELECT * FROM `MIdatabase`").executeQuery();
        ResultSet FMKdatabase = connection.prepareStatement("SELECT * FROM `FMKdatabase`  WHERE CPR = 2233449876").executeQuery();
        /*while (patient.next()) {
            String a = patient.getString(1);
            System.out.println(a);}
        while (praeparatdatabase.next()) {
            String b = praeparatdatabase.getString(2);
            System.out.println(b);}
        while (MIdatabase.next()) {
            String c = MIdatabase.getString(2);
            System.out.println(c);}
        while (FMKdatabase.next()) {
            String a = FMKdatabase.getString(2);
            System.out.println(a);}
    } */
    /*
    loadPatientData (MGS + TD) skal hente patientdata fra MySQL. Den har 2 throws, som gør at ...
    Koden laver et Try, hvor den søger efter et CPR-input fra brugeren. Hvis CPR-inputtet stemmer overens
    med et CPR-nr. fra patientdatabase vil fornavn og efternavn blive vist.
     */
    public static void loadPatientData(String CPRInput) throws ClassNotFoundException, SQLException {
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
                String CPR = rs.getString(1);              // Finder CPR i første kolonne af databasen.
                String FirstName = rs.getString(2);        // Finder fornavn i anden kolonne af databasen.
                String LastName = rs.getString(3);         // Finder efternavn i tredje kolonne af databasen.
                //patientModel loadedPatientData = new patientModel(FirstName,LastName,CPR);
                patientModel chosenPatient = patientModel.getInstance();    //
                chosenPatient.setFirstName(FirstName);                      // Vi anvender set, da vi kun har brug en string til næste skridt i projektet.
                chosenPatient.setLastName(LastName);                        // Same.
                chosenPatient.setCPRNumber(CPR);                            // Same.
                //new patientModel(FirstName, LastName, CPR);
            } else {
                System.out.println("CPR eksisterer ikke. Prøv igen.");     // Hvis systemet ikke finder CPR, skal der skrives fejl.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL FEJL");    // Hvis forbindelse ikke kan oprettes.
        }
    }

    // Kan denne kode slettes? --- Start ----
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
    }
    // ?????? ---- Slut ----

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

    public static void availableMedicineList() {
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

    /*
    loadMedicineList(MGS) henter patientens informationer fra FMK-databasen og gemmer dem i en liste: prescriptedDrugList
    ObservableList er en unik JavaFX funktion.
    OBS:! Funktionen er ikke færdig, da CPR ikke skal indskrives af brugeren endnu for at virke.

     */
    public static void loadMedicineList() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        ResultSet FMKdatabase = connection.prepareStatement("SELECT * FROM `FMKdatabase`  WHERE CPR = 1122335678").executeQuery(); //1122335678
        while (FMKdatabase.next()) {
            // Brug constructor for medicineCard og dens attribut medicineList

            ObservableList<String> prescriptedDrugList = FXCollections.observableArrayList();
            prescriptedDrugList.add(FMKdatabase.getString(2));
            prescriptedDrugList.add(FMKdatabase.getString(3));
            prescriptedDrugList.add(FMKdatabase.getString(4));
            prescriptedDrugList.add(FMKdatabase.getString(5));
            prescriptedDrugList.add(FMKdatabase.getString(6));
            prescriptedDrugList.add(FMKdatabase.getString(7));
            // Brug constructor for prescriptedDrugModel
            // medicineCard.medicinelist.ad(Constructor indsæt her)
            System.out.println(prescriptedDrugList);
        }
    }
    /*
    Vi skal bruge den nederste, og denne skal instantieres.
     */

    public static medicineCardModel getMedicineCard(String id){
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
            Class.forName(myDriver);
            String test = "select From FMKdatabase Where CPR = " + id;
            Connection conn = DriverManager.getConnection(myUrl);
            PreparedStatement st  = conn.prepareStatement("select * from FMKdatabase Where CPR = " + id); //
            ResultSet rs = st.executeQuery();
            List<prescriptedDrugModel> pml = new ArrayList<prescriptedDrugModel>();
            while(rs.next()) {
                prescriptedDrugModel pm = new prescriptedDrugModel(rs.getString("navn"), rs.getInt("dosis"), rs.getString("enhed"), rs.getString("hyppighed"), rs.getString("startdato"), rs.getString("slutdato"),"or", "atc");
                pml.add(pm);
            }
            medicineCardModel m = new medicineCardModel(pml);
            return m;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }



    public static void deleteRow(String dicoumarol) {
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl);

            PreparedStatement st = conn.prepareStatement("DELETE FROM FMKdatabase WHERE name = ?");
            st.setString(1, dicoumarol);
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

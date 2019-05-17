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

public class databaseConnectorController {
    /*
    loadPatientData (MGS + TD) skal hente patientdata fra MySQL. Den har 2 throws, som gør at ...
    Koden laver et Try, hvor den søger efter et CPR-input fra brugeren. Hvis CPR-inputtet stemmer overens
    med et CPR-nr. fra patientdatabase vil fornavn og efternavn blive vist.
    */
    public patientModel loadPatientData(String CPRInput) throws ClassNotFoundException, SQLException {
        Statement st;           // Deklarer et statement til st.
        st = null;              // Fortæller, at st = null -> st er tom, indeholder ingenting.
        ResultSet rs;           // Deklarer vores ResultSet til rs.
        rs = null;              // Fortæller, at rs = null -> rs er tom, indeholder ingenting.
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
        }
        return null;
    }

    // Der er en metode under opbygning, under denne metode. I den nye er den ved at gøres implementerbar.
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

    // Dette er den ovenstående metode der er "in progress" til at blive lavet implementerbar.
    public List loadInteractionsList(List medicineList) {
        String tempSQLDrugNames = "";
        for(int i = 0; i < medicineList.size(); i++ ){
            prescriptedDrugModel tempPrescriptedDrugModel = (prescriptedDrugModel) medicineList.get(i);
            tempSQLDrugNames = "'" + tempPrescriptedDrugModel.medicationName + "', " + tempSQLDrugNames;
        }
        tempSQLDrugNames = tempSQLDrugNames.substring(0, (tempSQLDrugNames.length()-2));

        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM MIdatabase WHERE MedikamentA IN (" + tempSQLDrugNames + ") AND MedikamentB IN (" + tempSQLDrugNames + ")");
            ResultSet rs = st.executeQuery();
            List<medicineInteractionModel> tempIntList = new ArrayList<medicineInteractionModel>();

            while (rs.next()) {
                medicineInteractionModel tempInteraction = new medicineInteractionModel(rs.getString("MedikamentA"), rs.getString("MedikamentB"), rs.getInt("alvorlighedsgrad"), rs.getInt("dokumentationsgrad"), rs.getString("anbefaling"), rs.getString("beskrivelse"));
                tempIntList.add(tempInteraction);
            }
            return tempIntList;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
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
    }*/

    // Nedenstående virker. Den sletter medikamenter fra patientens FMK (Vi kan dog ikke bestemme hvad den sletter. Den sletter altid det samme)
    public static void deleteDrugRow(String a) throws ClassNotFoundException, SQLException {
        Connection conn;
        String CPRnummer = dataStorage.chosenPatient.getCPRNumber();
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC",
                "hst_2019_19gr6404", "agipheethohwiquiteam");

        try {
            String SQL1 = ("DELETE FROM FMKdatabase WHERE CPR =" + CPRnummer + " " + "AND navn = " + "'" + a + "'" );
            Statement st = conn.createStatement();
            st.executeUpdate(SQL1);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
/*
    public static void addRow () {
        try {
            String url = "com.mysql.cj.jdbc.Driver";
            Connection conn = DriverManager.getConnection("jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC",
                    "hst_2019_19gr6404", "agipheethohwiquiteam");
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO FMKdatabase (CPR, navn, dosis, enhed, hyppighed, startdato, slutdato) VALUES ('3003965678', 50, 'mg', '3 gange dagligt', 2019-02-03, 2019-02-04)");

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }*/
//Nedestående metode virker som den skal
    public static void FMKDatabaseAddRow (String a, String b, String c, String d, String h, String f, String g) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC",
                "hst_2019_19gr6404", "agipheethohwiquiteam");
        String CPRnummer = dataStorage.chosenPatient.getCPRNumber(); // Henter nuværende patients CPR nummer og placerer det i en string til senere brug

        try {
            String SQL1 = ("INSERT INTO FMKdatabase (CPR, navn, dosis, enhed,  hyppighed, administrationsvej, startdato, slutdato) VALUE (" + CPRnummer + "," + "'" + a + "'" + "," + b + "," + "'" + c + "'" + "," + "'" + d + "'" + "," + "'"+ h + "'" + "," + "'" + f + "'" + "," + "'" + g + "'" + ")");   // laver et SQL kald med det hentede CPRnummer og så nogle forskellige strings som vi skriver i
            Statement st = conn.createStatement();
            st.executeUpdate(SQL1);   // Forbinder til vores URL.

        } catch (Exception e) {
            System.err.println("Problem i FMKDatabaseAddRow! ");
            System.err.println(e.getMessage());
        }
    }

    /*public static void FMKDatabaseAddRow (String a, String b, String c, String d, String e, String f, String g) {
        Statement st;           // Deklarer et statement til st.
        st = null;              // Fortæller, at ST = null ->
        ResultSet rs;           // Deklarer vores ResultSet til rs.
        rs = null;              // Fortæller, at ST = null ->
        Class.forName("com.mysql.cj.jdbc.Driver"); // Vores driver.
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl);
        String CPRnummer = dataStorage.chosenPatient.getCPRNumber();
        try {
            String SQL1 = ("INSERT INTO FMKdatabase (CPR, navn, dosis, enhed, administrationsvej, hyppighed, startdato, slutdato) VALUE (" + CPRnummer + "," + a + "," + b + "," + c + "," + d + "," + e + "," + f + "," + g + ")");   // Søger efter et CPR i patientdatabase, som stemmer overens med det indtastede
            connection.createStatement().executeUpdate(SQL1);   // Forbinder til vores URL.

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }*/

    /*
    MedicineCardModel(MGS+TB) loader alle medikamenter, som er sat til en patient med tilhoerende CPR nr. Når patienten er genkendt
    vil den danne en ny Observable, som skal gemmes i Datastorage. Fra datastorage vil listen blive 'kaldt' til tableview,
    og efterfølgende blive vist.
     */
    public static medicineCardModel getMedicineCard(String id) {
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl);
            PreparedStatement st = conn.prepareStatement("select * from FMKdatabase Where CPR = " + id); //
            ResultSet rs = st.executeQuery();
            ObservableList<prescriptedDrugModel> prescriptedDrugModelList = FXCollections.observableArrayList();
            while (rs.next()) {
                prescriptedDrugModel pm = new prescriptedDrugModel(rs.getString("navn"), "", rs.getString("administrationsvej"), rs.getInt("dosis"), rs.getString("hyppighed"), rs.getString("startdato"), rs.getString("slutdato"), rs.getString("enhed"));
                prescriptedDrugModelList.add(pm);
            }
            medicineCardModel m = new medicineCardModel(prescriptedDrugModelList);
            return m;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
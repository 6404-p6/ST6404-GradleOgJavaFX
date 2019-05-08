package ST6404;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //@Override
    public void start(Stage primaryStage) throws IOException {

        Parent choosePatientView = FXMLLoader.load(Main.class.getResource("/patientSelectorView.fxml"));
        primaryStage.setTitle("EPJ");
        primaryStage.setScene(new Scene(choosePatientView));
        primaryStage.show();

/*
        try {
            databaseConnectorController.loadPatientData();
        } catch (Exception e) {
            System.out.println("Something went wrong..." + e.getMessage());
        }*/
        // Skal bruges for at køre koden.
        /*try {
            databaseConnectorController.loadPatientData();
        } catch (Exception e) {
            System.out.println("Something went wrong..." + e.getMessage());
        }*/

    }

    public static void interaction(String[] args)
    {
        try
        {
            // create our mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT medikamentA, medikamentB, alvorlighedsgrad, dokumentationsgrad, anbefaling, beskrivelse FROM MIdatabase";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String medikamentA = rs.getString("medicamentA");
                String medikamentB = rs.getString("medicamentB");
                int alvorlighedsgrad = rs.getInt("alvorlighedsgrad");
                int dokumentationsgrad = rs.getInt("dokumentationsgrad");
                String anbefaling = rs.getString("anbefaling");
                String beskrivelse = rs.getString("beskrivelse");

                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s, %s\n", id, medikamentA, medikamentB, alvorlighedsgrad, dokumentationsgrad, anbefaling, beskrivelse);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}

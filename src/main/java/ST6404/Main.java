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



}

package ST6404;

import ST6404.medicineCardModel.*;
import ST6404.prescriptedDrugModel.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import ST6404.prescriptionController.*;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

        try {
            databaseConnectorController.databaseConnectorController();
        } catch (Exception e) {
            System.out.println("Something went wrong..." + e.getMessage());
        }

        try {
            databaseConnectorController.loadPatientData();
        } catch (Exception e) {
            System.out.println("Something went wrong..." + e.getMessage());
        }

        /*try {
            databaseConnectorController.loadMedicineList();
        } catch (Exception e) {
            System.out.println("Something went wrong..." + e.getMessage());
        }*/




    }
        //@Override
        public void start (Stage primaryStage) throws IOException {

            Parent choosePatientView = FXMLLoader.load(Main.class.getResource("/choosePatientView.fxml"));
            primaryStage.setTitle("EPJ");
            primaryStage.setScene(new Scene(choosePatientView));
            primaryStage.show();
        }
}

package ST6404;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    databaseConnectorController.

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent choosePatientView = FXMLLoader.load(Main.class.getResource("/choosePatientView.fxml"));
        primaryStage.setTitle("Medicinmodul");
        primaryStage.setScene(new Scene(choosePatientView));
        primaryStage.show();

        /*
<<<<<<< HEAD

            try {
                patientModel.patientModel.getPatientdatafromSQL();
            }catch(Exception e) {
                System.out.println("Something went wrong..." + e.getMessage());

            }

        }
        //test
=======
>>>>>>> master
*/
    }
}


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
    /*
    Der skiftes view ved at skabe en scene ud fra FXMLLoaderen der
    er sat til at loade et FXML dokument, her PatientSelectorView
    og samme tid instantierer den dertilhørende controller.
    Herefter "vises" scenen, så et vindue popper op.
     */
    @Override
    public void start (Stage primaryStage) throws IOException {
        Parent choosePatientView = FXMLLoader.load(Main.class.getResource("/PatientSelectorView.fxml"));
        primaryStage.setTitle("EPJ");
        primaryStage.setScene(new Scene(choosePatientView));
        primaryStage.show();
    }
}

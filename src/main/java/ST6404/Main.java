package ST6404;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        //
        Parent choosePatientViewScene = FXMLLoader.load(Main.class.getResource("/choosePatientView.fxml"));
        primaryStage.setScene(new Scene(choosePatientViewScene));
        primaryStage.show();

        //TimeUnit.SECONDS.sleep(3);
        Parent root2 = FXMLLoader.load(Main.class.getResource("/medicineListView.fxml"));
        primaryStage.setScene(new Scene(root2));
        primaryStage.show();

    }
}

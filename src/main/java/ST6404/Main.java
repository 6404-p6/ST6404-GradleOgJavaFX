package ST6404;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/TDsScenebuilderSample.fxml"));

        StackPane stackPane = (StackPane) fxmlLoader.load();
        // TD: Tror ikke denne er nødvendig, men lad den lige ligge for nu
        // testController test = (testController) fxmlLoader.getController();

        primaryStage.setScene(new Scene(stackPane));
        primaryStage.show();
    }
}

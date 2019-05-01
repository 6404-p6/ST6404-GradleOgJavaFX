package ST6404;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class medicineListController {

    @FXML
    public void changeSceneToMedicineList(ActionEvent event) throws IOException {
        // Forklaring følger, men den er her indtil videre: https://www.youtube.com/watch?v=XCgcQTQCfJQ
        Parent medicineListView = FXMLLoader.load(Main.class.getResource("/medicineListView.fxml"));
        Scene medicineListViewScene = new Scene(medicineListView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(medicineListViewScene);
        window.show();

/* Kunne ikke få det til at virke, men vent til efter søndag d. 5 med at slette dette udkommenteret
        Parent medicineListViewScene = FXMLLoader.load(Main.class.getResource("/medicineListView.fxml"));
        Main.primaryStage.setScene(new Scene(medicineListViewScene));
        Main.primaryStage.show();
*/
    }

    @FXML
    public void testSystemPrintMethod(ActionEvent event){
        System.out.println("Test");
    }

}

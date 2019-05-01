package ST6404;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class medicineListController {

    public void changeSceneToMedicineList(ActionEvent event) throws IOException {
        Parent medicineListView = FXMLLoader.load(Main.class.getResource("/ST6404/medicineListView.fxml"));
        Scene medicineListViewScene = new Scene(medicineListView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(medicineListViewScene);
        window.show();
    }

}

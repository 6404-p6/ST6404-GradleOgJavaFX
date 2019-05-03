package ST6404;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class choosePatientController {

    @FXML
    private TextField IDTextFieldInsertCPR;

    @FXML
    private void processTextFieldInsertCPR(ActionEvent event){
        String CPRoutputString = IDTextFieldInsertCPR.getText();
        System.out.println("CPR er: " + CPRoutputString + " og nu burde den søge på SQL. Koden er endnu ikke lavet");
    }

    /*
    Først skabes en parent-klasse kaldt "medicineListView". Parent-klassen
    håndterer operationer og organisering af layout i den bagvedliggende kode.
    Parent'en sættes til at loade i en FXMLLoader ud fra FXML filen, der er lavet
    i Scenebuilder. Herefter laves der en Scene af denne. Kun stages vises, så scenen
    laves til en stage, som får en titel og derefter sættes til at poppe up.
    TD: Video jeg fik det fra: https://www.youtube.com/watch?v=XCgcQTQCfJQ
     */
    @FXML
    public void changeSceneToMedicineListView(ActionEvent event) throws IOException {
        System.out.println("Troubleshoot: Begynder metode changeSceneToMedicineListView");
        Parent medicineListView = FXMLLoader.load(Main.class.getResource("/medicineListView.fxml"));
        Scene medicineListViewScene = new Scene(medicineListView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Medicinmodul");
        window.setScene(medicineListViewScene);
        window.show();
        System.out.println("Troubleshoot: Afslutter metode changeSceneToMedicineListView");
    }

}

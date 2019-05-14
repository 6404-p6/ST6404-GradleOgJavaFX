package ST6404;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class visualizationController implements Initializable {

    @FXML private TitledPane IDTitledPaneVisualization;

    @FXML public TextField IDtextfieldDrug2Bottom;
    @FXML public TextField IDtextfieldDrug3Bottom;
    @FXML public TextField IDtextfieldDrug4Bottom;
    @FXML public TextField IDtextfieldDrug5Bottom;
    @FXML public TextField IDtextfieldDrug6Bottom;
    @FXML public TextField IDtextfieldDrug7Bottom;
    @FXML public TextField IDtextfieldDrug8Bottom;
    @FXML public TextField IDtextfieldDrug9Bottom;
    @FXML public TextField IDtextfieldDrug10Bottom;
    @FXML public TextField IDtextfieldDrug11Bottom;
    @FXML public TextField IDtextfieldDrug12Bottom;
    @FXML public TextField IDtextfieldDrug13Bottom;
    @FXML public TextField IDtextfieldDrug14Bottom;
    @FXML public TextField IDtextfieldDrug15Bottom;
    @FXML public TextField IDtextfieldDrug16Bottom;

    @FXML public TextField IDtextfieldDrug1Right;
    @FXML public TextField IDtextfieldDrug2Right;
    @FXML public TextField IDtextfieldDrug3Right;
    @FXML public TextField IDtextfieldDrug4Right;
    @FXML public TextField IDtextfieldDrug5Right;
    @FXML public TextField IDtextfieldDrug6Right;
    @FXML public TextField IDtextfieldDrug7Right;
    @FXML public TextField IDtextfieldDrug8Right;
    @FXML public TextField IDtextfieldDrug9Right;
    @FXML public TextField IDtextfieldDrug10Right;
    @FXML public TextField IDtextfieldDrug11Right;
    @FXML public TextField IDtextfieldDrug12Right;
    @FXML public TextField IDtextfieldDrug13Right;
    @FXML public TextField IDtextfieldDrug14Right;
    @FXML public TextField IDtextfieldDrug15Right;

    // Se forklaring i patientSelector.changeSceneToMedicineListView
    @FXML
    public void changeSceneToMedicineListView(ActionEvent event) throws IOException {
        System.out.println("Troubleshoot: Begynder metode changeSceneToMedicineListView");
        Parent medicineListView = FXMLLoader.load(Main.class.getResource("/medicineCardView.fxml"));
        Scene medicineListViewScene = new Scene(medicineListView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Medicinmodul");
        window.setScene(medicineListViewScene);
        window.show();
        System.out.println("Troubleshoot: Afslutter metode changeSceneToMedicineListView");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialiser visualitionView");
        // Indhentning af dataStorage for at bruge dens patientModel
        dataStorage.getInstance();
        // Topbjælken får indsat navn og CPR fra metoden getPatientIdentification
        IDTitledPaneVisualization.setText(dataStorage.chosenPatient.getPatientIdentification());
    }

    //@Override
    //public void Visualization()


}

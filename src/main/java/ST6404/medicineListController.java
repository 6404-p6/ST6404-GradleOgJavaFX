package ST6404;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;


public class medicineListController implements Initializable {

    @FXML
    private TitledPane IDTitledPaneMedicineList;


    @FXML
    public void changeSceneToChoosePatientView(ActionEvent event) throws IOException {
        System.out.println("Troubleshoot: Begynder metode changeSceneToChoosePatientView");
        Parent choosePatientView = FXMLLoader.load(Main.class.getResource("/choosePatientView.fxml"));
        Scene choosePatientViewScene = new Scene(choosePatientView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("EPJ");
        window.setScene(choosePatientViewScene);
        window.show();
        System.out.println("Troubleshoot: Afslutter metode changeSceneToChoosePatientView");
    }

    @FXML
    public void changeSceneToCVisualizationView(ActionEvent event) throws IOException {
        System.out.println("Troubleshoot: Begynder metode changeSceneToCVisualizationView");
        Parent visualizationView = FXMLLoader.load(Main.class.getResource("/visualizationView.fxml"));
        Scene visualizationViewScene = new Scene(visualizationView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("FIO");
        window.setScene(visualizationViewScene);
        window.show();
        System.out.println("Troubleshoot: Afslutter metode changeSceneToCVisualizationView");
    }

    @FXML
    public void changeSceneToPrescriptionView(ActionEvent event) throws IOException {
        System.out.println("Troubleshoot: Begynder metode changeSceneToPrescriptionView");
        Parent prescriptionView = FXMLLoader.load(Main.class.getResource("/prescriptionView.fxml"));
        Scene prescriptionViewScene = new Scene(prescriptionView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Medicinmodul");
        window.setScene(prescriptionViewScene);
        window.show();
        System.out.println("Troubleshoot: Afslutter metode changeSceneToPrescriptionView");
    }

    @FXML
    public void testSystemPrintMethod(ActionEvent event){
        System.out.println("Test");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialiser medicineListView");
        patientModel chosenPatientV1 = new patientModel("Tobias", "Duncker", "3003965678");
        IDTitledPaneMedicineList.setText(chosenPatientV1.getPatientIdentification());
        //System.out.println(chosenPatientV2.getPatientIdentification());
    }
}

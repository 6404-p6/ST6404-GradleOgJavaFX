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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class visualizationController implements Initializable {


    @FXML public Text IDtextfieldDrug2Bottom;
    @FXML public Text IDtextfieldDrug3Bottom;
    @FXML public Text IDtextfieldDrug4Bottom;
    @FXML public Text IDtextfieldDrug5Bottom;
    @FXML public Text IDtextfieldDrug6Bottom;
    @FXML public Text IDtextfieldDrug7Bottom;
    @FXML public Text IDtextfieldDrug8Bottom;
    @FXML public Text IDtextfieldDrug9Bottom;
    @FXML public Text IDtextfieldDrug10Bottom;
    @FXML public Text IDtextfieldDrug11Bottom;
    @FXML public Text IDtextfieldDrug12Bottom;
    @FXML public Text IDtextfieldDrug13Bottom;
    @FXML public Text IDtextfieldDrug14Bottom;
    @FXML public Text IDtextfieldDrug15Bottom;
    @FXML public Text IDtextfieldDrug16Bottom;

    @FXML public Text IDtextfieldDrug1Right;
    @FXML public Text IDtextfieldDrug2Right;
    @FXML public Text IDtextfieldDrug3Right;
    @FXML public Text IDtextfieldDrug4Right;
    @FXML public Text IDtextfieldDrug5Right;
    @FXML public Text IDtextfieldDrug6Right;
    @FXML public Text IDtextfieldDrug7Right;
    @FXML public Text IDtextfieldDrug8Right;
    @FXML public Text IDtextfieldDrug9Right;
    @FXML public Text IDtextfieldDrug10Right;
    @FXML public Text IDtextfieldDrug11Right;
    @FXML public Text IDtextfieldDrug12Right;
    @FXML public Text IDtextfieldDrug13Right;
    @FXML public Text IDtextfieldDrug14Right;
    @FXML public Text IDtextfieldDrug15Right;

    @FXML
    private TitledPane IDTitledPaneVisualization;

    public static void AddMedicationName(){

    }

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
    //IDTextfieldDrug1Right
    /*

    private void inputMedicationNames(List medicineCard) {

        List bottomMedicationNames = null;
        String tempSQLDrugNames = "";

        for(int i = 0; i < medicineList.size(); i++ ){
            prescriptedDrugModel tempPrecriptedDrugModel = (prescriptedDRugModel) medicineCard.get(i);
            tempPrescripted
        }
    }
*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialiser visualitionView");
        // Indhentning af dataStorage for at bruge dens patientModel
        dataStorage.getInstance();
        // Instantiering af database
        databaseConnectorController db = new databaseConnectorController();
        // Topbjælken får indsat navn og CPR fra metoden getPatientIdentification
        IDTitledPaneVisualization.setText(dataStorage.chosenPatient.getPatientIdentification());
        // Instantiering og load af interaktionslisten
        interactionSummarizerModel iSM = new interactionSummarizerModel();
        iSM.setInteractionList(db.loadInteractionsList(dataStorage.chosenPatient.medicineCard.medicineList));
    }

}

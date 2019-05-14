package ST6404;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class prescriptionController implements Initializable {

    @FXML
    private TitledPane IDTitledPanePrescription;
    private TextField IDTextfieldNavn;
    private TextField IDTextfieldDosis;
    private TextField IDTextfieldEnhed;
    private TextField IDTextfieldHyppighed;
    private TextField IDTextfieldAdmVej;
    private TextField IDTextfieldStartdato;
    private TextField IDTextfieldSlutdato;
    private Text IDTextAntalInteraktioner;

    // Se forklaring i patientSelector.changeSceneToMedicineListView
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

    // Jeg prøver her at lave en metode som tager informationerne skrevet
    // Ind i prescriptionView og tilføje dem til databasen. dele af den skal skrives inde i databaseController

    public void processTextFieldPrescripeDrug(){
        String NavnTextFieldInput = IDTextfieldNavn.getText();
        String DosisTextFieldInput = IDTextfieldDosis.getText();
        String EnhedTextFieldInput = IDTextfieldEnhed.getText();
        String HyppighedTextFieldInput = IDTextfieldHyppighed.getText();
        String AdmVejTextFieldInput = IDTextfieldAdmVej.getText();
        String StartdatoTextFieldInput = IDTextfieldStartdato.getText();
        String SlutdatoTextFieldInput = IDTextfieldSlutdato.getText();



        /*try {
            databaseConnectorController db = new databaseConnectorController();
            db.FMKDatabaseAddRow(NavnTextFieldInput, DosisTextFieldInput, EnhedTextFieldInput, HyppighedTextFieldInput, AdmVejTextFieldInput, StartdatoTextFieldInput, SlutdatoTextFieldInput);
        }

        catch (Exception e) {
            System.out.println("Something went wrong..." + e.getMessage());
        }*/
    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialiser prescriptionView");
        // Indhentning af dataStorage for at bruge dens patientModel
        dataStorage.getInstance();
        // Topbjælken får indsat navn og CPR fra metoden getPatientIdentification
        IDTitledPanePrescription.setText(dataStorage.chosenPatient.getPatientIdentification());
        databaseConnectorController db = new databaseConnectorController();
    }
}

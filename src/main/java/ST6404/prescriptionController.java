package ST6404;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import static java.awt.Color.*;

public class prescriptionController implements Initializable {

    @FXML private TitledPane IDTitledPanePrescription;
    @FXML private TextField IDTextfieldNavn;
    @FXML private TextField IDTextfieldDosis;
    @FXML private TextField IDTextfieldEnhed;
    @FXML private TextField IDTextfieldHyppighed;
    @FXML private TextField IDTextfieldAdmVej;
    @FXML private TextField IDTextfieldStartdato;
    @FXML private TextField IDTextfieldSlutdato;
    @FXML private Text interactionNumber;
    @FXML private static Circle interactionCircle1;



    public void checkInteraction(ActionEvent event) {
        String NavnTextFieldInput = IDTextfieldNavn.getText();
        prescriptedDrugModel tempPrescriptedDrugModel = new prescriptedDrugModel(NavnTextFieldInput, "", "", 0, "", "", "", "");
        dataStorage.chosenPatient.medicineCard.medicineList.add(tempPrescriptedDrugModel);
        databaseConnectorController db = new databaseConnectorController();
        interactionSummarizerModel iSM = new interactionSummarizerModel();
        iSM.setInteractionList(db.loadInteractionsList(dataStorage.chosenPatient.medicineCard.medicineList));
        //Sætter antallet af interaktioner ind i cirklen ved siden af "Vis interaktioner"
        interactionNumber.setText(iSM.calculateNumberOfErrors());
        //Bestemmer farven af cirklen omkring antallet af interaktioner
        interactionCircle1.setFill(decideColourOfCircle1(iSM.getHighestSeverity()));
        //Sletter medikamentet fra listen igen
        dataStorage.chosenPatient.medicineCard.medicineList.remove(dataStorage.chosenPatient.medicineCard.medicineList.size() - 1);
    }

    public void setTextInCircle (String numberOfErrorsString){
        interactionNumber.setText(numberOfErrorsString);
    }

    public Color decideColourOfCircle1 (int highestSeverity){
        if(highestSeverity == 1){
            return Color.YELLOW;
        }
        else return Color.RED;
    }

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

    public void processTextFieldPrescripeDrug() throws IOException {
        String NavnTextFieldInput = IDTextfieldNavn.getText();
        String DosisTextFieldInput = IDTextfieldDosis.getText();
        String EnhedTextFieldInput = IDTextfieldEnhed.getText();
        String HyppighedTextFieldInput = IDTextfieldHyppighed.getText();
        String AdmVejTextFieldInput = IDTextfieldAdmVej.getText();
        String StartdatoTextFieldInput = IDTextfieldStartdato.getText();
        String SlutdatoTextFieldInput = IDTextfieldSlutdato.getText();

        System.out.println("vi når til del 1 ");

        try {
            databaseConnectorController db = new databaseConnectorController();
            db.FMKDatabaseAddRow(NavnTextFieldInput, DosisTextFieldInput, EnhedTextFieldInput, HyppighedTextFieldInput, AdmVejTextFieldInput, StartdatoTextFieldInput, SlutdatoTextFieldInput);
        System.out.println("Vi når til del 2");
        }

        catch (Exception e) {
            System.out.println("Something went wrong..." + e.getMessage());
        }
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

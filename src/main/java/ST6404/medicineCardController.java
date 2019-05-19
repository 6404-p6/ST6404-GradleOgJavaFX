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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class medicineCardController implements Initializable {

    @FXML
    private TitledPane IDTitledPaneMedicineList;

    // Opsætning af tabellen og dens enkelte kolonner.
    @FXML private TableView<prescriptedDrugModel> tableView;
    @FXML private TableColumn<prescriptedDrugModel, String> nameColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> dosageColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> unitColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> frequencyColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> administrationColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> startDateColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> endDateColumn;
    // Opsætning af indikatoren for interaktioner
    @FXML private Text interactionNumber;
    @FXML private Circle interactionCircle;

    /*
    Sletter et medikament ved hjælp af højreklik. Når man højreklikker selekteres objektet af det valgte medikament,
    og der sættes en alert popup for om man er sikker. Herefter sendes en SQL statement, hvis man vil slette.
    Tabellen og indikatoren opdateres lige efter sletning.
     */
    public void sletMedikament() {
        prescriptedDrugModel medikamentValgt = tableView.getSelectionModel().getSelectedItem();
        String CPRnummer = dataStorage.chosenPatient.getCPRNumber();
        if (medikamentValgt == null) {
            System.out.println("Intet medikament valgt");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sletter medikament");
        alert.setContentText("Er du sikker paa at du vil slette dette medikament?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            try {
                databaseConnectorController db = new databaseConnectorController();
                db.deleteDrugRow(medikamentValgt.getMedicationName());
                dataStorage.chosenPatient.medicineCard = db.loadMedicineCard(CPRnummer);
                tableView.setItems(dataStorage.chosenPatient.medicineCard.medicineList);
                interactionSummarizerModel iSM = new interactionSummarizerModel();
                iSM.calculateHighestSeverity();
                interactionCircle.setFill(decideColourOfCircle(iSM.getHighestSeverity()));
            }
            catch (Exception e){
                System.out.println("Something went wrong..." + e.getMessage());
            }
        }
        else {
            System.out.println("Sletteprocess annulleret");
        }
    }

    //Metoden farver cirklen rundt omkring antallet af interaktioner på baggrund af highestSeverity
    public Color decideColourOfCircle (int highestSeverity) {
        if (highestSeverity == 1) {
            return Color.LEMONCHIFFON;
        } else return Color.TOMATO;
    }

    // Se forklaring i patientSelector.changeSceneToMedicineListView
    @FXML
    public void changeSceneToChoosePatientView(ActionEvent event) throws IOException {
        System.out.println("Troubleshoot: Begynder metode changeSceneToChoosePatientView");
        dataStorage.chosenPatient = null;
        Parent choosePatientView = FXMLLoader.load(Main.class.getResource("/patientSelectorView.fxml"));
        Scene choosePatientViewScene = new Scene(choosePatientView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("EPJ");
        window.setScene(choosePatientViewScene);
        window.show();
        System.out.println("Troubleshoot: Afslutter metode changeSceneToChoosePatientView");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialiser medicineListView");
        // Indhentning af dataStorage for at bruge dens patientModel
        dataStorage.getInstance();
        // Instantiering af databasen, så dens metoder kan blive brugt.
        databaseConnectorController db = new databaseConnectorController();
        // Instantierer en interactionSummarizer for at bruge dens interaktionsliste. Den loader også en liste.
        interactionSummarizerModel iSM = new interactionSummarizerModel();
        iSM.setInteractionList(db.loadInteractionsList(dataStorage.chosenPatient.medicineCard.medicineList));
        //Sætter antallet af interaktioner ind i cirklen ved siden af "Vis interaktioner"
        interactionNumber.setText(iSM.calculateNumberOfErrors());
        //Bestemmer farven af cirklen omkring antallet af interaktioner
        iSM.calculateHighestSeverity();
        interactionCircle.setFill(decideColourOfCircle(iSM.getHighestSeverity()));
        // Topbjælken får indsat navn og CPR fra metoden getPatientIdentification
        IDTitledPaneMedicineList.setText(dataStorage.chosenPatient.getPatientIdentification());
        //Tabellens kolonner får deres værdi sat ved, at den søger i objektet efter en bestemt type, som har
        // et bestemt navn som identifier, f.eks. "medicationName". Herefter sætter den dem klar.
        nameColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("medicationName"));
        dosageColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("dosage"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("unit"));
        frequencyColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("frequency"));
        administrationColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("routeOfAdministration"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("endDate"));
        // Tabellen "refreshes" og loader alle kolonnerne.
        tableView.setItems(dataStorage.chosenPatient.medicineCard.medicineList);
    }
}
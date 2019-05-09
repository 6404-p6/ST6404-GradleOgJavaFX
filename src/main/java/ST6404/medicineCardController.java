package ST6404;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ResourceBundle;

public class medicineCardController implements Initializable {

    private List availableMedicineList;


    @FXML
    private TitledPane IDTitledPaneMedicineList;

    @FXML private TableView<prescriptedDrugModel> tableView;
    @FXML private TableColumn<prescriptedDrugModel, String> nameColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> dosageColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> unitColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> frequencyColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> administrationColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> startDateColumn;
    @FXML private TableColumn<prescriptedDrugModel, String> endDateColumn;



    @FXML
    public void changeSceneToChoosePatientView(ActionEvent event) throws IOException {
        System.out.println("Troubleshoot: Begynder metode changeSceneToChoosePatientView");
        Parent choosePatientView = FXMLLoader.load(Main.class.getResource("/patientSelectorView.fxml"));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialiser medicineListView");

        databaseConnectorController.interactionList();
        //databaseConnectorController.deleteRow();
        patientModel chosenPatient = patientModel.getInstance();
        IDTitledPaneMedicineList.setText(chosenPatient.getPatientIdentification());
        //chosenPatient.medicineCard.medicineList.add(new prescriptedDrugModel("Dicoumarol", 20, "mg", "1 dagligt", "01-07-2019", "01-01-2020", "OR", "ABC562"));

        //System.out.print(chosenPatient.medicineCard.medicineList.size());
        nameColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("medicationName"));
        dosageColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("dosage"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("unit"));
        frequencyColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("frequency"));
        administrationColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("administrationRoute"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("endDate"));
        tableView.setItems(prescriptedDrugModel.getprescriptedDrugModelList());
    }

}
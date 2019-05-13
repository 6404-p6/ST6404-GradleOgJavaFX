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
import javafx.scene.control.TablePosition;
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
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class medicineCardController implements Initializable {

    private List availableMedicineList;

    /*public void updateData() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC", "hst_2019_19gr6404", "agipheethohwiquiteam");
            Statement con = connection.createStatement();
            //connection
            TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            TableColumn col = pos.getTableColumn();
            String data1 = (String) col.getCellObservableValue(row).getValue();
            //cell
            medicineCardModel row1 = tableView.getSelectionModel().getSelectedItem();
            c1 = row1.getID();
            //row
            //tableview variables
            con.execute("UPDATE FMKdatabase SET navn = disedase, dosis = 5 WHERE CPR = 3003965678");
            //Query
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }*/

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
        dataStorage.chosenPatient = null;
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
        dataStorage.getInstance();
        // Topbjælken får indsat navn og CPR fra metoden getPatientIdentification
        IDTitledPaneMedicineList.setText(dataStorage.chosenPatient.getPatientIdentification());

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
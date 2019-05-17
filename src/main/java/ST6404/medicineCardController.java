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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.text.Text;

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
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class medicineCardController implements Initializable {

    @FXML private TextField IDTextfieldMedikament;

    private List availableMedicineList;

    public void deleteDrugButton() {
        try {
            String MedikamentTextFieldInput = IDTextfieldMedikament.getText();
            try {
                databaseConnectorController db = new databaseConnectorController();
                db.deleteDrugRow(MedikamentTextFieldInput);
                System.out.println("Vi når til del 2");
            }

            catch (Exception e) {
                System.out.println("Something went wrong..." + e.getMessage());
            }

            Class.forName("com.mysql.jdbc.Driver");
            // establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Studentinformation", "root", "");
            Statement statement = con.createStatement();
            statement.executeUpdate("DELETE FROM FMKdatabase WHERE roll=" + nameColumn.getText() + "");
            JOptionPane.showMessageDialog(null, "Drug deleted...");
            statement.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

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
    @FXML private Text interactionNumber;
    @FXML private Circle interactionCircle;

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
        databaseConnectorController db = new databaseConnectorController();
        // Indhentning af dataStorage for at bruge dens patientModel
        dataStorage.getInstance();
        // Instantierer en interactionsummarizerModel og ligger den i dataStorage for globalt brug
        //List tempInteractionList = (db.loadInteractionsList(dataStorage.chosenPatient.medicineCard.medicineList));
        //dataStorage.iSM.setInteractionList(tempInteractionList);
        interactionSummarizerModel iSM = new interactionSummarizerModel();
        iSM.setInteractionList(db.loadInteractionsList(dataStorage.chosenPatient.medicineCard.medicineList));
        //Sætter antallet af interaktioner ind i cirklen ved siden af "Vis interaktioner"
        interactionNumber.setText(iSM.calculateNumberOfErrors());
        //Bestemmer farven af cirklen omkring antallet af interaktioner
        interactionCircle.setFill(decideColourOfCircle(iSM.getHighestSeverity()));
        // Topbjælken får indsat navn og CPR fra metoden getPatientIdentification
        IDTitledPaneMedicineList.setText(dataStorage.chosenPatient.getPatientIdentification());

        nameColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("medicationName"));
        dosageColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("dosage"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("unit"));
        frequencyColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("frequency"));
        administrationColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("routeOfAdministration"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<prescriptedDrugModel, String>("endDate"));
        tableView.setItems(dataStorage.chosenPatient.medicineCard.medicineList);

        /*try {
            tableView.setItems(databaseConnectorController.getMedicineCard());
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*try {
            tableView.setItems(databaseConnectorController.getMedicineCard());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
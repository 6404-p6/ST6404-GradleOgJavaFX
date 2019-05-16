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
import javafx.scene.text.*;
import javafx.application.Application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    //@FXML public Circle IDCircle0x0y;

    @FXML
    private TitledPane IDTitledPaneVisualization;

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

    private void inputMedicationNames(List medicineCard) {

        // Starter med at skabe en list, hvor alle ID'erne for teksterne for højre ide af visualiseringen indsættes.
        List<Text> tempIDTextRightList = new ArrayList<Text>();
        tempIDTextRightList.add(IDtextfieldDrug1Right);
        tempIDTextRightList.add(IDtextfieldDrug2Right);
        tempIDTextRightList.add(IDtextfieldDrug3Right);
        tempIDTextRightList.add(IDtextfieldDrug4Right);
        tempIDTextRightList.add(IDtextfieldDrug5Right);
        tempIDTextRightList.add(IDtextfieldDrug6Right);
        tempIDTextRightList.add(IDtextfieldDrug7Right);
        tempIDTextRightList.add(IDtextfieldDrug8Right);
        tempIDTextRightList.add(IDtextfieldDrug9Right);
        tempIDTextRightList.add(IDtextfieldDrug10Right);
        tempIDTextRightList.add(IDtextfieldDrug11Right);
        tempIDTextRightList.add(IDtextfieldDrug12Right);
        tempIDTextRightList.add(IDtextfieldDrug13Right);
        tempIDTextRightList.add(IDtextfieldDrug14Right);
        tempIDTextRightList.add(IDtextfieldDrug15Right);
        /*
        Der skabes en for-løkke, som går fra 0 til størrelsen af listen minus 1. Minus 1 er på grund af
        hvordan et heatmap opsættes. For bunden er det nødvendigt at gå fra 1 til størrelsen af listen.
        I første linje inde i for-løkken, skabes en midlertidig instans for den i'ende række af medikament listen, som blev modtaget
        som input. Herefter ændres teksten for i'ende ID(f.eks. IDTextfieldDrug1 på 0 index plads, IDTextfieldDRug2 på 1 index plads,osv)
        ved at indsætte den returnerede værdi af getMedicationName af den midlertidige instans fra det ene element på listen af medikamenter.
         */
        for(int i = 0; i < medicineCard.size()-1; i++ ) {
            prescriptedDrugModel tempPrescriptedDrugModelForRightDrugNames = (prescriptedDrugModel) medicineCard.get(i);
            tempIDTextRightList.get(i).setText(tempPrescriptedDrugModelForRightDrugNames.getMedicationName());
        }
        // Samme process
        List<Text> tempIDTextBottomList = new ArrayList<Text>();
        tempIDTextBottomList.add(IDtextfieldDrug2Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug3Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug4Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug5Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug6Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug7Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug8Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug9Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug10Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug11Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug12Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug13Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug14Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug15Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug16Bottom);
        // Samme process, men med anderledes iterationstart og slut.
            for(int i = 1; i < medicineCard.size()-1; i++ ){
                prescriptedDrugModel tempPrescriptedDrugModelForBottomDrugNames = (prescriptedDrugModel) medicineCard.get(i);
                tempIDTextBottomList.get(i-1).setText(tempPrescriptedDrugModelForBottomDrugNames.getMedicationName());
        }
    }
// In progress
    public void visualizeInteractionList(List interactionList){
        // Instanticering af hjælpelister for iterationsproces
        List<Text> tempIDTextRightList = new ArrayList<Text>();
        tempIDTextRightList.add(IDtextfieldDrug1Right);
        tempIDTextRightList.add(IDtextfieldDrug2Right);
        tempIDTextRightList.add(IDtextfieldDrug3Right);
        tempIDTextRightList.add(IDtextfieldDrug4Right);
        tempIDTextRightList.add(IDtextfieldDrug5Right);
        tempIDTextRightList.add(IDtextfieldDrug6Right);
        tempIDTextRightList.add(IDtextfieldDrug7Right);
        tempIDTextRightList.add(IDtextfieldDrug8Right);
        tempIDTextRightList.add(IDtextfieldDrug9Right);
        tempIDTextRightList.add(IDtextfieldDrug10Right);
        tempIDTextRightList.add(IDtextfieldDrug11Right);
        tempIDTextRightList.add(IDtextfieldDrug12Right);
        tempIDTextRightList.add(IDtextfieldDrug13Right);
        tempIDTextRightList.add(IDtextfieldDrug14Right);
        tempIDTextRightList.add(IDtextfieldDrug15Right);

        List<Text> tempIDTextBottomList = new ArrayList<Text>();
        tempIDTextBottomList.add(IDtextfieldDrug2Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug3Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug4Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug5Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug6Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug7Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug8Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug9Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug10Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug11Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug12Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug13Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug14Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug15Bottom);
        tempIDTextBottomList.add(IDtextfieldDrug16Bottom);

        //List<Circle> tempListForFirstCircleRow = new ArrayList<Circle>();
        //tempListForFirstCircleRow.add(IDCircle0x0y);

    }


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
        // Indsættelse af navne omkring heatmap
        inputMedicationNames(dataStorage.chosenPatient.medicineCard.medicineList);
    }

}

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

    // Første række
    @FXML public Circle IDCircle0x0y;
    @FXML public Circle IDCircle1x0y;
    @FXML public Circle IDCircle2x0y;
    @FXML public Circle IDCircle3x0y;
    @FXML public Circle IDCircle4x0y;
    @FXML public Circle IDCircle5x0y;
    @FXML public Circle IDCircle6x0y;
    @FXML public Circle IDCircle7x0y;
    @FXML public Circle IDCircle8x0y;
    @FXML public Circle IDCircle9x0y;
    @FXML public Circle IDCircle10x0y;
    @FXML public Circle IDCircle11x0y;
    @FXML public Circle IDCircle12x0y;
    @FXML public Circle IDCircle13x0y;
    @FXML public Circle IDCircle14x0y;
    // Anden række
    @FXML public Circle IDCircle1x1y;
    @FXML public Circle IDCircle2x1y;
    @FXML public Circle IDCircle3x1y;
    @FXML public Circle IDCircle4x1y;
    @FXML public Circle IDCircle5x1y;
    @FXML public Circle IDCircle6x1y;
    @FXML public Circle IDCircle7x1y;
    @FXML public Circle IDCircle8x1y;
    @FXML public Circle IDCircle9x1y;
    @FXML public Circle IDCircle10x1y;
    @FXML public Circle IDCircle11x1y;
    @FXML public Circle IDCircle12x1y;
    @FXML public Circle IDCircle13x1y;
    @FXML public Circle IDCircle14x1y;
    // Tredje række
    @FXML public Circle IDCircle2x2y;
    @FXML public Circle IDCircle3x2y;
    @FXML public Circle IDCircle4x2y;
    @FXML public Circle IDCircle5x2y;
    @FXML public Circle IDCircle6x2y;
    @FXML public Circle IDCircle7x2y;
    @FXML public Circle IDCircle8x2y;
    @FXML public Circle IDCircle9x2y;
    @FXML public Circle IDCircle10x2y;
    @FXML public Circle IDCircle11x2y;
    @FXML public Circle IDCircle12x2y;
    @FXML public Circle IDCircle13x2y;
    @FXML public Circle IDCircle14x2y;
    // Fjerde række
    @FXML public Circle IDCircle3x3y;
    @FXML public Circle IDCircle4x3y;
    @FXML public Circle IDCircle5x3y;
    @FXML public Circle IDCircle6x3y;
    @FXML public Circle IDCircle7x3y;
    @FXML public Circle IDCircle8x3y;
    @FXML public Circle IDCircle9x3y;
    @FXML public Circle IDCircle10x3y;
    @FXML public Circle IDCircle11x3y;
    @FXML public Circle IDCircle12x3y;
    @FXML public Circle IDCircle13x3y;
    @FXML public Circle IDCircle14x3y;
    // Femte række
    @FXML public Circle IDCircle4x4y;
    @FXML public Circle IDCircle5x4y;
    @FXML public Circle IDCircle6x4y;
    @FXML public Circle IDCircle7x4y;
    @FXML public Circle IDCircle8x4y;
    @FXML public Circle IDCircle9x4y;
    @FXML public Circle IDCircle10x4y;
    @FXML public Circle IDCircle11x4y;
    @FXML public Circle IDCircle12x4y;
    @FXML public Circle IDCircle13x4y;
    @FXML public Circle IDCircle14x4y;
    // Sjette række
    @FXML public Circle IDCircle5x5y;
    @FXML public Circle IDCircle6x5y;
    @FXML public Circle IDCircle7x5y;
    @FXML public Circle IDCircle8x5y;
    @FXML public Circle IDCircle9x5y;
    @FXML public Circle IDCircle10x5y;
    @FXML public Circle IDCircle11x5y;
    @FXML public Circle IDCircle12x5y;
    @FXML public Circle IDCircle13x5y;
    @FXML public Circle IDCircle14x5y;
    // Syvende række
    @FXML public Circle IDCircle6x6y;
    @FXML public Circle IDCircle7x6y;
    @FXML public Circle IDCircle8x6y;
    @FXML public Circle IDCircle9x6y;
    @FXML public Circle IDCircle10x6y;
    @FXML public Circle IDCircle11x6y;
    @FXML public Circle IDCircle12x6y;
    @FXML public Circle IDCircle13x6y;
    @FXML public Circle IDCircle14x6y;
    // Ottende række
    @FXML public Circle IDCircle7x7y;
    @FXML public Circle IDCircle8x7y;
    @FXML public Circle IDCircle9x7y;
    @FXML public Circle IDCircle10x7y;
    @FXML public Circle IDCircle11x7y;
    @FXML public Circle IDCircle12x7y;
    @FXML public Circle IDCircle13x7y;
    @FXML public Circle IDCircle14x7y;
    // Niende række
    @FXML public Circle IDCircle8x8y;
    @FXML public Circle IDCircle9x8y;
    @FXML public Circle IDCircle10x8y;
    @FXML public Circle IDCircle11x8y;
    @FXML public Circle IDCircle12x8y;
    @FXML public Circle IDCircle13x8y;
    @FXML public Circle IDCircle14x8y;
    // Tiende række
    @FXML public Circle IDCircle9x9y;
    @FXML public Circle IDCircle10x9y;
    @FXML public Circle IDCircle11x9y;
    @FXML public Circle IDCircle12x9y;
    @FXML public Circle IDCircle13x9y;
    @FXML public Circle IDCircle14x9y;
    // Ellevte række
    @FXML public Circle IDCircle10x10y;
    @FXML public Circle IDCircle11x10y;
    @FXML public Circle IDCircle12x10y;
    @FXML public Circle IDCircle13x10y;
    @FXML public Circle IDCircle14x10y;
    // Tolvte række
    @FXML public Circle IDCircle11x11y;
    @FXML public Circle IDCircle12x11y;
    @FXML public Circle IDCircle13x11y;
    @FXML public Circle IDCircle14x11y;
    // Trediende(?) række
    @FXML public Circle IDCircle12x12y;
    @FXML public Circle IDCircle13x12y;
    @FXML public Circle IDCircle14x12y;
    // Fjortende række
    @FXML public Circle IDCircle13x13y;
    @FXML public Circle IDCircle14x13y;
    // Femtende række
    @FXML public Circle IDCircle14x14y;

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
            for(int i = 1; i < medicineCard.size(); i++ ){
                prescriptedDrugModel tempPrescriptedDrugModelForBottomDrugNames = (prescriptedDrugModel) medicineCard.get(i);
                tempIDTextBottomList.get(i-1).setText(tempPrescriptedDrugModelForBottomDrugNames.getMedicationName());
        }
    }
    // In progress
    public void visualizeInteractionList(List interactionList){
        // Instanticering af hjælpelister for iterationsproces, en for bunden og en for siden
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

        // Tilføjer cirklerne til en liste
        List<Circle> tempListForFirstCircleRow = new ArrayList<Circle>();
        // Første række
        tempListForFirstCircleRow.add(IDCircle0x0y);
        tempListForFirstCircleRow.add(IDCircle1x0y);
        tempListForFirstCircleRow.add(IDCircle2x0y);
        tempListForFirstCircleRow.add(IDCircle3x0y);
        tempListForFirstCircleRow.add(IDCircle4x0y);
        tempListForFirstCircleRow.add(IDCircle5x0y);
        tempListForFirstCircleRow.add(IDCircle6x0y);
        tempListForFirstCircleRow.add(IDCircle7x0y);
        tempListForFirstCircleRow.add(IDCircle8x0y);
        tempListForFirstCircleRow.add(IDCircle9x0y);
        tempListForFirstCircleRow.add(IDCircle10x0y);
        tempListForFirstCircleRow.add(IDCircle11x0y);
        tempListForFirstCircleRow.add(IDCircle12x0y);
        tempListForFirstCircleRow.add(IDCircle13x0y);
        tempListForFirstCircleRow.add(IDCircle14x0y);
        // Anden række
        tempListForFirstCircleRow.add(IDCircle1x1y);
        tempListForFirstCircleRow.add(IDCircle2x1y);
        tempListForFirstCircleRow.add(IDCircle3x1y);
        tempListForFirstCircleRow.add(IDCircle4x1y);
        tempListForFirstCircleRow.add(IDCircle5x1y);
        tempListForFirstCircleRow.add(IDCircle6x1y);
        tempListForFirstCircleRow.add(IDCircle7x1y);
        tempListForFirstCircleRow.add(IDCircle8x1y);
        tempListForFirstCircleRow.add(IDCircle9x1y);
        tempListForFirstCircleRow.add(IDCircle10x1y);
        tempListForFirstCircleRow.add(IDCircle11x1y);
        tempListForFirstCircleRow.add(IDCircle12x1y);
        tempListForFirstCircleRow.add(IDCircle13x1y);
        tempListForFirstCircleRow.add(IDCircle14x1y);
        // Tredje række
        tempListForFirstCircleRow.add(IDCircle2x2y);
        tempListForFirstCircleRow.add(IDCircle3x2y);
        tempListForFirstCircleRow.add(IDCircle4x2y);
        tempListForFirstCircleRow.add(IDCircle5x2y);
        tempListForFirstCircleRow.add(IDCircle6x2y);
        tempListForFirstCircleRow.add(IDCircle7x2y);
        tempListForFirstCircleRow.add(IDCircle8x2y);
        tempListForFirstCircleRow.add(IDCircle9x2y);
        tempListForFirstCircleRow.add(IDCircle10x2y);
        tempListForFirstCircleRow.add(IDCircle11x2y);
        tempListForFirstCircleRow.add(IDCircle12x2y);
        tempListForFirstCircleRow.add(IDCircle13x2y);
        tempListForFirstCircleRow.add(IDCircle14x2y);
        // Fjerde række
        tempListForFirstCircleRow.add(IDCircle3x3y);
        tempListForFirstCircleRow.add(IDCircle4x3y);
        tempListForFirstCircleRow.add(IDCircle5x3y);
        tempListForFirstCircleRow.add(IDCircle6x3y);
        tempListForFirstCircleRow.add(IDCircle7x3y);
        tempListForFirstCircleRow.add(IDCircle8x3y);
        tempListForFirstCircleRow.add(IDCircle9x3y);
        tempListForFirstCircleRow.add(IDCircle10x3y);
        tempListForFirstCircleRow.add(IDCircle11x3y);
        tempListForFirstCircleRow.add(IDCircle12x3y);
        tempListForFirstCircleRow.add(IDCircle13x3y);
        tempListForFirstCircleRow.add(IDCircle14x3y);
        // Femte række
        tempListForFirstCircleRow.add(IDCircle4x4y);
        tempListForFirstCircleRow.add(IDCircle5x4y);
        tempListForFirstCircleRow.add(IDCircle6x4y);
        tempListForFirstCircleRow.add(IDCircle7x4y);
        tempListForFirstCircleRow.add(IDCircle8x4y);
        tempListForFirstCircleRow.add(IDCircle9x4y);
        tempListForFirstCircleRow.add(IDCircle10x4y);
        tempListForFirstCircleRow.add(IDCircle11x4y);
        tempListForFirstCircleRow.add(IDCircle12x4y);
        tempListForFirstCircleRow.add(IDCircle13x4y);
        tempListForFirstCircleRow.add(IDCircle14x4y);
        // Sjette række
        tempListForFirstCircleRow.add(IDCircle5x5y);
        tempListForFirstCircleRow.add(IDCircle6x5y);
        tempListForFirstCircleRow.add(IDCircle7x5y);
        tempListForFirstCircleRow.add(IDCircle8x5y);
        tempListForFirstCircleRow.add(IDCircle9x5y);
        tempListForFirstCircleRow.add(IDCircle10x5y);
        tempListForFirstCircleRow.add(IDCircle11x5y);
        tempListForFirstCircleRow.add(IDCircle12x5y);
        tempListForFirstCircleRow.add(IDCircle13x5y);
        tempListForFirstCircleRow.add(IDCircle14x5y);
        // Syvende
        tempListForFirstCircleRow.add(IDCircle6x6y);
        tempListForFirstCircleRow.add(IDCircle7x6y);
        tempListForFirstCircleRow.add(IDCircle8x6y);
        tempListForFirstCircleRow.add(IDCircle9x6y);
        tempListForFirstCircleRow.add(IDCircle10x6y);
        tempListForFirstCircleRow.add(IDCircle11x6y);
        tempListForFirstCircleRow.add(IDCircle12x6y);
        tempListForFirstCircleRow.add(IDCircle13x6y);
        tempListForFirstCircleRow.add(IDCircle14x6y);
        // Ottende
        tempListForFirstCircleRow.add(IDCircle7x7y);
        tempListForFirstCircleRow.add(IDCircle8x7y);
        tempListForFirstCircleRow.add(IDCircle9x7y);
        tempListForFirstCircleRow.add(IDCircle10x7y);
        tempListForFirstCircleRow.add(IDCircle11x7y);
        tempListForFirstCircleRow.add(IDCircle12x7y);
        tempListForFirstCircleRow.add(IDCircle13x7y);
        tempListForFirstCircleRow.add(IDCircle14x7y);
        // Niende
        tempListForFirstCircleRow.add(IDCircle8x8y);
        tempListForFirstCircleRow.add(IDCircle9x8y);
        tempListForFirstCircleRow.add(IDCircle10x8y);
        tempListForFirstCircleRow.add(IDCircle11x8y);
        tempListForFirstCircleRow.add(IDCircle12x8y);
        tempListForFirstCircleRow.add(IDCircle13x8y);
        tempListForFirstCircleRow.add(IDCircle14x8y);
        // Tiende
        tempListForFirstCircleRow.add(IDCircle9x9y);
        tempListForFirstCircleRow.add(IDCircle10x9y);
        tempListForFirstCircleRow.add(IDCircle11x9y);
        tempListForFirstCircleRow.add(IDCircle12x9y);
        tempListForFirstCircleRow.add(IDCircle13x9y);
        tempListForFirstCircleRow.add(IDCircle14x9y);
        // Ellevte
        tempListForFirstCircleRow.add(IDCircle10x10y);
        tempListForFirstCircleRow.add(IDCircle11x10y);
        tempListForFirstCircleRow.add(IDCircle12x10y);
        tempListForFirstCircleRow.add(IDCircle13x10y);
        tempListForFirstCircleRow.add(IDCircle14x10y);
        // Tolvte
        tempListForFirstCircleRow.add(IDCircle11x11y);
        tempListForFirstCircleRow.add(IDCircle12x11y);
        tempListForFirstCircleRow.add(IDCircle13x11y);
        tempListForFirstCircleRow.add(IDCircle14x11y);
        // Trediende(?)
        tempListForFirstCircleRow.add(IDCircle12x12y);
        tempListForFirstCircleRow.add(IDCircle13x12y);
        tempListForFirstCircleRow.add(IDCircle14x12y);
        // Fjortende
        tempListForFirstCircleRow.add(IDCircle13x13y);
        tempListForFirstCircleRow.add(IDCircle14x13y);
        // Femtende
        tempListForFirstCircleRow.add(IDCircle14x14y);
/*
Et for-loop gennemgår navnene i højre side og starter fra 0, den nederste, og bevæger sig opad, inden den når
størrelsen af medicineList, så den ikke går længere end nødvendigt.
 */

for(int k = 0; k < dataStorage.chosenPatient.medicineCard.medicineList.size()-1; k++){
    Text tempTextRight = (Text) tempIDTextRightList.get(k);

    /*
    Et for-loop gennemgår navnene i bunden, bevægende fra højre mod venstre og går til medicineList size, så
    den ikke går længere end nødvendigt. Der er trukket 1 fra, fordi at et sådan heatmap's navne i bunden vil starte
    fra index plads 1 og ikke index plads 0. Der er trukket k fra, for at kompensere for indhakket efter hver
    bevægelse opad.
     */
        for(int i = 0; i < dataStorage.chosenPatient.medicineCard.medicineList.size()-1-k; i++ ) {
            Text tempTextBottom = (Text) tempIDTextBottomList.get(i+k);

            /*
            Et for-loop gennemgår interactionslisten og sammenligner med navnene i siden og bunden for om de
            stemmer overens med dem i interaktionslistens medikamentA og medikamentB for alle indeks. Hvis de stemmer
            overens, ændres den pågældende cirkel.
             */
            for(int j = 0; j < interactionList.size(); j++ ) {
                medicineInteractionModel tempInteraction = (medicineInteractionModel) interactionList.get(j);
                if (tempTextRight.getText().equals(tempInteraction.getMedicamentA()) && tempTextBottom.getText().equals(tempInteraction.getMedicamentB()) //|| tempTextRight.getText() == tempInteraction.getMedicamentB() && tempTextBottom.getText() == tempInteraction.getMedicamentA()
                ) {
                    Circle circleToChange = (Circle) tempListForFirstCircleRow.get(i+(15*k-k));
                    circleToChange.setFill(Color.BLUE);
                    break;
                }

            }
        }
    }

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
        // Visning af cirkler med interagerende medikament navne
        visualizeInteractionList(iSM.getInteractionList());
    }

}

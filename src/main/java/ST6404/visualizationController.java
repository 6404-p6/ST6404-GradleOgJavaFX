package ST6404;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class visualizationController implements Initializable {

    // De to 'counters' i toppen af venstre splitPane
    @FXML public Text IDCriticalCounter;
    @FXML public Text IDPotentiallyProblematicCounter;

    // tekstfelterne i højre splitPane
    @FXML public TextField IDTextfieldInteractingDrugs;
    @FXML public TextArea IDTextfieldRecommendation;
    @FXML public TextArea IDTextfieldDescription;

    // Alle teksterne i bunden af heatmap'ets gridPane
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

    // Alle teksterne i VBox'en til højre for heatmap'ets gridPane
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

    //      Alle cirkler i gridPane skal også have en attribut.
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
    // Trettende række
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

    // Tæller de to typer alvorlighedsgrad i en interaktionslist og sætter dem i 'counteren' i toppen af venstre side
    private void showTypesAndNumberOfErrors(List interactionList){
        int countPotentiallyProblematic = 0;
        int countCritical = 0;
        for(int i = 0; i < interactionList.size(); i++ ) {
            medicineInteractionModel tempInteraction = (medicineInteractionModel) interactionList.get(i);
            if (tempInteraction.getSeverity() == 2){
                countCritical = countCritical + 1;
            } else {countPotentiallyProblematic = countPotentiallyProblematic + 1;}
            IDPotentiallyProblematicCounter.setText(Integer.toString(countPotentiallyProblematic));
            IDCriticalCounter.setText(Integer.toString(countCritical));
        }
    }

    /*
    Denne metode bliver kørt i changeScene for medicinlisten, da medikamenter som er blevet tilføjet for at tjekke
    indikatoren, ikke skal bruges i medicinlisten. Den fjerner alle medikamenter, som er blevet 'tagged' som
    eksempler. Metoden går også fra size til 0, da tilføjede medikamenter sættes på den højeste indeks plads.
    */
    private void deleteTemporaryDrugs(){
        for(int i = dataStorage.chosenPatient.medicineCard.medicineList.size()-1; i > 0; i-- ){
            prescriptedDrugModel tempDrugToDelete = (prescriptedDrugModel) dataStorage.chosenPatient.medicineCard.medicineList.get(i);
            if (tempDrugToDelete.isExampleForVisualization()){
                dataStorage.chosenPatient.medicineCard.medicineList.remove(i);
            } else {break;}
        }
    }

    // Se forklaring i patientSelector.changeSceneToMedicineListView
    @FXML
    public void changeSceneToMedicineListView(ActionEvent event) throws IOException {
        System.out.println("Troubleshoot: Begynder metode changeSceneToMedicineListView");
        deleteTemporaryDrugs();
        Parent medicineListView = FXMLLoader.load(Main.class.getResource("/medicineCardView.fxml"));
        Scene medicineListViewScene = new Scene(medicineListView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Medicinmodul");
        window.setScene(medicineListViewScene);
        window.show();
        System.out.println("Troubleshoot: Afslutter metode changeSceneToMedicineListView");
    }

    /* Indsætter navnene i teksterne i siden og bunden afhængigt af medicinlistens indhold. I højre side placeres første
    medikament, men ikke sidste. I bunden tilføjes første medikament IKKE, men det sidste tilføjes. Dette er grundet
    strukturen af heatmap og for at undgå redundans
    Først indsættes navnene i en liste, og derefter gennemgår en for-løkke listen af navne og medicinlisten.
     */
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

    /*
    Metoden visualiserer med 4 lister og 3 for-loops. De fire lister er navnene til højre, navnene i bunden, cirklerne
    og interaktionslisten. Første for-loop er for navnene nedefra og opad, højre for-loop er for højre og til venstre.
    Tredje for-loop er for gennemgang at interaktionslisten. Herefter beregnes koordinatetet af cirklerne, hvis der
    findes en interaktion og cirklerne vises. Hele metoden indeholder kommentering step-by-step for bedre gennemgang.
     */
    private void visualizeInteractionList(List interactionList){
        // Instanticering af hjælpelister for iterationsproces, en for navnene i bunden og en for navnene i siden
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

        /* Cirklerne tilføjes til en liste, så de kan gennemgås. Dermed add'er cirklerne i alle rækker,
        startende med nederste række og fra højre mod venstre.
         */
        List<Circle> tempListForCircles = new ArrayList<Circle>();
        // Første række
        tempListForCircles.add(IDCircle0x0y);
        tempListForCircles.add(IDCircle1x0y);
        tempListForCircles.add(IDCircle2x0y);
        tempListForCircles.add(IDCircle3x0y);
        tempListForCircles.add(IDCircle4x0y);
        tempListForCircles.add(IDCircle5x0y);
        tempListForCircles.add(IDCircle6x0y);
        tempListForCircles.add(IDCircle7x0y);
        tempListForCircles.add(IDCircle8x0y);
        tempListForCircles.add(IDCircle9x0y);
        tempListForCircles.add(IDCircle10x0y);
        tempListForCircles.add(IDCircle11x0y);
        tempListForCircles.add(IDCircle12x0y);
        tempListForCircles.add(IDCircle13x0y);
        tempListForCircles.add(IDCircle14x0y);
        // Anden række
        tempListForCircles.add(IDCircle1x1y);
        tempListForCircles.add(IDCircle2x1y);
        tempListForCircles.add(IDCircle3x1y);
        tempListForCircles.add(IDCircle4x1y);
        tempListForCircles.add(IDCircle5x1y);
        tempListForCircles.add(IDCircle6x1y);
        tempListForCircles.add(IDCircle7x1y);
        tempListForCircles.add(IDCircle8x1y);
        tempListForCircles.add(IDCircle9x1y);
        tempListForCircles.add(IDCircle10x1y);
        tempListForCircles.add(IDCircle11x1y);
        tempListForCircles.add(IDCircle12x1y);
        tempListForCircles.add(IDCircle13x1y);
        tempListForCircles.add(IDCircle14x1y);
        // Tredje række
        tempListForCircles.add(IDCircle2x2y);
        tempListForCircles.add(IDCircle3x2y);
        tempListForCircles.add(IDCircle4x2y);
        tempListForCircles.add(IDCircle5x2y);
        tempListForCircles.add(IDCircle6x2y);
        tempListForCircles.add(IDCircle7x2y);
        tempListForCircles.add(IDCircle8x2y);
        tempListForCircles.add(IDCircle9x2y);
        tempListForCircles.add(IDCircle10x2y);
        tempListForCircles.add(IDCircle11x2y);
        tempListForCircles.add(IDCircle12x2y);
        tempListForCircles.add(IDCircle13x2y);
        tempListForCircles.add(IDCircle14x2y);
        // Fjerde række
        tempListForCircles.add(IDCircle3x3y);
        tempListForCircles.add(IDCircle4x3y);
        tempListForCircles.add(IDCircle5x3y);
        tempListForCircles.add(IDCircle6x3y);
        tempListForCircles.add(IDCircle7x3y);
        tempListForCircles.add(IDCircle8x3y);
        tempListForCircles.add(IDCircle9x3y);
        tempListForCircles.add(IDCircle10x3y);
        tempListForCircles.add(IDCircle11x3y);
        tempListForCircles.add(IDCircle12x3y);
        tempListForCircles.add(IDCircle13x3y);
        tempListForCircles.add(IDCircle14x3y);
        // Femte række
        tempListForCircles.add(IDCircle4x4y);
        tempListForCircles.add(IDCircle5x4y);
        tempListForCircles.add(IDCircle6x4y);
        tempListForCircles.add(IDCircle7x4y);
        tempListForCircles.add(IDCircle8x4y);
        tempListForCircles.add(IDCircle9x4y);
        tempListForCircles.add(IDCircle10x4y);
        tempListForCircles.add(IDCircle11x4y);
        tempListForCircles.add(IDCircle12x4y);
        tempListForCircles.add(IDCircle13x4y);
        tempListForCircles.add(IDCircle14x4y);
        // Sjette række
        tempListForCircles.add(IDCircle5x5y);
        tempListForCircles.add(IDCircle6x5y);
        tempListForCircles.add(IDCircle7x5y);
        tempListForCircles.add(IDCircle8x5y);
        tempListForCircles.add(IDCircle9x5y);
        tempListForCircles.add(IDCircle10x5y);
        tempListForCircles.add(IDCircle11x5y);
        tempListForCircles.add(IDCircle12x5y);
        tempListForCircles.add(IDCircle13x5y);
        tempListForCircles.add(IDCircle14x5y);
        // Syvende
        tempListForCircles.add(IDCircle6x6y);
        tempListForCircles.add(IDCircle7x6y);
        tempListForCircles.add(IDCircle8x6y);
        tempListForCircles.add(IDCircle9x6y);
        tempListForCircles.add(IDCircle10x6y);
        tempListForCircles.add(IDCircle11x6y);
        tempListForCircles.add(IDCircle12x6y);
        tempListForCircles.add(IDCircle13x6y);
        tempListForCircles.add(IDCircle14x6y);
        // Ottende
        tempListForCircles.add(IDCircle7x7y);
        tempListForCircles.add(IDCircle8x7y);
        tempListForCircles.add(IDCircle9x7y);
        tempListForCircles.add(IDCircle10x7y);
        tempListForCircles.add(IDCircle11x7y);
        tempListForCircles.add(IDCircle12x7y);
        tempListForCircles.add(IDCircle13x7y);
        tempListForCircles.add(IDCircle14x7y);
        // Niende
        tempListForCircles.add(IDCircle8x8y);
        tempListForCircles.add(IDCircle9x8y);
        tempListForCircles.add(IDCircle10x8y);
        tempListForCircles.add(IDCircle11x8y);
        tempListForCircles.add(IDCircle12x8y);
        tempListForCircles.add(IDCircle13x8y);
        tempListForCircles.add(IDCircle14x8y);
        // Tiende
        tempListForCircles.add(IDCircle9x9y);
        tempListForCircles.add(IDCircle10x9y);
        tempListForCircles.add(IDCircle11x9y);
        tempListForCircles.add(IDCircle12x9y);
        tempListForCircles.add(IDCircle13x9y);
        tempListForCircles.add(IDCircle14x9y);
        // Ellevte
        tempListForCircles.add(IDCircle10x10y);
        tempListForCircles.add(IDCircle11x10y);
        tempListForCircles.add(IDCircle12x10y);
        tempListForCircles.add(IDCircle13x10y);
        tempListForCircles.add(IDCircle14x10y);
        // Tolvte
        tempListForCircles.add(IDCircle11x11y);
        tempListForCircles.add(IDCircle12x11y);
        tempListForCircles.add(IDCircle13x11y);
        tempListForCircles.add(IDCircle14x11y);
        // Trediende(?)
        tempListForCircles.add(IDCircle12x12y);
        tempListForCircles.add(IDCircle13x12y);
        tempListForCircles.add(IDCircle14x12y);
        // Fjortende
        tempListForCircles.add(IDCircle13x13y);
        tempListForCircles.add(IDCircle14x13y);
        // Femtende
        tempListForCircles.add(IDCircle14x14y);
/*
Et for-loop gennemgår navnene i højre side og starter emd det nederste medikamentnavn, og bevæger sig opad, inden den når
størrelsen af medicineList minus 1, så den ikke går længere end nødvendigt. Højre side går indeholder kun navne fra
første medikament til det andet sidste. Dette er for ikke at skabe redundans i et heatmap system.
 */

for(int k = 0; k < dataStorage.chosenPatient.medicineCard.medicineList.size()-1; k++){
    Text tempTextRight = (Text) tempIDTextRightList.get(k);

    /*
    Et for-loop gennemgår navnene i bunden og starter med det mest til højre. Den starter fra medikament 2 på medicinlisten
    for ikke at skabe redundans i et heatmap system. Dermed indeholder denne række det sidste medikament, som navnene til
    højre mangler.
     */
        for(int i = 0; i < dataStorage.chosenPatient.medicineCard.medicineList.size()-1; i++ ) {
            Text tempTextBottom = (Text) tempIDTextBottomList.get(i);
            /*
            Et for-loop undersøger navnene der er valgt i de to forrige for-loops og sammenligner den med både medikamentA
            og medikamentB i en midlertidig medicineInteractionModel. Den midlertidige medicineInteractionModel starter
            som det første i interactionList. Hvis navnene stemmer overens, synliggøres cirklen på det pågældende koordinat.
            Hvis de ikke stemmer overens, undersøges næste medicineInteractionModel i interactionList.
                         */
            for(int j = 0; j < interactionList.size(); j++ ) {
                medicineInteractionModel tempInteraction = (medicineInteractionModel) interactionList.get(j);
                if (tempTextRight.getText().equals(tempInteraction.getMedicamentA()) && tempTextBottom.getText().equals(tempInteraction.getMedicamentB()) || tempTextRight.getText().equals(tempInteraction.getMedicamentB()) && tempTextBottom.getText().equals(tempInteraction.getMedicamentA()))
                {
                    /* For at undgå forkerte cirkler hvis i første omgang medikamentA og medikamentB passer med bunden
                    og højre tekst, og i anden omgang passer i omvendt rækkefølge senere (pga. || funktionen da det er irrelevant
                    om det er medikamentA eller B der er først), så slettes interactionModel'en fra listen. Dette gør
                    samtidig koden hurtigere, da den skal look igennem et færre for hver gang den finder en.*/
                    interactionList.remove(j);
                    /* Pga. den matematiske rækkefølge i hvordan cirklerne er indsat i listen for cirkler, og den
                    strukturelle forskel fra et heatmap og et kvadrat, så skal der kompenseres for at der på hver række
                    kommer til at være færre cirkler. F.eks. på række 0 er der 15 cirkler, men i række 1 er der 14.
                    pascal-faktoren jeg har tilføjet adderer alle forrige mindskelser af cirkler. Dvs. Hvis man er i
                    række 4, så tilføjes 1+2+3+4 til koordinat-beregningen af hvilken cirkel skal ændres. */
                    int pascalCompensation = ((k)*((k)+1))/(2);
                    Circle circleToChange = (Circle) tempListForCircles.get(i+(15*k-pascalCompensation));
                    circleToChange.setOpacity(0.5);
                    circleToChange.setRadius(3.5*tempInteraction.getDocumentationLevel());
                    if (tempInteraction.getSeverity() == 2)
                    {   circleToChange.setFill(Color.RED);
                    } else {circleToChange.setFill(Color.YELLOW);}

                    /* Her tilføjes en tekst af hvilke medikamenter der interagerer i denne cirkel, så det senere i
                    et onClick ActionEvent. */
                    circleToChange.setAccessibleText(tempTextBottom.getText() + "-" + tempTextRight.getText());
                    break;
                }

            }
        }
    }

}

    /*
    Metoden trækker "AccessibleText" ud fra hvad end objekt der trykkes på, og ligger det i en string, som splittes op.
    På forhånd er AccessibleText to medikamentnavne med et "-" imellem, så der splittes op derfra. Dette gør, at brugeren
    kan trykke på en cirkel og metoden kan køre igennem et for-loop af interaktionslisten, vælge det korrekte
    medikament og indsætte dets beskrivelse samt anbefaling i højre side af visualiseringsvinduet.
     */
    public void showDetailedInformationAboutInteraction(MouseEvent event) {
        String tempAccessibleText = event.getPickResult().getIntersectedNode().getAccessibleText();
        String[] tempInteractionArray = tempAccessibleText.split("-");
        String firstDrug = tempInteractionArray[0];
        String secondDrug = tempInteractionArray[1];

        interactionSummarizerModel iSM = new interactionSummarizerModel();
        databaseConnectorController db = new databaseConnectorController();
        iSM.setInteractionList(db.loadInteractionsList(dataStorage.chosenPatient.medicineCard.medicineList));
        for(int i = 0; i < iSM.getInteractionList().size(); i++ ) {
            medicineInteractionModel tempInteraction = (medicineInteractionModel) (iSM.getInteractionList()).get(i);
            if (firstDrug.equals(tempInteraction.getMedicamentA()) && secondDrug.equals(tempInteraction.getMedicamentB()) || firstDrug.equals(tempInteraction.getMedicamentB()) && secondDrug.equals(tempInteraction.getMedicamentA())) {
                IDTextfieldInteractingDrugs.setText(tempInteraction.getMedicamentA() + " og " + tempInteraction.getMedicamentB());
                IDTextfieldRecommendation.setText(tempInteraction.getRecommendationText());
                IDTextfieldDescription.setText(tempInteraction.getDescriptionOfEffect());
                break;
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
        // Udfyldning af de numeriske indikatorer for hver alvorlighedsgrad i toppen
        showTypesAndNumberOfErrors(db.loadInteractionsList(dataStorage.chosenPatient.medicineCard.medicineList));
    }

}

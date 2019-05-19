package ST6404;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class patientSelectorController {

    @FXML
    private TextField IDTextFieldInsertCPR;

    /*
    Håndterer indtastningen af CPR ved at lave en getText på attributten for
    feltet. Efter at konvertere TextField typen til string, sættes
    det ind i metoden loadPatientData der returnerer et patientModel-objekt
    og lægger det ind i dataStorage klassens chosenPatient. Denne
    kan så tages videre til andre klasser
     */
    @FXML
    private void processTextFieldInsertCPR(){
        String CPRTextFieldInput = IDTextFieldInsertCPR.getText();
        try {
            databaseConnectorController db = new databaseConnectorController();
            dataStorage.getInstance();
            dataStorage.chosenPatient = db.loadPatientData(CPRTextFieldInput);
            dataStorage.chosenPatient.medicineCard = db.loadMedicineCard(dataStorage.chosenPatient.getCPRNumber());
        } catch (Exception e) {
            System.out.println("Something went wrong..." + e.getMessage());
    }
}

    /*
    Først skabes en parent-klasse kaldt "medicineListView". Parent-klassen
    håndterer operationer og organisering af layout i den bagvedliggende kode.
    Parent'en sættes til at loade i en FXMLLoader ud fra FXML filen, der er lavet
    i Scenebuilder. Hvis der findes en instans af controlleren af det pågældende FXML-
    fil, som valgt ud fra fx:id i Scenebuilder, bruger FXMLLoaderen denne controller instans.
    Findes ingen, skaber den en ny controller instans. Efter der er styr på instansen for
    controlleren, leder den efter om Controller klassen har en initializeable interface og
    kalder derefter på public void initialize metoden i klassen og kører den(https://stackoverflow.com/questions/19265954/how-does-fxmlloader-load-the-fxmls-controller).
    Herefter laves der en Scene af denne. Kun stages vises, så scenen
    laves til en stage, som får en titel og derefter sættes til at poppe up.
    TD: Video jeg fik det fra: https://www.youtube.com/watch?v=XCgcQTQCfJQ
     */
    @FXML
    public void changeSceneToMedicineListView(ActionEvent event) throws IOException {
        System.out.println("Troubleshoot: Begynder metode changeSceneToMedicineListView");
        processTextFieldInsertCPR();
        // Hvis der ikke blev instantieret en patient, så stoppes metoden og man
        // forbliver i view'et pga. return.
        if (dataStorage.chosenPatient.getCPRNumber() == null) {
            // TD: Virker ikke, men ved ikke lige helt hvorfor. Som om den
            // smider en invocationException
            //IDTextFieldInsertCPR.setText("Forkert CPR");
             return;
        }
        Parent medicineListView = FXMLLoader.load(Main.class.getResource("/medicineCardView.fxml"));
        Scene medicineListViewScene = new Scene(medicineListView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Medicinmodul");
        window.setScene(medicineListViewScene);
        window.show();
        System.out.println("Troubleshoot: Afslutter metode changeSceneToMedicineListView");
    }
}

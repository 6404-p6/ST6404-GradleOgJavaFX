import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;
import sun.tools.jar.Main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginController {

	private MainController mainController;
	UserModel userModel = new UserModel();

    private static Stage primaryStage;
    private static AnchorPane loginView;
    private static AnchorPane registerView;

    @FXML
	private TextField user_name;
	@FXML
	private PasswordField user_pass;
    @FXML
    private TextField register_name;
    @FXML
    private PasswordField register_password;
    @FXML
    private Button LoginButton = new Button();

    /**
     * Med metoden initialize() sættes knappen loginButton til at være den markerede knap, således der kan
     * trykkes på enter, når det ønkses at logge ind efter navn og kode er indskrevet.
     */
    public void initialize(){
        LoginButton.setDefaultButton(true);
	}

    /**
     * Med metoden goToLogin() sættes primaryStage til at være lig variablen primarayStage i klassen mainController.
     * Dette gøres for at ændre primaryStage til nu at være LoginView.
     * Herefter instantieres loader fra klassen FXMLLoader. SetLocation bruges til at fortælle,
     * hvilket view, der ønskes benyttet. Variablen loginView sættes til at være lig med dette view,
     * som er et AnchorPane. Der instanseres nu en Scene, som skal være loginView, hvorefter dette view vises.
     * Hvis lokationen til viewet ikke kan findes, smides der en IOException, hvor der bruges
     * printStackTrace, således det er muligt at se, hvad fejlen er, og hvor i koden fejlen opstår.
     */
    void goToLogin(Stage primaryStage) {
        this.primaryStage = mainController.primaryStage;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class
                    .getResource("/LoginView.fxml"));
            loginView = (AnchorPane) loader.load();
            Scene scene = new Scene(loginView);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Med metoden goToRegister() sættes primaryStage til at være lig med variablen primarayStage i klassen
     * mainController. Dette gøres for at ændre primaryStage til nu at være RegisterView. Herefter instantieres
     * loader fra klassen FXMLLoader. Dernæst benyttes setLocation til at fortælle, hvilket view, der ønskes benyttet.
     * Variablen registerView sættes til at være lig dette view, som er et AnchorPane.
     * Der instantieres nu en Scene, som skal være registerView, hvorefter dette view vises.
     * Hvis lokationen til viewet ikke kan findes, smides der en IOException, hvor der bruges
     * printStackTrace, således det er muligt at se, hvad fejlen er, og hvor i koden fejlen opstår.
     */

    private void goToRegister(Stage primaryStage) {
        this.primaryStage = mainController.primaryStage;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("/RegisterView.fxml"));
            registerView = (AnchorPane) loader.load();
            Scene scene = new Scene(registerView);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoden handleLogin() benytter variablerne user_name og user_pass, som er et Textfield og PasswordField,
     * Der benyttes getText på disse to fields, som findes i LoginView. Variablerne gemmes i login_username
     * og login_pass. Herefter gives de som inputparametre til metoden validateID.
     */
	private void handleLogin() {
        String login_username = user_name.getText();
        String login_pass = user_pass.getText();
        validateID(login_username, login_pass);
    }

    /**
     * Metoden handleLoginButton() kaldes, når der trykkes på knappen login i LoginView. Denne metode kalder metoden
     * handleLogin().
     */
    @FXML
	private void handleLoginButton () {
        handleLogin();
	}

    /**
     * Meotden handleGoToRegister() kaldes, når der trykkes på knappen register i LoginView. Denne metode kalder
     * metoden goToRegsiter, og da der skal skiftes til en ny stage, sættes primaryStage som inputparameter.
     */
    @FXML
	private void handleGoToRegister (){
        goToRegister(primaryStage);
    }

    /**
     * Metoden handleCancelButton() kaldes, når der trykkes på knappen Cancel i RegisterView. Denne metode kalder
     * metoden goToLogin, og da der skal skiftes til en ny stage, sættes primaryStage som inputparameter.
     */
    @FXML
    private void handleCancelButton() {
        goToLogin(primaryStage);
    }

    /**
     * Metoden validateID() har to inputparametre, som er login_userID og login_password. Disse to parametre sættes
     * som inputs til metoden validateID, som kaldes fra klassen UserModel.
     */
	private void validateID(String login_userID, String login_password){
        userModel.validateID(login_userID,login_password);
    }

    /**
     * Metoden handleRegister() benytter variablerne register_password og register_name, som er variabler fra
     * RegisterView. På disse variabler benyttes getText, således teksten ,der skrives på disse felter, gemmes i
     * variablerne register_pass og register_firstname.
     * Efter dette laves et if-else statement, hvor det testes om register_firstname eller register_pass er lig
     * ingenting. Hvis dette er sandt, instantieres en ny Alert af typen INORMATION. Her sættes teksten til at
     * være "Mangler at indtaste navn og/eller kodeord" og metoden showAndWait() benyttes. Det betyder, at der skal
     * trykkes OK, før den gå videre. I else benyttes metoderne setUser_pass og setUser_firstname fra klassen UserModel
     * til at sætte variablerne User_pass og User_firstname i UserModel til at være lig det, der er blevet skrevet i
     * felterne i RegisterView. Herefter kaldes metoden UpdateModel fra klassen UserModel. Dernæs kaldes mmetoden
     * goToLogin() med input parameteren primaryStage, da viewet skifter fra RegisterView til LoginView.
     */
    @FXML
    private void handleRegister() {
        String register_pass = register_password.getText();
        String register_firstname = register_name.getText();
        if ((register_firstname.equals("")) || (register_pass.equals(""))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Mangler at indtaste navn og/eller kodeord");
            alert.showAndWait();
        }else {
            userModel.setUser_pass(register_pass);
            userModel.setUser_firstname(register_firstname);
            userModel.updateModel();
            goToLogin(primaryStage);
        }
    }
}

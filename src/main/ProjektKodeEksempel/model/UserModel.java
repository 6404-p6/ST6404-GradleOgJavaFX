import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class UserModel {
    private static String user_id;
    private static String user_pass;
    private static String user_firstname;

    /**
     * Sætter attributten user_id af typen String til input argumentet user_id.
     */
     public void setUser_id(String user_id) {
        UserModel.user_id = user_id;
    }

    /**
     * Sætter attributten user_pass af typen String til input argumentet user_pass.
     */
    public void setUser_pass(String user_pass) {
        UserModel.user_pass = user_pass;
    }

    /**
     * Sætter attributten user_firstname af typen String til input argumentet user_firstname.
     */
    public void setUser_firstname(String user_firstname) {
        UserModel.user_firstname = user_firstname;
    }

    /**
     * Returnerer attributten user_id af typen String.
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Returnerer attributten user_pass af typen String.
     */
    public String getUser_pass() {
        return user_pass;
    }

    /**
     * Returnerer attributten user_firstname af typen String.
     */
    public String getUser_firstname() {
        return user_firstname;
    }

    /**
     * her kaldes metoden updateModel() i klassen DatabaseController med input argumenterne db_user_pass,
     * db_user_firstname. Den har til formål at opdatere data i databasen med data fra denne model.
     */
    public void updateModel() {
        String db_user_pass = getUser_pass();
        String db_user_firstname = getUser_firstname();
        DatabaseController.updateModel(db_user_pass, db_user_firstname);
    }

    /**
     * Her kaldes metoden loadUserModel() i klassen DatabaseController, som har til formål at udfylde denne model
     * med data fra databasen.
     */
    public void loadModel() {
        String db_user_id = getUser_id();
        DatabaseController.loadUserModel(db_user_id);
    }

    /**
     * Denne metode tjekker, om en bruger findes i databasen med det indtastede brugernavn og kodeord.
     * Der oprettes et SQL statement, hvor der spørges efter user_name og user_password. Hvis det returnede data
     * fra databasen matcher det user_name og user_password, som brugeren har indskrevet, ændres viewet til
     * hovedmenuen. Hvis det returnede data ikke mathcer det user_name og user_password, som brugeren har indskrevet,
     * oprettes en pop-up besked som informerer brugeren om, at er er indtastes forkerte loginoplysninger.
     */
    public void validateID(String user_name, String user_password) {
        Statement st = null;
        ResultSet rs = null;
        String sql_login_username;
        String sql_login_pass;
        try {
            String SQL = ("SELECT * FROM healthcoordinator WHERE user_id = '" + user_name + "' AND user_pass = '" + user_password + "'");
            DatabaseController.connect().createStatement().executeQuery(SQL);
            st = DatabaseController.connect().createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {

                sql_login_username = rs.getString(1);
                sql_login_pass = rs.getString(2);
                if (sql_login_username.equals(user_name) && sql_login_pass.equals(user_password)) {

                    System.out.println("Login success");
                    setUser_id(user_name);
                    loadModel();
                    new MainController().goToMain();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Forkert brugernavn eller kode");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Forkert brugernavn eller kode");
                alert.showAndWait();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


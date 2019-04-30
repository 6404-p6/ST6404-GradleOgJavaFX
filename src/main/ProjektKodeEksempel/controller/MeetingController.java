import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class MeetingController implements Initializable {
    private static Stage primaryStage;
    private MeetingModel meetingModel = new MeetingModel();
    private UserModel userModel = new UserModel();
    private ObservableList<String> meetingList = FXCollections.observableArrayList();
    private ObservableList<String> arranged_meetingList = FXCollections.observableArrayList();

    @FXML
    public ChoiceBox<String> elevList;
    public DatePicker selectMeetingTime;
    public ListView potentialMeeting;

    /**
     * Metoden handleShowMeetings() starter med at kalde loadModel() fra klassen MeetingModel. Herefter defineres
     * fire ArrayLists. Ved studentList sættes data ind fra MeetingModel med metoden getParticipatingStudent_id.
     * Dette gøres også ved de andre ArrayLists med getMeetingTime, getParticipatingCoordinator og getMeetingLocation.
     * Herefter benyttes en for løkke, som kører igennem for antallet af elever, der ønsker et møde.
     * I for løkken er der en if løkke, hvor den er sand, hvis user_id ikke er lig 0, hvilket betyder, at der er
     * tildelt en sundhedskoordinator. Hvis dette er sandt, benyttes add til arranged_meetingList, som tilføjer eleven
     * med student_id, mødetidspunktet meeting_time og lokationen meeting_location.
     */
    private void handleShowMeetings() {
        meetingModel.loadModel();
        ArrayList<String> studentList = meetingModel.getParticipatingStudent_id();
        ArrayList<Date> meeting_time = meetingModel.getMeetingTime();
        ArrayList<String> user_id = meetingModel.getParticipatingCoordinator();
        ArrayList<String> meeting_location = meetingModel.getMeetingLocation();

        for (int i = 0; i < studentList.size(); i++) {
            if (user_id.get(i) != "0") {
                arranged_meetingList.add("ElevID: "+studentList.get(i)+"    møde dato: "+ meeting_time.get(i)+ "    lokation: "+meeting_location.get(i));

            }
        }
    }

    /**
     * I metoden handleSelectMeetingTimeButton() defineres en variable, der kaldes date af typen LocalDate,
     * som er lig selectMeetingTime.getValue. Denne læser den værdi, der valgt i Datepickeren i MeetingView.
     * Denne værdi returneres.
     */
   private LocalDate handleSelectMeetingTimeButton() {
        LocalDate date = selectMeetingTime.getValue();
        return date;
   }

    /**
     * Metoden handlePotentialMeeting() starter med at kalde loadModel() fra klassen MeetingModel. Herefter defineres
     * to ArrayLists. Ved studentList sættes data ind fra MeetingModel med metoden getParticipatingStudent_id.
     * Dette gøres også ved den anden ArrayList med getParticipatingCoordinator.
     * Herefter benyttes en for løkke, som kører igennem for antallet af elever, der ønsker et møde. I for løkken er
     * der en if løkke, hvor den er sand, hvis user_id er lig med 0, hvilket betyder, at der ikke er tildelt
     * en sundhedskoordinator. Hvis dette er sandt, benyttes add til meetingList.
     */
    private void handlePotentialMeeting() {
        meetingModel.loadModel();
        ArrayList<String> studentList = meetingModel.getParticipatingStudent_id();
        ArrayList<String> user_id = meetingModel.getParticipatingCoordinator();
        for (int i = 0; i < studentList.size(); i++) {
            if (user_id.get(i).equals("0")){
                meetingList.removeAll(meetingList);
                meetingList.addAll(studentList.get(i));
                elevList.getItems().addAll(meetingList);
            }
        }
    }

    /**
     * Denne metode har til formål at udfylde tabellen med arrangerede møder og dropdown menuen med forslået møder.
     * Først udfyldes potentialMeeting med de elementer, som findes i listen arranged_meetingList.
     * Derefter kaldes handleShowMeetings() og handlePotentialMeeting().
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            potentialMeeting.setItems(arranged_meetingList);
            handleShowMeetings();
            handlePotentialMeeting();
    }

    /**
     * Denne metode har til formål at ændret viewet til hovedmenuen ved at kalde mainklassens medetode
     * goToMain(), hvis der trykkes på tilbage knappen.
     */
    @FXML
    private void handleReturn(){
         new MainController().goToMain();
    }

    /**
     * Denne metode har til formål at tjekke, hvilken elev, der er valgt, og hvornår et møde ønskes.
     * Første gennemgåes listen af elver, der har et møde eller ønsker et møde, og det holdes sammen med den elev,
     * der er valgt i dropdownmenuen. Dernæst tjekkes det, om der er valgt en elev, og om der er valgt et tidspunkt.
     * Hvis det er tilfældet, opdateres meetingModel med metoden updateModel(). Dernæst oprettes en pop-up besked
     * med de valgte informationer, og det vises for brugeren. Alternativt vises en besked for brugeren
     * med informationer om, at der skal vælges en dato og elev.
     */
    @FXML
    private void handleRecommendMeetingButton(){
        for (int i=0; i < meetingModel.getParticipatingStudent_id().size(); i++) {
            if (meetingModel.getParticipatingStudent_id().get(i).equals(elevList.getValue())){

                if ((elevList.getValue()!= null) && (selectMeetingTime.getValue() != null)) {
                    String student_id = elevList.getValue();
                    LocalDate date = handleSelectMeetingTimeButton();
                    String user_id = userModel.getUser_id();
                    String meeting_location = meetingModel.getMeetingLocation().get(i);
                    meetingModel.updateModel(student_id,user_id,date);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Der er arrangeret møde med elev: " +student_id+ " denne dato: "+date+ " dette sted: "+meeting_location);
                    alert.show();
                    new MainController().goToMain();
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Du har ikke valgt elev og/eller dato");
                    alert.show();

                }
            }
        }
    }
}


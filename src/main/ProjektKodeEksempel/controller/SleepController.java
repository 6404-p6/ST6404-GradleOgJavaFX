import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;


import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class SleepController implements Initializable {

    ObservableList<String> list = FXCollections.observableArrayList();
    private SleepModel sleepModel = new SleepModel();
    private StudentListModel studentListModel = new StudentListModel();
    @FXML
    private DatePicker startDatePicker;

    @FXML
    private LineChart PreviousSleep;
    @FXML
    private CategoryAxis x;
    @FXML

    private NumberAxis y;

    @FXML
    private Button displayValueBtn;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private ChoiceBox<String> listChooseStudent;


    /**
     * Denne metode har til formål at give mulighed for at bruge datePicker start og end samt listen over elever.
     */
    @FXML
    private void handleIndData() {
        startDatePicker.setDisable(false);
        endDatePicker.setDisable(false);
        listChooseStudent.setDisable(false);
        displayValueBtn.setDisable(false);
    }

    /**
     * Denne metode har til formål give mulighed for at bruge datePicker start og end samt listen over elever.
     * Grafen udfyldes via linechart() med det data, der findes i sleepModel.
     */
    @FXML
    private void handlePopData() {
        startDatePicker.setDisable(false);
        endDatePicker.setDisable(false);
        displayValueBtn.setDisable(false);
        sleepModel.loadModel(null);
        ArrayList<String> sleep_time = sleepModel.getSleep_time();
        ArrayList<String> sleep_awoke = sleepModel.getAwoke_time();
        LineChart(sleep_time, sleep_awoke);
    }

    /**
     * Denne metode ændrer viewet til hovedmenuen ved at kalde mainklassens medetode goToMain(),
     * hvis der trykkes på tilbage knappen.
     */
    @FXML
    private void handlePrevReturnButton() {
        new MainController().goToMain();
    }

    /**
     * Denne metode udfylder listen med elever, der har givet samtykke.
     * Først udfyldes modellen studentListModel og tilføjer dem til dropdown-menuen.
     */
    private void listChooseStudent() {
        list.removeAll(list);
        studentListModel.loadModel();
        ArrayList<String> studentList = StudentListModel.studentList_id;
        list.addAll(studentList);
        listChooseStudent.getItems().addAll(list);
    }

    /**
     * Denne metode giver data til grafen for en enkelt elev svarende til individdata.
     * Først hentes den valgte elev med getValue(), og hvis der er valgt en elev, en startdato og slutdato,
     * hentes data for den elev. Det data, som er opvågningstidspunkter og sovetider tilføjes til grafen.
     */
    @FXML
    private void handlePrevOKButton() {
        String elev = listChooseStudent.getValue();

        if ((elev != null) && (String.valueOf(startDatePicker) != null) && (String.valueOf(endDatePicker) != null)) {
            sleepModel.loadModel(elev);
            ArrayList<String> sleep_time = sleepModel.getSleep_time();
            ArrayList<String> sleep_awoke = sleepModel.getAwoke_time();
            LineChart(sleep_time, sleep_awoke);
        }
    }

    /**
     * Denne metode udfylder listen med elever og deaktiverer startDatePicker, endDatePicker, listChooseStudent
     * og displayValueBtn. Dernæst udfyldes listen med elever med metoden listChooseStudent().
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listChooseStudent();
        startDatePicker.setDisable(true);
        endDatePicker.setDisable(true);
        listChooseStudent.setDisable(true);
        displayValueBtn.setDisable(true);
    }

    /**
     * Denne metode opretter en graf med data angivet ved argumenterne sleep_time og awoke_time.
     * Der oprettes en liste med XYChart, navngivet dataList, og x og y labels sættes.
     * Derefter laves en for løkke, som for hvert element i sleep_time beregner sovetiden mellem awoke_time og
     * sleep_time. Disse data tilføjes i listen dataList, og dataList tilføjes til grafen via linechart().
     */
    private void LineChart(ArrayList<String> sleep_time, ArrayList<String> awoke_time) {
        ObservableList<XYChart.Series> dataList = FXCollections.observableArrayList();
        XYChart.Series series = new XYChart.Series();

        y.setLabel("Søvnlængde (timer)");
        x.setLabel("Dag");
        long[] diff = new long[sleep_time.size()];
        String[] date_array = new String[sleep_time.size()];

        for (int i = 0; i < sleep_time.size(); i++) {
            String awoke = awoke_time.get(i);
            String time = sleep_time.get(i);
            String[] splittime = time.split(" ");
            String[] splitawoke = awoke.split(" ");
            Time hours_bedTime = Time.valueOf((splittime[1]));
            Time hours_awokeTime = Time.valueOf(splitawoke[1]);
            date_array[i] = ((splittime[0]));

                diff[i] = TimeUnit.MILLISECONDS.toMinutes(hours_awokeTime.getTime() - hours_bedTime.getTime());
            if (diff[i] < 0)
                diff[i] = diff[i] + 1440; // 24 timer

            if (i > 0) {
                if (date_array[i - 1].equals(date_array[i])) { // Tjekker om eleven er gået i seng to gange
                                                               // på et døgn. Hvis det er sandt, lægges de sammen.
                    diff[i] = diff[i] + diff[i - 1];

                } else if (diff[i-1] != 0) { // Tjekker om det er sovet, og hvis det er sandt, tilføjes data til series.
                    float value = diff[i - 1];
                    value = value / 60;
                    series.getData().add(new XYChart.Data<String, Number>(date_array[i - 1], value ));
                }

                if (sleep_time.size() - 1 == i && diff[i] != 0) { // Hvis det er det sidste element i søvndata,
                                                                  // og det ikke er nul, tilføjes data til serie.
                    float value = diff[i];
                    value = value / 60;
                    series.getData().add(new XYChart.Data<String, Number>(date_array[i], value));
                }
            }
        }
        dataList.addAll(series);
        PreviousSleep.setData(dataList);

    }
}








import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

class SleepModel {

    private static String student_id;
    private static ArrayList<String> sleep_time;
    private static ArrayList<String> awoke_time;

    /**
     * Returnere attributten student_id af typen String.
     */
     public String getStudent_id() {
        return student_id;
    }

    /**
     * Sætter attributten student_id af typen ArrayList til input argumentet student_id.
     */
     public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    /**
     * Returnerer attributten sleep_time af typen ArrayList.
     */
     public ArrayList<String> getSleep_time() {
        return sleep_time;
    }

    /**
     * Sætter attributten sleep_time af typen ArrayList til input argumentet sleep_time.
     */
     public void setSleep_time(ArrayList<String> sleep_time) {
        this.sleep_time = sleep_time;
    }

    /**
     * Returnerer attributten awoke_time af typen ArrayList.
     */
     public ArrayList<String> getAwoke_time() {
        return awoke_time;
    }

    /**
     * Sætter attributten awoke_time af typen ArrayList til input argumentet awoke_time.
     */
     public void setAwoke_time(ArrayList<String> awoke_time) {
        this.awoke_time = awoke_time;
    }

    /**
     * Kalder metoden loadSleepModel i klassen DatabaseController, hvis der er givet en ikke-null string med.
     * Ellers kaldes metoden loadPopSleepModel.
     */
    public void loadModel(String student){
         if (student != null) {
             DatabaseController.loadSleepModel(student);
         }else{
             DatabaseController.loadPopSleepModel();
         }
    }

}


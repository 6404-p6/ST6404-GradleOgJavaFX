import java.util.ArrayList;
import java.util.List;

class StudentListModel {
    static ArrayList<String> studentList_id;

    /**
     * Sætter attributten studentList_id af typen ArrayList til input argumentet studentList_id.
     */
    static void setStudentList_id(ArrayList<String> studentList_id){
        StudentListModel.studentList_id = studentList_id;
    }

    /**
     * Returnerer attributten studentList_id af typen ArrayList.
     */
    static ArrayList<String> getStudentList_id(){
        return studentList_id;
    }

    /**
     * Kalder metoden loadStudentListModel() i klassen DatabaseController, som har til formål at udfylde denne
     * model med data fra databasen.
     */
    void loadModel(){
        DatabaseController.loadStudentListModel();
    }


}

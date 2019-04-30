import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

 class MeetingModel {
    private static ArrayList<String> participatingStudent_id;
    private static ArrayList<String> participatingCoordinator;
    private static ArrayList<Date> meetingTime;
    private static ArrayList<String> meetingLocation;

     /**
      * Sætter attributten participatingCoordinator af typen ArrayList til input argumentet participatingCoordinator.
      */
    public void setParticipatingCoordinator(ArrayList<String> participatingCoordinator){
        MeetingModel.participatingCoordinator =participatingCoordinator;
    }

     /**
      * Returnerer attributten participatingCoordinator af typen ArrayList.
      */
     public ArrayList<String> getParticipatingCoordinator(){
        return participatingCoordinator;
    }

     /**
      * Sætter attributten meetingTime af typen ArrayList til input argumentet meetingTime.
      */
     public void setMeetingTime(ArrayList<Date> meetingTime) {
        MeetingModel.meetingTime = meetingTime;
    }

     /**
      * Returnerer attributten meetingTime af typen ArrayList.
      */
     public ArrayList<Date> getMeetingTime(){
        return meetingTime;
    }

     /**
      * Sætter attributten participatingStudent_id af typen ArrayList til input argumentet participatingStudent_id.
      */
     public void setparticipatingStudent_id(ArrayList<String> participatingStudent_id){
        MeetingModel.participatingStudent_id = participatingStudent_id;
    }

     /**
      * Returnerer attributten participatingStudent_id af typen ArrayList.
      */
     public ArrayList<String> getParticipatingStudent_id(){
     return participatingStudent_id;
    }

     /**
      * Returnerer attributten meetingLocation af typen ArrayList.
      */
     public ArrayList<String> getMeetingLocation() {
         return meetingLocation;
     }

     /**
      * Sætter attributten meetingLocation af typen ArrayList til input argumentet meetingLocation.
      */
     public void setMeetingLocation(ArrayList<String> meetingLocation) {
         MeetingModel.meetingLocation = meetingLocation;
     }

     /**
      * Kalder metoden loadMeetingModel() i klassen DatabaseController, som har til formål at udfylde
      * denne model med data fra databasen.
      */
     public void loadModel(){
        DatabaseController.loadMeetingModel();
    }

     /**
      * Kalder metoden updateMeetingModel() i klassen DatabaseController med input argumenterne student_id,
      * user_id og date. Den opdaterer data i databasen med data fra denne model.
      */
     public void updateModel(String student_id, String user_id, LocalDate date){
        DatabaseController.updateMeetingModel(student_id,user_id,date);
    }
}

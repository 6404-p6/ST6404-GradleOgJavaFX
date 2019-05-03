package ST6404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseConnectorController{
        public static void databaseConnectorController() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(connectionUrl);
            //ResultSet rs = conn.prepareStatement("show tables").executeQuery();
            //loadPatientData ()
            ResultSet patientdatabase = conn.prepareStatement("SELECT * FROM `patientdatabase` WHERE patientdatabase.CPR = 3003965678").executeQuery();
            // loadMedicineList ()
            ResultSet praeparatdatabase = conn.prepareStatement("SELECT * FROM `præparatdatabase`").executeQuery();
            // loadMedicineInteractions
            ResultSet MIdatabase = conn.prepareStatement("SELECT * FROM `MIdatabase`").executeQuery();


            while (patientdatabase.next()) {
                String s = patientdatabase.getString(2);
                System.out.println(s);
            }
            while (praeparatdatabase.next()) {
                String a = praeparatdatabase.getString(2);
                System.out.println(a);
            }
            while (MIdatabase.next()) {
                String b = MIdatabase.getString(2);
                System.out.println(b);
            }
        }
    }
    /*
    Metoder
    - loadPatientData ()
    - loadMedicineList ()
    - loadMedicineInteractions ()
     */

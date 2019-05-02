package ST6404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class databaseConnectorController {

    public static void getPatientdatafromSQL () throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl =
                "https://db.course.hst.aau.dk/phpmyadmin/sql.php?server=1&db=hst_2019_19gr6404&table=patientdatabase&pos=0&token=76c8a524756aa73ade2e664ae9d13ef1";
        Connection conn = DriverManager.getConnection(connectionUrl);
        //ResultSet rs = conn.prepareStatement("show tables").executeQuery();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Trying to connect");
            Connection connection = DriverManager.getConnection(connectionUrl);

            System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
                    + connection.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }
    }




    /*
    Metoder
    - loadPatientData ()
    - loadMedicineList ()
    - loadMedicineInteractions ()
     */

package ST6404;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMysql {
    public static void TestMysql () throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr6404?autoReconnect=true&useSSL=false&user=hst_2019_19gr6404&password=agipheethohwiquiteam&serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(connectionUrl);
        //ResultSet rs = conn.prepareStatement("show tables").executeQuery();
        ResultSet rs = conn.prepareStatement("SELECT * FROM `patientdatabase`").executeQuery();

        while (rs.next()) {
            String s = rs.getString(1);
            System.out.println(s);
        }
    }
}
package v2ch04;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestDB {

    public TestDB() {
    }

    public static void runTest() throws SQLException, IOException {
        Connection conn = getConnection();
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Greetings(message char(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES('Hello world')");

            ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
            if (result.next()) {
                System.out.println(result.getString(1));
            }
            result.close();

            stat.execute("DROP TABLE Greetings");
        } finally {
            conn.close();
        }
    }

    public static Connection getConnection() throws IOException, SQLException {
        Properties pros = new Properties();

        FileInputStream in = new FileInputStream(TestDB.class.getResource(
                "database.properties").getPath());
        pros.load(in);
        in.close();

        String drivers = pros.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }

        String url = pros.getProperty("jdbc.url");
        String user = pros.getProperty("jdbc.username");
        String password = pros.getProperty("jdbc.password");

        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        // Properties props = System.getProperties();
        // for (Object obj : props.keySet()) {
        // System.out.println(obj + "=" + props.getProperty((String)obj));
        // }

        try {
            runTest();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

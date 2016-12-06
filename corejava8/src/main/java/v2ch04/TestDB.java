package v2ch04;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestDB {

    public TestDB() {
        try {
            conn = getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void runTest() throws SQLException, IOException {
        Statement stat = conn.createStatement();
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS Greetings(message char(20))");
        stat.executeUpdate("INSERT INTO Greetings VALUES('Hello world')");

        ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
        if (result.next()) {
            System.out.println(result.getString(1));
        }
        result.close();

        stat.execute("DROP TABLE Greetings");

        stat.close();
    }

    public void runAutoCommitTest() {
        Statement stat;
        try {
            stat = conn.createStatement();
            conn.setAutoCommit(false);
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Greetings(message char(20))");
//            stat.executeUpdate("CREATE TABLE Greetings(message char(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES('Hello world')");
            conn.commit();
            conn.setAutoCommit(true);

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        

        

//        ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
//        if (result.next()) {
//            System.out.println(result.getString(1));
//        }
//        result.close();
//
//        stat.execute("DROP TABLE Greetings");
//
//        stat.close();
    }

    public void runBatchTest() throws SQLException, IOException {
        System.out.println("=====runBatchTest=====");
        Statement stat = conn.createStatement();

        stat.addBatch("CREATE TABLE IF NOT EXISTS Greetings(message char(20))");
        stat.addBatch("INSERT INTO Greetings VALUES('Hello world')");
        stat.addBatch("INSERT INTO Greetings VALUES('Hello Java')");
        stat.addBatch("INSERT INTO Greetings VALUES('Hello Core')");
        stat.executeBatch();

        ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
        while (result.next()) {
            System.out.println(result.getString(1));
        }
        result.close();

        stat.execute("DROP TABLE Greetings");

        stat.close();
        System.out.println("=====Done=====");
    }

    private Connection getConnection() throws IOException, SQLException {
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

    private Connection conn;

    public static void main(String[] args) {
        try {
            TestDB testDB = new TestDB();
            testDB.runTest();
            testDB.runBatchTest();
            testDB.runAutoCommitTest();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

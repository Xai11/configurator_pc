package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    public Connection connect(String dbname, String user, String pass) {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn == null) {
                System.out.println("Нет соединения");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }
    public void connect(){

    }
}


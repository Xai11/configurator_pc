package Connection;
import java.sql.Connection;

public class Relation {
    public void Conn() {
        Database db = new Database();
        Connection conn = db.connect("Components", "postgres", "root");
        System.out.println("Connection");
    }
}

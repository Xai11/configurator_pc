package Interaction;

import Connection.Database;
import Connection.Relation;
import java.sql.Connection;

public class UserInteraction {
    private Database database = new Database();
    private Relation relation = new Relation();
    public void select (String tableName, String columnName ){
        relation.Conn();
        String querySelect = "SELECT " + columnName + " FROM " + tableName + ";";


    }
}

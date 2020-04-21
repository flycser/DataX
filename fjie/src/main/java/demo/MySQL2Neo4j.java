package demo;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL2Neo4j {

    private static Logger logger = Logger.getLogger(MySQL2Neo4j.class);

    private static final String SQL_PREFIX = "jdbc:mysql://";

    private String host;
    private int port;
    private String username;
    private String password;
    private String database;
    private Connection conn = null;

    public MySQL2Neo4j(String host, int port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public void initConnection() {
        try {
            conn = DriverManager.getConnection(String.format("%s%s:%d?user=%s&password=%s", SQL_PREFIX, host, port, username, password));
            conn.setCatalog(database);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main( String[] args ) {

        String host = "imagesearch.po.mlamp.cn";
        int port = 3306;
        String username = "fjie";
        String password = "mlamp";
        String database = "NorthWind";

        MySQL2Neo4j mySQL2Neo4j = new MySQL2Neo4j(host, port, username, password, database);
        mySQL2Neo4j.initConnection();
    }
}

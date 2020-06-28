import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PolaczenieZBaza {

    private static PolaczenieZBaza inst;
    private Connection connection;

    public static PolaczenieZBaza getInstance() throws ClassNotFoundException, SQLException {
        if(inst == null) {
            PolaczenieZBaza pol = new PolaczenieZBaza();
            inst = pol;
        }
        return inst;
    }

    PolaczenieZBaza() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection( "jdbc:derby://localhost:1527/baza1" );
        return connection;
    }

    public void close() throws SQLException{
        
    }

}

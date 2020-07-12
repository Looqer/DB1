import java.sql.*;

public class PolaczenieZBaza {

    private static PolaczenieZBaza inst;
    private static Connection connection;



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

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection( "jdbc:derby://localhost:1527/baza1" );
        return connection;
    }

    public void close() throws SQLException{
        
    }


}

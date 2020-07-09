import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

class Wiersz {

    public int id;
    public String[] dane;

    public Wiersz( ResultSet r ) throws SQLException {
        id = r.getInt(1);
        ResultSetMetaData rsmd = r.getMetaData();
        dane = new String[ rsmd.getColumnCount()-1 ];
        for (int i=0;i<dane.length;i++) dane[i]=r.getString(i+2);
    }
}

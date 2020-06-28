import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task {

    public static void addPerson(Statement s) throws SQLException {

        ResultSet rs = s.executeQuery("select * from osoby" );
        while (rs.next()) {
            System.out.format( "id=%d, imie=%s, nazwisko=%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
        }
    }

    public static void showAll(Statement s) throws SQLException {

        ResultSet rs = s.executeQuery("select * from osoby" );
        while (rs.next()) {
            System.out.format( "id=%d, imie=%s, nazwisko=%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
        }
    }

    public static void showFiltered(Statement s) throws SQLException {

        ResultSet rs = s.executeQuery("select * from osoby" );
        while (rs.next()) {
            System.out.format( "id=%d, imie=%s, nazwisko=%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
        }
    }

    public static void updatePerson(Statement s) throws SQLException {

        ResultSet rs = s.executeQuery("select * from osoby" );
        while (rs.next()) {
            System.out.format( "id=%d, imie=%s, nazwisko=%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
        }
    }


}

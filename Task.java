import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task {

    public static void addPerson(Statement s) throws SQLException {

        String name, surname;
        System.out.println("Podaj imie: ");
        Scanner inName = new Scanner(System.in);
        name = inName.nextLine();
        System.out.println("Podaj nazwisko: ");
        Scanner inSurname = new Scanner(System.in);
        surname = inSurname.nextLine();
        s.executeUpdate("insert into osoby (imie, nazwisko) values ('"+name+"'   , '"+surname+"')");

    }

    public static void showAll(Statement s) throws SQLException {

        ResultSet rs = s.executeQuery("select * from osoby" );
        while (rs.next()) {
            System.out.format( "id=%d, imie=%s, nazwisko=%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
        }

    }

    public static void showFiltered(Statement s) throws SQLException {

        String search;
        System.out.println("Podaj fragment: ");
        Scanner inSearch = new Scanner(System.in);
        search = inSearch.nextLine();

        ResultSet rs = s.executeQuery("SELECT  * from osoby WHERE imie like '%"+search+"%' or nazwisko like '%"+search+"%'" );
        while (rs.next()) {
            System.out.format( "id=%d, imie=%s, nazwisko=%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
        }
    }

    public static void updatePerson(Statement s) throws SQLException {

        String name, surname;
        String id;
        System.out.println("Podaj id do edycji: ");
        Scanner inId = new Scanner(System.in);
        id = inId.nextLine();
        System.out.println("Podaj nowe imie: ");
        Scanner inName = new Scanner(System.in);
        name = inName.nextLine();
        System.out.println("Podaj nowe nazwisko: ");
        Scanner inSurname = new Scanner(System.in);
        surname = inSurname.nextLine();

        s.executeUpdate("UPDATE osoby SET imie = '"+name+"' WHERE id="+id+""); // update
        s.executeUpdate("UPDATE osoby SET nazwisko = '"+surname+"' WHERE id="+id+""); // update

    }


}

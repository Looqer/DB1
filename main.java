import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {

        PolaczenieZBaza polaczenieZBaza = new PolaczenieZBaza();
        boolean on = true;
        String choice = null;

        Connection connection = PolaczenieZBaza.getInstance().getConnection();

        Statement s = connection.createStatement();

        while(on){
            System.out.println("1 - Dodaj osobe \n2 - Pokaz wszystkie \n3 - Pokaz filtr \n4 - Zmien dane osoby \n0 - Koniec");
            Scanner in = new Scanner(System.in);
            choice = in.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("jeden");
                    break;
                case "2":
                    System.out.println("dwa");
                    break;
                case "3":
                    System.out.println("trzy");
                    break;
                case "4":
                    System.out.println("cztery");
                    break;
                case "0":
                    System.out.println("zero");
                    on = false;
                    break;
               default:
                    System.out.println("Input error");
                    break;

            }
            //s.executeUpdate("insert into osoby (imie, nazwisko) values ('dupa'   , 'dupowicz')"); //dodawanie
            //s.executeUpdate("delete from osoby where id=101"); // usuwanie
            //s.executeUpdate("UPDATE osoby SET imie='Marek' WHERE id=201"); // update
            choice = null;
            Task.showAll(s);
        }


        connection.close();
    }
}

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {

        PolaczenieZBaza polaczenieZBaza = new PolaczenieZBaza();
        boolean on = true;
        String choice = null;

        Connection connection = PolaczenieZBaza.getInstance().getConnection();

        Statement s = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        KontaktyFrame frame = new KontaktyFrame();
        frame.startFrame(s);

        while(on){
            System.out.println("1 - Dodaj osobe \n2 - Pokaz wszystkie \n3 - Pokaz filtr \n4 - Zmien dane osoby \n0 - Koniec");
            Scanner in = new Scanner(System.in);
            choice = in.nextLine();

            switch (choice) {
                case "1":
                    Task.addPerson(s);
                    break;
                case "2":
                    Task.showAll(s);
                    break;
                case "3":
                    Task.showFiltered(s);
                    break;
                case "4":
                    Task.updatePerson(s);
                    break;
                case "0":
                    on = false;
                    break;
               default:
                    System.out.println("Input error");
                    break;

            }

            choice = null;
        }

        connection.close();
    }
}

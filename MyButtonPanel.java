import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

class MyButtonPanel extends JPanel implements ActionListener {

    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;
    public JButton dodaj_osobe, dodaj_kontakt, usun, pokaz;

    public MyButtonPanel() {
        dodaj_osobe = new JButton("Dodaj osobę");
        dodaj_kontakt = new JButton("Dodaj kontakt");
        usun = new JButton("Usuń");
        pokaz = new JButton("Pokaż");

        dodaj_osobe.addActionListener(this);
        dodaj_kontakt.addActionListener(this);
        usun.addActionListener(this);
        pokaz.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(dodaj_osobe);
        add(dodaj_kontakt);
        add(usun);
        add(pokaz);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == dodaj_kontakt) {
            System.out.println("butk");
        }
        else if (source == dodaj_osobe) {
            String imieINazwisko = JOptionPane.showInputDialog(MyButtonPanel.this, "Wpisz imię i nazwisko oddzielone spacją");
            String[] dane = imieINazwisko.split(" ");

            PreparedStatement ps = null;
            try {
                ps = PolaczenieZBaza.getInstance().getConnection().prepareStatement("insert into osoby (imie, nazwisko) values (?, ?)");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();

                try {
                    ps.setString(1, dane[0]);
                    ps.setString(2, dane.length < 2 ? "" : dane[1]);
                    ps.executeUpdate();
                    ps.close();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    KontaktyFrame.dataModel.refresh();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException notFoundException) {
                    notFoundException.printStackTrace();
                }
                KontaktyFrame.dataModel.fireTableDataChanged();
            }
        }
        else if (source == usun) {
            System.out.println("butu");
        }
        else if (source == pokaz) {
            System.out.println("butp");
        }
    }
}




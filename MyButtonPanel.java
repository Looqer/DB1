import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class MyButtonPanel extends JPanel implements ActionListener{

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

        if(source == dodaj_kontakt)
            System.out.println("butk");

        else if(source == dodaj_osobe)
            System.out.println("buto");

        else if(source == usun)
            System.out.println("butu");

        else if(source == pokaz)
            System.out.println("butp");
    }
}
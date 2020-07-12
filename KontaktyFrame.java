
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class KontaktyFrame extends JFrame {

    static DBTableModel dataModel;
    static JTable table;
    MyButtonPanel bottomPanel;

    static GraphicsConfiguration gc;
    static JFrame frame = new JFrame(gc);
    static ResultSet rs;

    public void startFrame(Statement s) throws SQLException, ClassNotFoundException {
        frame.setTitle("Kontakty");
        frame.setSize(640, 320);
        frame.setLocation(400, 300);
        frame.setVisible(true);

        Connection connection = PolaczenieZBaza.getConnection();

        table = new JTable();
        dataModel = new DBTableModel(s.getConnection(),"select * from osoby");
        table.setModel(dataModel);

        bottomPanel = new MyButtonPanel();

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

        @Override
        public void valueChanged (ListSelectionEvent arg0){
            bottomPanel.dodaj_kontakt.setEnabled(table.getSelectedRowCount() == 1);
            bottomPanel.usun.setEnabled(table.getSelectedRowCount() > 0);
            bottomPanel.pokaz.setEnabled(table.getSelectedRowCount() > 0);
        }

    });

        frame.add(bottomPanel,BorderLayout.SOUTH);
        frame.add(new JScrollPane(table),BorderLayout.CENTER );


    }

}








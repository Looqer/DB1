
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class KontaktyFrame extends JFrame {

    static DBTableModel dataModel;
    JTable table;
    MyButtonPanel bottomPanel;

    static GraphicsConfiguration gc;

    public void startFrame(Statement s) throws SQLException {
        JFrame frame = new JFrame(gc);
        frame.setTitle("Kontakty");
        frame.setSize(640, 320);
        frame.setLocation(400, 300);
        frame.setVisible(true);


        String[] columnNames = {"Imię",
                "Nazwisko"};

        ResultSet rs = s.executeQuery("select * from osoby");
        rs.last();
        String[][] data = new String[rs.getRow()][2];
        rs.beforeFirst();

        int i = 0;
        while (rs.next()) {
            data[i][0] = rs.getString(2);
            data[i][1] = rs.getString(3);
            i++;
        }


    table =new

    JTable(data, columnNames);

    bottomPanel =new

    MyButtonPanel();
        table.getSelectionModel().

    addListSelectionListener(new ListSelectionListener() {

        @Override
        public void valueChanged (ListSelectionEvent arg0){
            bottomPanel.dodaj_kontakt.setEnabled(table.getSelectedRowCount() == 1);
            bottomPanel.usun.setEnabled(table.getSelectedRowCount() > 0);
            bottomPanel.pokaz.setEnabled(table.getSelectedRowCount() > 0);
        }
    });

        frame.add(bottomPanel,BorderLayout.SOUTH);
        frame.add(new

    JScrollPane(table),BorderLayout.CENTER );


    }

}








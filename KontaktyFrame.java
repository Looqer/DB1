
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class KontaktyFrame extends JFrame {

    static DBTableModel dataModel;
    static JTable table;

    static GraphicsConfiguration gc;

    public void startFrame(Statement s) throws SQLException {
        JFrame frame= new JFrame(gc);
        frame.setTitle("Kontakty");
        frame.setSize(640, 320);
        frame.setLocation(400, 300);
        frame.setVisible(true);

        MyButtonPanel bottomPanel = new MyButtonPanel();

        String[] columnNames = {"Imię",
                "Nazwisko"};

        ResultSet rs = s.executeQuery("select * from osoby" );
        rs.last();
        String[][] data = new String[rs.getRow()][2];
        rs.beforeFirst();

        int i=0;
        while (rs.next()) {
            data[i][0] = rs.getString(2);
            data[i][1] = rs.getString(3);
            i++;
        }

        JTable table = new JTable(data, columnNames);
        table.getSelectionModel().addListSelectionListener( this );

        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER );



    }










}




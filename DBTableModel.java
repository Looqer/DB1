import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

class DBTableModel extends AbstractTableModel {

    Connection myConnection;
    String myQuery;

    public DBTableModel( Connection connection, String query ){
    myConnection = connection;
    myQuery = query;
    }


    private Vector<Wiersz> dane;

    private int ileKolumn = 0;
    private String[] nazwy;

    @Override
    public int getColumnCount() {
        if (dane == null) {
            try {
                pobierzDane();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
        return ileKolumn;
    }

    @Override
    public int getRowCount() {
        if (dane == null) {
            try {
                pobierzDane();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
        return dane.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        return dane.get(row).dane[col];
    }

    @Override
    public String getColumnName(int col) {

        return nazwy[col];
    }


    public void pobierzDane() throws SQLException, ClassNotFoundException {

        Connection connection = PolaczenieZBaza.getInstance().getConnection();

        dane = new Vector<Wiersz>();

        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("select * from osoby");
        while (rs.next()) dane.add( new Wiersz( rs ) );

        ileKolumn = rs.getMetaData().getColumnCount()-1;
        nazwy = new String[ileKolumn];
        for (int i=0;i<nazwy.length;i++) nazwy[i] = rs.getMetaData().getColumnName(i+2);
        s.close();
    }


    public void refresh() throws SQLException, ClassNotFoundException {
        pobierzDane();
        
    }


    public int[] dajIdentyfikatory(int[] selectedRows) {

        int[] id = new int[selectedRows.length];
        for (int i=0;i<id.length;i++) id[i] = dane.get(selectedRows[i]).id;
        return id;
    }
}

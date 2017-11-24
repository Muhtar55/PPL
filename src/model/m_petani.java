/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhtar
 */
public class m_petani extends baseModel {

    private final Koneksi kon;
    public static String status;

    public m_petani() throws SQLException {
        super();
        this.kon = new Koneksi("root", "", "pertanian");
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id_Petani", "Nama", "TTL", "Domisilin"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from tb_petani";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[4];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public boolean save(String query) throws SQLException {
        String queries = "INSERT INTO tb_petani VALUES (" + query + ")";
        return super.execute(queries); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(String query) throws SQLException {
        String queries = "DELETE FROM tb_petani where Id_Petani ='" + query + "'";
        return super.execute(queries); //To change body of generated methods, choose Tools | Templates.
    }
}

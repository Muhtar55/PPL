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
public class m_lahan extends baseModel{

    private final Koneksi kon;
    public static String status;

    public m_lahan() throws SQLException {
        super();
        this.kon = new Koneksi("root", "", "pertanian");
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id_Lahan", "Nama_Lahan", "Luas", "Alamat"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from tb_lahan";
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
        String queries = "INSERT INTO tb_lahan VALUES (" + query + ")";
        return super.execute(queries);
    }
    
    public boolean delete(String query) throws SQLException {
        String queries = "DELETE FROM tb_lahan where Id_Lahan ='" + query + "'";
        return super.execute(queries);
    }

    public boolean update(String query) throws SQLException {
        String queries = "UPDATE tb_lahan SET " + query;
        return super.execute(queries);
    }

}

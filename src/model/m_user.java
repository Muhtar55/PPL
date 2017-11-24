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
public class m_user extends baseModel{

    private final Koneksi kon;

    public m_user() throws SQLException {
        super();
        this.kon = new Koneksi("root", "", "pertanian");
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"IdUser", "Nama", "UserName", "Password", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from tb_user";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[5];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public ResultSet check(String UserName, String Password) throws SQLException {
        String query = "SELECT * FROM tb_user WHERE UserName='" + UserName + "' AND Password='" + Password + "'";
        ResultSet Result = kon.getResult(query);
        return Result;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import static model.m_kontrak.luas;
import static model.m_kontrak.mana;
import static model.m_kontrak.namalahan;

/**
 *
 * @author Muhtar
 */
public class m_menuDivisiHasil extends baseModel {

    private final Koneksi kon;
    public static String nama;
//    public static String namalahan;
    public static String luas;

    public m_menuDivisiHasil() throws SQLException {
        super();
        this.kon = new Koneksi("root", "", "pertanian");
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id_Hasil", "Id_Kontrak", "Nama_Petani", "Luas", "Hasil"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from tb_hasil";
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

    public String[] IdKontrak() throws SQLException {
        String query = "SELECT Id_Kontrak FROM tb_kontrak";
        ResultSet rs = kon.getResult(query);
        rs.last();
        String IdPetani[] = new String[rs.getRow()];
        rs.beforeFirst();
        int a = 0;
        while (rs.next()) {
            IdPetani[a] = rs.getString("Id_Kontrak");
            a++;
        }
        a = 0;
        return IdPetani;
    }

    public void status(int id) throws SQLException {
        String sql = "select * from tb_kontrak where Id_Kontrak=" + id;
        Statement st = kon.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
//        idmotorasli = rs.getString("Id_Motor");
//        status = rs.getString("status");
        nama = rs.getString("Nama_Petani");
        luas = rs.getString("Luas");
//        merek = rs.getString("merek");
//        type = rs.getString("type");
//        nopol = rs.getString("nopol");
    }

//    public String[] IdLahan() throws SQLException {
//        String query = "SELECT Id_Lahan FROM tb_lahan";
//        ResultSet rs = kon.getResult(query);
//        rs.last();
//        String IdLahan[] = new String[rs.getRow()];
//        rs.beforeFirst();
//        int a = 0;
//        while (rs.next()) {
//            IdLahan[a] = rs.getString("Id_Lahan");
//            a++;
//        }
//        a = 0;
//        return IdLahan;
//    }

//    public void coba(int id) throws SQLException {
//        String sql = "select * from tb_lahan where Id_Lahan=" + id;
//        Statement st = kon.getConnection().createStatement();
//        ResultSet rs = st.executeQuery(sql);
//        rs.next();
////        idmotorasli = rs.getString("Id_Motor");
////        status = rs.getString("status");
////        namalahan = rs.getString("Nama_Lahan");
//        luas = rs.getString("Luas");
////        type = rs.getString("type");
////        nopol = rs.getString("nopol");
//    }

    public boolean delete(String query) throws SQLException {
        String queries = "DELETE FROM tb_hasil where Id_Hasil ='" + query + "'";
        return super.execute(queries); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(String query) throws SQLException {
        String queries = "UPDATE tb_hasil SET " + query;
        return super.execute(queries); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean save(String query) throws SQLException {
        String queries = "INSERT INTO tb_hasil VALUES (" + query + ")";
//        JOptionPane.showMessageDialog(c_peminjaman.theview ,"Motor Tidak Tersedia");    
        return super.execute(queries); //To change body of generated methods, choose Tools | Templates.
    }
}

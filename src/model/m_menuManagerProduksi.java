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

/**
 *
 * @author Muhtar
 */
public class m_menuManagerProduksi extends baseModel {

    private final Koneksi kon;
    public static String namapetani;
    public static String namalahan;
    public static String luas;
    public static String target;
    public static String hasil;

    public m_menuManagerProduksi() throws SQLException {
        super();
        this.kon = new Koneksi("root", "", "pertanian");
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id_Target", "Id_Kontrak", "Nama_Petani", "Nama_Lahan","Luas", "Target", "Id_Hasil", "Hasil"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from tb_target";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[8];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public void status(){
        String query = "select * tb_target t join tb_kontrak k on t.Id_Kontrak"
    }
//    public String[] IdKontrak() throws SQLException {
//        String query = "SELECT * FROM tb_kontrak";
//        ResultSet rs = kon.getResult(query);
//        rs.last();
//        String IdPetani[] = new String[rs.getRow()];
//        rs.beforeFirst();
//        int a = 0;
//        while (rs.next()) {
//            IdPetani[a] = rs.getString("Id_Kontrak");
//            a++;
//        }
//        a = 0;
//        return IdPetani;
//    }
//
//    public void status(int id) throws SQLException {
//        String sql = "select * from tb_kontrak where Id_Kontrak=" + id;
//        Statement st = kon.getConnection().createStatement();
//        ResultSet rs = st.executeQuery(sql);
//        rs.next();
////        idmotorasli = rs.getString("Id_Motor");
////        status = rs.getString("status");
//        namapetani = rs.getString("Nama_Petani");
//        namalahan = rs.getString("Nama_Lahan");
//        luas = rs.getString("Luas");
//        target = rs.getString("Target");
////        merek = rs.getString("merek");
////        type = rs.getString("type");
////        nopol = rs.getString("nopol");
//    }

    public String[] Idhasil() throws SQLException {
        String query = "SELECT Id_Hasil FROM tb_hasil";
        ResultSet rs = kon.getResult(query);
        rs.last();
        String IdPetani[] = new String[rs.getRow()];
        rs.beforeFirst();
        int a = 0;
        while (rs.next()) {
            IdPetani[a] = rs.getString("Id_Hasil");
            a++;
        }
        a = 0;
        return IdPetani;
    }

    public void sta(int id) throws SQLException {
        String sql = "select * from tb_hasil where Id_Hasil=" + id;
        Statement st = kon.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
//        idmotorasli = rs.getString("Id_Motor");
//        status = rs.getString("status");
        hasil = rs.getString("Hasil");
    }
    
    public boolean delete(String query) throws SQLException {
        String queries = "DELETE FROM tb_target where Id_Target ='" + query + "'";
        return super.execute(queries); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(String query) throws SQLException {
        String queries = "UPDATE tb_target SET " + query;
        return super.execute(queries); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean save(String query) throws SQLException {
        String queries = "INSERT INTO tb_target VALUES (" + query + ")";
//        JOptionPane.showMessageDialog(c_peminjaman.theview ,"Motor Tidak Tersedia");    
        return super.execute(queries); //To change body of generated methods, choose Tools | Templates.
    }

}

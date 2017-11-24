/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_lahan;
import view.v_lahan;

/**
 *
 * @author Muhtar
 */
public class c_lahan {

    m_lahan themodel;
    v_lahan theview;

    public c_lahan(v_lahan theview, m_lahan themodel) throws SQLException {
        this.themodel = themodel;
        this.theview = theview;
        theview.setVisible(true);
        theview.addBtnSaveListener(new saveListener());
        theview.addBtnEditListener(new editListener());
        theview.addBtnUpdateListener(new updateListener());
        theview.addBtnDeleteListener(new deleteListener());
        theview.addBtnKeluarListener(new KeluarListener());
        theview.setTable(themodel.getTableModel());
    }

    private class editListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = theview.getSelectedRow();
            if (baris != -1) {

                String lahanid = theview.getValueAt(baris, 0);
                String nama = theview.getValueAt(baris, 1);
                String luas = theview.getValueAt(baris, 2);
                String alamat = theview.getValueAt(baris, 3);

                theview.setIdlahan(lahanid);
                theview.setNamalahan(nama);
                theview.setLuas(luas);
                theview.setAlamat(alamat);

            }
        }
    }

    private class KeluarListener implements ActionListener {

        public KeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            c_menuUtamaPengelolah con = new c_menuUtamaPengelolah();
        }
    }

    private class deleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theview.getSelectedRow();
                String lahanid = theview.getValueAt(baris, 0);
                System.out.println(lahanid);
                themodel.delete(lahanid);
                theview.setTable(themodel.getTableModel());
                clear();
            } catch (SQLException ex) {
                Logger.getLogger(c_lahan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theview.getSelectedRow();
                String lahanid = theview.getIdlahan();
                String nama = theview.getNamalahan();
                String lebar = theview.getLuas();
                String tempat = theview.getAlamat();
                themodel.update("Nama_Lahan='" + nama + "', Luas=" + lebar + ", Alamat='" + tempat + "'  WHERE Id_Lahan =" + lahanid);
                theview.setTable(themodel.getTableModel());
                clear();
            } catch (SQLException ex) {
                Logger.getLogger(c_lahan.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (theview.getNamalahan().isEmpty() || theview.getLuas().isEmpty() || theview.getAlamat().isEmpty()) {
                    JOptionPane.showMessageDialog(theview, "Data Tidak Boleh Kosong");
                }
                themodel.save("null,'" + theview.getNamalahan() + "','" + theview.getLuas() + "','" + theview.getAlamat() + "'");
                theview.setTable(themodel.getTableModel());
                theview.setNamalahan("");
                theview.setLuas("");
                clear();
            } catch (SQLException ex) {
                Logger.getLogger(c_lahan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void clear() {
        theview.setIdlahan("");
        theview.setNamalahan("");
        theview.setLuas("");
        theview.setAlamat("");
    }

}

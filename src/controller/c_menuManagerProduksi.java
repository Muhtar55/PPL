/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_menuManagerProduksi;
import view.v_menuManagerProduksi;

/**
 *
 * @author Muhtar
 */
public class c_menuManagerProduksi {

    m_menuManagerProduksi themodel;
    v_menuManagerProduksi theview;

    public c_menuManagerProduksi(v_menuManagerProduksi theview, m_menuManagerProduksi themodel) throws SQLException {
        this.theview = theview;
        this.themodel = themodel;
        theview.setVisible(true);
        theview.setIdkontrak(themodel.IdKontrak());
        theview.setIdhasil(themodel.Idhasil());
        theview.addSaveListener(new saveListener());
        theview.addDeleteListener(new deleteListener());
        theview.addBtnKeluarListener(new KeluarListener());
        theview.check(new c_menuManagerProduksi.check());
        theview.cek(new c_menuManagerProduksi.cek());
//        theview.cek(new c_menuDivisiHasil.cek());
        theview.setTable(themodel.getTableModel());
    }

    private class cek implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            try {
                themodel.sta(Integer.parseInt((String) theview.getIdhasil().getSelectedItem()));
                theview.setHasil(m_menuManagerProduksi.hasil);
            } catch (SQLException ex) {
                Logger.getLogger(c_menuManagerProduksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (theview.getNamapetani().getText().isEmpty() || theview.getNamalahan().getText().isEmpty() || theview.getLuas().getText().isEmpty()|| theview.getTarget().getText().isEmpty() || theview.getHasil().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(theview, "Data Tidak Boleh Kosong");
                }
                themodel.save("NULL," + theview.getIdkontrak().getSelectedItem().toString()+",'"+theview.getNamapetani().getText()+"','"+theview.getNamalahan().getText()+"',"+theview.getLuas()+","+theview.getTarget().getText()+","+theview.getIdhasil().getSelectedItem().toString()+","+theview.getHasil().getText());
//                themodel.save("NULL," + theview.getIdkontrak().getSelectedItem().toString() + ",'" + theview.getNama() + "','" + theview.getLahan() + "'," + theview.getLuas()+","+theview.getTarget()+","+theview.getIdhasil().getSelectedItem().toString()+","+theview.getHasil());
                theview.setTable(themodel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_menuManagerProduksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class deleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theview.getSelectedRow();
                String id = theview.getValueAt(baris, 0);
                System.out.println(id);
                themodel.delete(id);
                theview.text(true);
                theview.button(true);
//                clear();
//             theview.buttonadd(false);
                theview.setTable(themodel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_menuManagerProduksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class KeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theview.dispose();
                c_user con = new c_user();
            } catch (SQLException ex) {
                Logger.getLogger(c_menuManagerProduksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class check implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            try {
                themodel.status(Integer.parseInt((String) theview.getIdkontrak().getSelectedItem()));
                theview.setNama(m_menuManagerProduksi.namapetani);
                theview.setLahan(m_menuManagerProduksi.namalahan);
                theview.setLuas(m_menuManagerProduksi.luas);
                theview.setTarget(m_menuManagerProduksi.target);
            } catch (SQLException ex) {
                Logger.getLogger(c_menuManagerProduksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

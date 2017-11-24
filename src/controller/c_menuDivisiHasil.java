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
import model.m_menuDivisiHasil;
import view.v_menuDivisiHasil;

/**
 *
 * @author Muhtar
 */
public class c_menuDivisiHasil {

//    v_menuDivisiHasil theView = new v_menuDivisiHasil();
    m_menuDivisiHasil themodel;
    v_menuDivisiHasil theview;
//    v_menuDivisiHasil theView;

    public c_menuDivisiHasil(v_menuDivisiHasil theview, m_menuDivisiHasil themodel) throws SQLException {
        this.theview = theview;
        this.themodel = themodel;
        theview.setVisible(true);
        theview.setIdkontrak(themodel.IdKontrak());
//        theview.setIdlahan(themodel.IdLahan());
        theview.addSaveListener(new saveListener());
        theview.addDeleteListener(new deleteListener());
        theview.addBtnKeluarListener(new KeluarListener());
        theview.check(new c_menuDivisiHasil.check());
//        theview.cek(new c_menuDivisiHasil.cek());
        theview.setTable(themodel.getTableModel());
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (theview.getNama().isEmpty() || theview.getLuas().isEmpty() || theview.getHasil().isEmpty()) {
                    JOptionPane.showMessageDialog(theview, "Data Tidak Boleh Kosong");
                }
                themodel.save("NULL," + theview.getIdkontrak().getSelectedItem().toString() + ",'" + theview.getNama() + "'," + theview.getLuas() + "," + theview.getHasil());
                theview.setTable(themodel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_menuDivisiHasil.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(c_menuDivisiHasil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class check implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            try {
                themodel.status(Integer.parseInt((String) theview.getIdkontrak().getSelectedItem()));
                theview.setNama(m_menuDivisiHasil.nama);
                theview.setLuas(m_menuDivisiHasil.luas);
            } catch (SQLException ex) {
                Logger.getLogger(c_menuDivisiHasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    private class cek implements ItemListener {
//
//        @Override
//        public void itemStateChanged(ItemEvent e) {
//            try {
//                themodel.coba(Integer.parseInt((String) theview.getIdlahan().getSelectedItem()));
////            theview.setLahan(m_menuDivisiHasil.namap);
//theview.setLuas(m_menuDivisiHasil.luas);
//            } catch (SQLException ex) {
//                Logger.getLogger(c_menuDivisiHasil.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    private class KeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            try {
                c_user con = new c_user();
            } catch (SQLException ex) {
                Logger.getLogger(c_menuDivisiHasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

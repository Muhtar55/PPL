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
import model.m_petani;
import view.v_petani;

/**
 *
 * @author Muhtar
 */
public class c_petani {

    m_petani themodel;
    v_petani theview;

    public c_petani(v_petani theview, m_petani themodel) throws SQLException {
        this.themodel = themodel;
        this.theview = theview;
        theview.setVisible(true);
        theview.addBtnSimpanListener(new simpanListener());
        theview.addBtnKembaliListener(new kembaliListener());
//        theview.setTable(themodel.getTableModel());
    }

    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            c_menuUtamaPetani con = new c_menuUtamaPetani();
        }
    }

    private class simpanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if (theview.getMana().isEmpty() || theview.getTempat().isEmpty() || theview.getAlamat().isEmpty()) {
                    JOptionPane.showMessageDialog(theview, "Data Tidak Boleh Kosong");
                }
                themodel.save("null, '" + theview.getMana() + "', '" + theview.getTempat() + "', '" + theview.getAlamat() + "'");
//                theview.setTable(themodel.getTableModel());
                theview.setMana("");
                theview.setTempat("");
                theview.setAlamat("");
            } catch (SQLException ex) {
                Logger.getLogger(c_petani.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

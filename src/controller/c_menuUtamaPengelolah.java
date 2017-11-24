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
import model.m_kontrak;
import model.m_lahan;
import view.v_kontrak;
import view.v_lahan;
import view.v_menuUtamaPengelolah;

/**
 *
 * @author Muhtar
 */
public class c_menuUtamaPengelolah {

    v_menuUtamaPengelolah theView = new v_menuUtamaPengelolah();

    public c_menuUtamaPengelolah() {
        theView.setVisible(true);
        this.theView = theView;
        theView.addBtnLahanListener(new LahanListener());
        theView.addBtnKontrakListener(new KontrakListener());
        theView.addBtnKeluarListener(new KeluarListener());
    }
//    private class KeluarListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            theView.dispose();
//            try {
//                c_user con = new c_user();
//            } catch (SQLException ex) {
//                Logger.getLogger(c_menuUtamaPetani.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//    }

    private class KontrakListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.dispose();
                c_kontrak con = new c_kontrak (new v_kontrak(), new m_kontrak());
//                c_kontrak con = new c_kontrak (new v_kontrak(), new m_kontrak());
            } catch (SQLException ex) {
                Logger.getLogger(c_menuUtamaPengelolah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class LahanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.dispose();
                c_lahan con = new c_lahan(new v_lahan(), new m_lahan());
            } catch (SQLException ex) {
                Logger.getLogger(c_menuUtamaPengelolah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class KeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            try {
                c_user con = new c_user();
            } catch (SQLException ex) {
                Logger.getLogger(c_menuUtamaPengelolah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

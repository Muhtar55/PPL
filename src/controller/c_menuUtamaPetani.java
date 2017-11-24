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
import model.m_petani;
import view.v_menuUtamaPetani;
import view.v_petani;

/**
 *
 * @author Muhtar
 */
public class c_menuUtamaPetani {

//    v_menuUtamaPetani theView;
    v_menuUtamaPetani theView = new v_menuUtamaPetani();

    public c_menuUtamaPetani() {
        theView.setVisible(true);
//        this.theView = theView;
        this.theView = theView;
        theView.addPetaniListener(new PetaniListener());
        theView.addBtnKeluarListener(new KeluarListener());
        theView.addBtnLihatListener(new LihatListener());
        theView.addHapusListener(new HapusListener());
    }

    private class HapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.dispose();
                c_hapuspetani con = new c_hapuspetani();
            } catch (SQLException ex) {
                Logger.getLogger(c_menuUtamaPetani.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class LihatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.dispose();
                c_lihatpetani con = new c_lihatpetani();
            } catch (SQLException ex) {
                Logger.getLogger(c_menuUtamaPetani.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class PetaniListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c_petani con = new c_petani(new v_petani(), new m_petani());
                theView.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(c_menuUtamaPetani.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(c_menuUtamaPetani.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

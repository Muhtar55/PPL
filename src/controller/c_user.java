/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.m_menuDivisiHasil;
import model.m_menuManagerProduksi;
import model.m_user;
import view.v_login;
import view.v_menuDivisiHasil;
import view.v_menuManagerProduksi;
import view.v_menuUtamaPengelolah;

/**
 *
 * @author Muhtar
 */
public class c_user {

    v_login theView = new v_login();
    m_user theModel;

    public c_user() throws SQLException {
        this.theModel = new m_user();
        theView.setVisible(true);
        theView.AddBtnMasukListener(new btnMasukListener());
    }

    private class btnMasukListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String Username = theView.getUser().getText();
            String Password = "";
            char passArray[] = theView.getPass().getPassword();
            for (int i = 0; i < passArray.length; i++) {
                Password += passArray[i];
            }
            try {
                ResultSet rs = theModel.check(Username, Password);
                rs.last();
                if (rs.getRow() == 1) {
                    String Status = rs.getString(5);
                    theView.dispose();
                    if (Status.equalsIgnoreCase("Pengelolah")) {
                        c_menuUtamaPengelolah control = new c_menuUtamaPengelolah();
//                        view.menuUtama a = new view.menuUtama();
//                        a.setVisible(true);
//                        theView.dispose();
                    } else if (Status.equalsIgnoreCase("Petani")) {
                        c_menuUtamaPetani control = new c_menuUtamaPetani();
//                        view.menuUtamapega b = new view.menuUtamapega();
//                        b.setVisible(true);
//                        theView.dispose();
                    } else if (Status.equalsIgnoreCase("Hasil")) {
                        c_menuDivisiHasil control = new c_menuDivisiHasil(new v_menuDivisiHasil(), new m_menuDivisiHasil());

                    }else if (Status.equalsIgnoreCase("manager")){
                        c_menuManagerProduksi control = new c_menuManagerProduksi(new v_menuManagerProduksi(), new m_menuManagerProduksi());
                    }

                } else {
                    theView.salah();
//                } else {
//                    theView.kosong();
                }

            } catch (SQLException ex) {
                Logger.getLogger(c_user.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

//    private class batalListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            c_menuAwal con = new c_menuAwal();
//            login.dispose();
//        }
//
//    }
}

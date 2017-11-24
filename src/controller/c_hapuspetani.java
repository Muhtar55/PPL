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
import view.v_hapuspetani;
import view.v_petani;

/**
 *
 * @author Muhtar
 */
public class c_hapuspetani {

    v_hapuspetani theview = new v_hapuspetani();
    v_petani view;
    m_petani themodel;
    

    public c_hapuspetani() throws SQLException {
        this.themodel = new m_petani();
        this.view = new v_petani();
        theview.setVisible(true);
        theview.addBtnHapusListener(new hapusListener());
        theview.addBtnKembaliListener(new kembaliListener());
        theview.setTable(themodel.getTableModel());
    }

    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            c_menuUtamaPetani con = new c_menuUtamaPetani();
        }
    }

    private class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = theview.getSelectedRow();
                String idpetani = theview.getValueAt(baris, 0);
                System.out.println(idpetani);
                themodel.delete(idpetani);
                theview.setTable(themodel.getTableModel());
                clear();
            } catch (SQLException ex) {
                Logger.getLogger(c_hapuspetani.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void clear() {
        view.setId("");
        view.setMana("");
        view.setTempat("");
        view.setAlamat("");
    }
}

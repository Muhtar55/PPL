/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.m_lihatpetani;
import model.m_petani;
import view.v_lihatpetani;

/**
 *
 * @author Muhtar
 */
public class c_lihatpetani {

    v_lihatpetani theview = new v_lihatpetani();
    m_petani themodel;

    public c_lihatpetani() throws SQLException {
        this.themodel = new m_petani();
        this.theview = theview;
        theview.setVisible(true);
        theview.addBtnSelesaiListener(new selesaiListener());
        theview.setTable(themodel.getTableModel());
    }

    private class selesaiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theview.dispose();
            c_menuUtamaPetani con = new c_menuUtamaPetani();
        }
    }
}

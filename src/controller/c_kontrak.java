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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_kontrak;
import view.v_kontrak;

/**
 *
 * @author Muhtar
 */
public class c_kontrak {

    m_kontrak themodel;
    v_kontrak theview;
    double bibit;
    double pupuk;
    double target;
    double biji;

    public c_kontrak(v_kontrak theview, m_kontrak themodel) throws SQLException {
        this.themodel = themodel;
        this.theview = theview;
        theview.setVisible(true);
        theview.setIdpetani(themodel.IdPetani());
        theview.setIdlahan(themodel.IdLahan());
        theview.addSaveListener(new saveListener());
        theview.addDeleteListener(new deleteListener());
        theview.addKeluarListener(new keluarListener());
        theview.check(new c_kontrak.check());
        theview.cek(new c_kontrak.cek());
        theview.getLuas(new hitungLuas());
        theview.setTable(themodel.getTableModel());
    }

    private class keluarListener implements ActionListener {

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
                String id = theview.getValueAt(baris, 0);
                System.out.println(id);
                themodel.delete(id);
                theview.text(true);
                theview.button(true);
//                clear();
//             theview.buttonadd(false);
                theview.setTable(themodel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_kontrak.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                if (theview.getNama().isEmpty() || theview.getLahan().isEmpty()) {
                    JOptionPane.showMessageDialog(theview, "Data Tidak Boleh Kosong");
                }
                themodel.save("NULL," + theview.getIdpetani().getSelectedItem().toString() + ",'" + theview.getNama() + "'," + theview.getIdlahan().getSelectedItem().toString() + ",'" + theview.getLahan() + "'," + theview.getLebar() + "," + theview.getPupuk().getText() + "," + theview.getBibit().getText()+","+ theview.getTarget());
                theview.setTable(themodel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_kontrak.class.getName()).log(Level.SEVERE, null, ex);
            }
            theview.setNama("");
            theview.setLahan("");
            theview.setLuas("");
            theview.getPupuk().setText("");
            theview.getBibit().setText("");
            theview.setTarget("");
        }
    }

    private class hitungLuas implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
//            String regex = "\\d+";
//            if (theview.getLebar().matches(regex)) {
//                bibit = ((Double.valueOf(theview.getLebar()) / 0.13) );
////                theview.getBibit().setText(Double.toString(bibit / 1000));
//                pupuk = ((Double.valueOf(theview.getLebar()) * (2.85) * 100));
//                theview.getPupuk().setText(Double.toString(pupuk));
//            }
        }
    }

    public void hitung() {
//        hitung bibit 
//        hitung pupuk : ZA = (60 kg/ha : 21) x 100 
        bibit = (Double.valueOf(m_kontrak.luas) * 0.9 * 0.013);
        theview.getBibit().setText(Double.toString(bibit / 10));
//        theview.getBibit().setText(String.valueOf(Math.round(bibit)));
        pupuk = ((Double.valueOf(m_kontrak.luas) * 285));
        theview.getPupuk().setText(Double.toString(pupuk / 1000));
        biji = (Double.valueOf(m_kontrak.luas) / 0.13);
        target = (biji - (biji * 0.1)) / 4;
        theview.setTarget(String.valueOf(Math.round(target)));
    }

    private class cek implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            try {
                themodel.coba(Integer.parseInt((String) theview.getIdlahan().getSelectedItem()));
                theview.setLahan(m_kontrak.namalahan);
                theview.setLuas(m_kontrak.luas);
                hitung();
//            theview.setNama(m_kontrak.nama);
            } catch (SQLException ex) {
                Logger.getLogger(c_kontrak.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class check implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            try {
                themodel.status(Integer.parseInt((String) theview.getIdpetani().getSelectedItem()));
                theview.setNama(m_kontrak.mana);
//            theview.setMerek(m_peminjaman.merek);
//            theview.setType(m_peminjaman.type);
            } catch (SQLException ex) {
                Logger.getLogger(c_kontrak.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

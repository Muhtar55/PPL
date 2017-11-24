/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhtar
 */
public class v_petani extends javax.swing.JFrame {

    /**
     * Creates new form v_petani
     */
    public v_petani() {
        initComponents();
    }
    
    public String getAlamat() {
        return alamat.getText();
    }
    
    public String getMana() {
        return mana.getText();
    }
    
    public String getTempat() {
        return tempat.getText();
    }
    
    public String getId() {
        return id.getText();
    }
    
    public void setAlamat(String isi) {
        this.alamat.setText(isi);
    }
    
    public void setId(String isi) {
        this.id.setText(isi);
    }
    
    public void setMana(String isi) {
        this.mana.setText(isi);
    }
    
    public void setTempat(String isi) {
        this.tempat.setText(isi);
    }

//    public int getSelectedRow() {
//        return table.getSelectedRow();
//    }
//
//    public void setTable(DefaultTableModel table) {
//        this.table.setModel(table);
//    }
//
//    public String getValueAt(int baris, int kolom) {
//        return (String) this.table.getValueAt(baris, kolom);
//    }
    public void addBtnSimpanListener(ActionListener e) {
        this.btn_simpan.addActionListener(e);
    }

    public void addBtnKembaliListener(ActionListener e) {
        this.btn_kembali.addActionListener(e);
    }

    public void text(boolean status) {
        this.mana.setEnabled(status);
        this.tempat.setEnabled(status);
        this.alamat.setEnabled(status);
        
    }
    
    public void button(boolean status) {
        this.btn_simpan.setEnabled(status);
    }

//    public void buttonsave(boolean status) {
//        this.btn_simpan.setEnabled(status);
//    }
//    public void addBtnKeluarListener(ActionListener e) {
//        this.btn_keluar.addActionListener(e);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        btn_keluar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ttl = new javax.swing.JTextArea();
        domisilin = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        jenis = new javax.swing.JComboBox<>();
        idpetani = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mana = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tempat = new javax.swing.JTextArea();
        alamat = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_kembali = new javax.swing.JButton();
        belakang = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_keluar.setText("Logout");

        jLabel2.setText("Form Petani");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Id_Petani");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Jenis Kelamin");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("TTL");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Domisilin");

        ttl.setColumns(20);
        ttl.setRows(5);
        jScrollPane1.setViewportView(ttl);

        btn_save.setText("Save");

        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Laki-laki", "Perempuan" }));

        idpetani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpetaniActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel6)
                .addGap(95, 95, 95)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel7))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(btn_save))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(idpetani, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(btn_keluar))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(domisilin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(176, 176, 176)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addComponent(btn_save))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(idpetani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel5))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel3))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel4))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_keluar))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(domisilin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mana.setBorder(null);
        mana.setOpaque(false);
        mana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manaActionPerformed(evt);
            }
        });
        getContentPane().add(mana, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 430, 30));

        tempat.setColumns(20);
        tempat.setRows(5);
        tempat.setBorder(null);
        tempat.setOpaque(false);
        jScrollPane2.setViewportView(tempat);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 430, 30));

        alamat.setBorder(null);
        alamat.setOpaque(false);
        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 420, 30));

        id.setBorder(null);
        id.setEnabled(false);
        id.setOpaque(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 240, -1));

        btn_simpan.setBorder(null);
        btn_simpan.setContentAreaFilled(false);
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 60, 20));

        btn_kembali.setBorder(null);
        btn_kembali.setContentAreaFilled(false);
        getContentPane().add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        belakang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bginput_2.png"))); // NOI18N
        getContentPane().add(belakang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idpetaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpetaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpetaniActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void manaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manaActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_simpanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(v_petani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v_petani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v_petani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v_petani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v_petani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JLabel belakang;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JTextField domisilin;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idpetani;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JTextField mana;
    private javax.swing.JTextField nama;
    private javax.swing.JTextArea tempat;
    private javax.swing.JTextArea ttl;
    // End of variables declaration//GEN-END:variables
}
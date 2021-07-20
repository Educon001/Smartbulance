/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controller.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jdfer
 */
public class IniciarSesión extends javax.swing.JFrame {
    CSistema controlSistema;
    CVentana controlVentana;
    CRegistro controlRegistro;
    
    public IniciarSesión() {
        initComponents();
        controlSistema = new CSistema();
        controlVentana = new CVentana();
        controlRegistro = new CRegistro();
        controlVentana.iniciarVentana(this,"src/imagenes/logo(1).png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSalir = new javax.swing.JButton();
        panelIniciarSesión = new javax.swing.JPanel();
        botonRegistrar = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        botonIniciarSesion = new javax.swing.JButton();
        labelRIF = new javax.swing.JLabel();
        txt8RIF = new javax.swing.JTextField();
        guion = new javax.swing.JLabel();
        txt1RIF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSalir.setBackground(new java.awt.Color(255, 0, 51));
        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        panelIniciarSesión.setBackground(new java.awt.Color(255, 255, 255));

        botonRegistrar.setBackground(new java.awt.Color(153, 204, 255));
        botonRegistrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonRegistrar.setText("Registrar clínica");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N

        botonIniciarSesion.setBackground(new java.awt.Color(153, 204, 255));
        botonIniciarSesion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botonIniciarSesion.setText("Iniciar sesión");
        botonIniciarSesion.setToolTipText("");
        botonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarSesionActionPerformed(evt);
            }
        });

        labelRIF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelRIF.setText("RIF: J-");

        txt8RIF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt8RIF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8RIFFocusLost(evt);
            }
        });
        txt8RIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt8RIFActionPerformed(evt);
            }
        });

        guion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        guion.setText("-");

        txt1RIF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt1RIF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1RIFFocusLost(evt);
            }
        });
        txt1RIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1RIFActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("¿La clínica no está registrada?");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Introduzca la información de la clínica");

        javax.swing.GroupLayout panelIniciarSesiónLayout = new javax.swing.GroupLayout(panelIniciarSesión);
        panelIniciarSesión.setLayout(panelIniciarSesiónLayout);
        panelIniciarSesiónLayout.setHorizontalGroup(
            panelIniciarSesiónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIniciarSesiónLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(panelIniciarSesiónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIniciarSesiónLayout.createSequentialGroup()
                        .addGroup(panelIniciarSesiónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(logo)
                            .addGroup(panelIniciarSesiónLayout.createSequentialGroup()
                                .addComponent(labelRIF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt8RIF, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt1RIF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIniciarSesiónLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIniciarSesiónLayout.createSequentialGroup()
                        .addComponent(botonIniciarSesion)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIniciarSesiónLayout.createSequentialGroup()
                        .addGroup(panelIniciarSesiónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIniciarSesiónLayout.createSequentialGroup()
                                .addComponent(botonRegistrar)
                                .addGap(19, 19, 19))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(127, 127, 127))))
        );
        panelIniciarSesiónLayout.setVerticalGroup(
            panelIniciarSesiónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIniciarSesiónLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(panelIniciarSesiónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRIF)
                    .addComponent(txt8RIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guion)
                    .addComponent(txt1RIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonIniciarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(botonRegistrar)
                .addGap(51, 51, 51))
        );

        getContentPane().add(panelIniciarSesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 500, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, 0, 780, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        // TODO add your handling code here:
        txt8RIF.setText(null);
        txt1RIF.setText(null);
        PantallaRegistro pRegistro = new PantallaRegistro(controlSistema,this);
        pRegistro.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void txt8RIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt8RIFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt8RIFActionPerformed

    private void txt8RIFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8RIFFocusLost
        // TODO add your handling code here:
        if(controlRegistro.validarRIF(txt8RIF, 8)==false) txt8RIF.setText(null);
    }//GEN-LAST:event_txt8RIFFocusLost

    private void txt1RIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1RIFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1RIFActionPerformed

    private void txt1RIFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1RIFFocusLost
        // TODO add your handling code here:
        if(controlRegistro.validarRIF(txt1RIF, 1)==false) txt1RIF.setText(null);
    }//GEN-LAST:event_txt1RIFFocusLost

    private void botonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarSesionActionPerformed
        // TODO add your handling code here:
        String RIF = controlRegistro.construirRIF(txt8RIF,txt1RIF);
        if(controlSistema.seEncuentraRegistrada_RIF(RIF,true)){
            CClinica controlClinica = new CClinica(controlSistema.buscarClinica(RIF));
            MenúPrincipal menuPrincipal = new MenúPrincipal(controlSistema,controlClinica,this);
            setVisible(false);
            menuPrincipal.setVisible(true);
        }
        txt8RIF.setText(null); txt1RIF.setText(null);
    }//GEN-LAST:event_botonIniciarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(IniciarSesión.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesión.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesión.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesión.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesión().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel guion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelRIF;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelIniciarSesión;
    private javax.swing.JTextField txt1RIF;
    private javax.swing.JTextField txt8RIF;
    // End of variables declaration//GEN-END:variables
}

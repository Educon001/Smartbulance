
package Vista;

import Controller.*;
import Modelo.*;
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.*;
import javax.swing.*;

public class PantallaRegistroMov extends javax.swing.JFrame {
    Suministro sum;
    CSistema conSistema;
    CInventario con; //= new CInventario(new Ambulatorio());
    DefaultListModel modeloLista = new DefaultListModel();
    MenúPrincipal ventanaAnterior;
    CVentana controlVentana = new CVentana(this);
    
    public PantallaRegistroMov() {
        initComponents();
        /*sum = new Suministro();
        Unidad uni1 = new Unidad("Almacen","26/07/2021");
        Unidad uni2 = new Unidad("Ambulancia 1","04/09/2021");
        sum.getUnidades().add(uni1);
        sum.getUnidades().add(uni2);
        con.mostrarUnidades(tablaUnidades, tituloTabla, sum);
        listaObjetos.setModel(modeloLista);
        listaObjetos.addMouseListener(new EventoMouse(btnEliminar));
        conSistema = new CSistema();
        conSistema.setListaEmergencias(new ArrayList<Emergencia>());
        Emergencia em = new Emergencia();
        conSistema.agregarEmergencia(em);*/
    }
    
    public PantallaRegistroMov(Suministro sum, CInventario con, CSistema conSistema,MenúPrincipal ventanaAnterior) {
        initComponents();
        this.con = con;
        this.conSistema = conSistema;
        this.sum = sum;
        this.ventanaAnterior = ventanaAnterior;
        con.mostrarUnidades(tablaUnidades, tituloTabla, sum);
        listaObjetos.setModel(modeloLista);
        listaObjetos.addMouseListener(new EventoMouse(btnEliminar));
        controlVentana.iniciarVentana(this,"src/imagenes/logo(1).png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUnidades = new javax.swing.JTable();
        tituloTabla = new javax.swing.JLabel();
        panelMovimientos = new javax.swing.JPanel();
        label1Movimientos = new javax.swing.JLabel();
        tipoMovimiento = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        label2Movimientos = new javax.swing.JLabel();
        txtNEmergenciaArgumento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaObjetos = new javax.swing.JList<>();
        combo1Movimientos = new javax.swing.JComboBox<>();
        calendario = new com.toedter.calendar.JDateChooser();
        btnSeleccionarUni = new javax.swing.JButton();
        botonGuardarCambios = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaUnidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablaUnidades.setRowHeight(25);
        tablaUnidades.getTableHeader().setReorderingAllowed(false);
        tablaUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUnidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUnidades);
        tablaUnidades.setEnabled(false);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 540, 170));

        tituloTabla.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tituloTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloTabla.setText("Titulo tabla");
        getContentPane().add(tituloTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 330, 190, 32));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);

        panelMovimientos.setBackground(new java.awt.Color(255, 255, 255));
        panelMovimientos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1Movimientos.setText("Vencimiento:");
        panelMovimientos.add(label1Movimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 140, 28));

        tipoMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Salida", "Reubicacion" }));
        tipoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoMovimientoActionPerformed(evt);
            }
        });
        panelMovimientos.add(tipoMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 134, 32));

        btnEliminar.setText("Eliminar ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelMovimientos.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 90, -1));
        btnEliminar.setVisible(false);
        btnEliminar.setEnabled(false);

        jLabel2.setText("Tipo de movimiento:");
        panelMovimientos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        label2Movimientos.setText("Cantidad:");
        panelMovimientos.add(label2Movimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 80, 30));

        txtNEmergenciaArgumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNEmergenciaArgumentoFocusLost(evt);
            }
        });
        panelMovimientos.add(txtNEmergenciaArgumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 220, -1));
        txtNEmergenciaArgumento.setVisible(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Registrar movimientos");
        panelMovimientos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 320, 50));

        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        panelMovimientos.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 40, -1));

        jScrollPane2.setViewportView(listaObjetos);
        listaObjetos.setVisible(false);
        listaObjetos.setEnabled(true);

        panelMovimientos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 60, 80));
        jScrollPane2.setVisible(false);

        combo1Movimientos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aplica", "No aplica" }));
        combo1Movimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1MovimientosActionPerformed(evt);
            }
        });
        panelMovimientos.add(combo1Movimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 130, -1));

        calendario.setDateFormatString("dd/MM/yyyy");
        calendario.setMinSelectableDate(calendar.getTime()
        );
        panelMovimientos.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 215, -1));
        JTextFieldDateEditor editor = (JTextFieldDateEditor) calendario.getDateEditor();
        editor.setEditable(false);

        btnSeleccionarUni.setText("Seleccionar Unidad");
        btnSeleccionarUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarUniActionPerformed(evt);
            }
        });
        panelMovimientos.add(btnSeleccionarUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 151, 41));
        btnSeleccionarUni.setEnabled(false);

        botonGuardarCambios.setBackground(new java.awt.Color(153, 204, 255));
        botonGuardarCambios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonGuardarCambios.setText("Registrar movimiento");
        botonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarCambiosActionPerformed(evt);
            }
        });
        panelMovimientos.add(botonGuardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, -1, -1));

        botonSalir.setBackground(new java.awt.Color(255, 0, 0));
        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        panelMovimientos.add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 28, 120, 50));

        getContentPane().add(panelMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 820, 610));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoMovimientoActionPerformed
        switch (tipoMovimiento.getSelectedIndex()){
            case 0: //Entrada
                con.tipoMovimientoEntrada(tablaUnidades, btnSeleccionarUni, label1Movimientos, calendario, combo1Movimientos, txtNEmergenciaArgumento, label2Movimientos, txtCantidad, listaObjetos, jScrollPane2, btnEliminar);
            break;
            
            case 1: //Salida
                con.tipoMovimientoSalida(tablaUnidades, btnSeleccionarUni, label1Movimientos, calendario, combo1Movimientos, txtNEmergenciaArgumento, label2Movimientos, txtCantidad, listaObjetos, jScrollPane2, btnEliminar);
                modeloLista.removeAllElements();
            break;
            
            case 2: //Reubicación
                con.tipoMovimientoReubicacion(tablaUnidades, btnSeleccionarUni, label1Movimientos, calendario, combo1Movimientos, txtNEmergenciaArgumento, label2Movimientos, txtCantidad, listaObjetos, jScrollPane2, btnEliminar);
                modeloLista.removeAllElements();
            break;
        }
    }//GEN-LAST:event_tipoMovimientoActionPerformed

    private void btnSeleccionarUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarUniActionPerformed
        con.agregarUnidad(tablaUnidades, modeloLista, listaObjetos, btnEliminar, tipoMovimiento);
    }//GEN-LAST:event_btnSeleccionarUniActionPerformed

    private void combo1MovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1MovimientosActionPerformed
        try{
        switch(combo1Movimientos.getSelectedItem().toString()) {
            case "Aplica":
                calendario.setEnabled(true);
            break;
            
            case "No aplica":
                calendario.setEnabled(false);
                calendario.setDate(null);
            break;
            
            case "Emergencia Nro:":
                txtNEmergenciaArgumento.setVisible(true);
            break;
            
            case "Otro:":
                txtNEmergenciaArgumento.setVisible(true);
            break;
            
            default:
                txtNEmergenciaArgumento.setVisible(false);
                txtNEmergenciaArgumento.setText(null);
            break;
        }
        }catch (NullPointerException ex){}
    }//GEN-LAST:event_combo1MovimientosActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        con.eliminarUnidad(listaObjetos, modeloLista,btnEliminar);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUnidadesMouseClicked
        btnSeleccionarUni.setEnabled(true);
    }//GEN-LAST:event_tablaUnidadesMouseClicked

    private void txtNEmergenciaArgumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNEmergenciaArgumentoFocusLost
        if (combo1Movimientos.getSelectedIndex()==1)
            con.validarEmergencia(conSistema, txtNEmergenciaArgumento);
    }//GEN-LAST:event_txtNEmergenciaArgumentoFocusLost

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        con.validarCantidad(txtCantidad);
    }//GEN-LAST:event_txtCantidadFocusLost

    private void botonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCambiosActionPerformed
        try{
        switch (tipoMovimiento.getSelectedIndex()){
            case 0:
                con.registrarEntrada(combo1Movimientos.getSelectedItem().toString(), calendario.getDate(), Integer.parseInt(txtCantidad.getText()), sum);
                calendario.setDate(null);
                txtCantidad.setText(null);
                con.mostrarUnidades(tablaUnidades, tituloTabla, sum);
            break;
            
            case 1:
                con.registrarSalida(combo1Movimientos.getSelectedItem().toString(), txtNEmergenciaArgumento.getText(), modeloLista.toArray(), sum, tablaUnidades);
                txtNEmergenciaArgumento.setText(null);
                modeloLista.removeAllElements();
                con.mostrarUnidades(tablaUnidades, tituloTabla, sum);
            break;
            
            case 2:
                con.registrarReubicacion(combo1Movimientos.getSelectedItem().toString(), modeloLista.toArray(), sum, tablaUnidades);
                modeloLista.removeAllElements();
                con.mostrarUnidades(tablaUnidades, tituloTabla, sum);
            break;
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonGuardarCambiosActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
        ventanaAnterior.setVisible(true);
    }//GEN-LAST:event_botonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaRegistroMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaRegistroMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaRegistroMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaRegistroMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRegistroMov().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSeleccionarUni;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JComboBox<String> combo1Movimientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1Movimientos;
    private javax.swing.JLabel label2Movimientos;
    private javax.swing.JList<String> listaObjetos;
    private javax.swing.JPanel panelMovimientos;
    private javax.swing.JTable tablaUnidades;
    private javax.swing.JComboBox<String> tipoMovimiento;
    private javax.swing.JLabel tituloTabla;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNEmergenciaArgumento;
    // End of variables declaration//GEN-END:variables
}

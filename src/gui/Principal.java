/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acciones.MovimientoAcciones;
import clases.MovimientoClass;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JEANG
 */
public class Principal extends javax.swing.JFrame {
    
    
    
    ArrayList <MovimientoVisualizar> tareasList = new ArrayList<>(); 
  
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        gestionButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tareasPanel = new javax.swing.JPanel();
        historialButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tareas_pendientes");
        setSize(new java.awt.Dimension(500, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Control Financiero");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        gestionButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        gestionButton.setIcon(new javax.swing.ImageIcon("F:\\Programas\\SQLITE\\MovimientosF\\Imagenes\\3.jpg")); // NOI18N
        gestionButton.setText("Gestion de movimientos ");
        gestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(gestionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 92, -1, 50));

        consultarButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        consultarButton.setIcon(new javax.swing.ImageIcon("F:\\Programas\\SQLITE\\MovimientosF\\Imagenes\\descarga (2).png")); // NOI18N
        consultarButton.setText("Consultar balance");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(consultarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 184, 209, 50));

        tareasPanel.setLayout(new javax.swing.BoxLayout(tareasPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(tareasPanel);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, 365, 284));

        historialButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        historialButton1.setIcon(new javax.swing.ImageIcon("F:\\Programas\\SQLITE\\MovimientosF\\Imagenes\\descarga.png")); // NOI18N
        historialButton1.setText("Estado de mis finanzas");
        historialButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(historialButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 210, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionButtonActionPerformed
        CrearMovimiento.mostrar();
    }//GEN-LAST:event_gestionButtonActionPerformed

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        Historial.obtenInstancia().mostrar();
    }//GEN-LAST:event_consultarButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTareas();
    }//GEN-LAST:event_formWindowOpened

    private void historialButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_historialButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultarButton;
    private javax.swing.JButton gestionButton;
    private javax.swing.JButton historialButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel tareasPanel;
    // End of variables declaration//GEN-END:variables

    void agregarTarea(MovimientoClass tareaClass) {
        MovimientoVisualizar tareaVisualizar = new MovimientoVisualizar(tareaClass);
        tareasList.add(tareaVisualizar);
        tareasPanel.add(tareaVisualizar);
        validate();
        requestFocus();
        
    }

    private void cargarTareas() {
        try {
            ArrayList<MovimientoClass> tareas = MovimientoAcciones.obtenerTareas();
            tareasList.clear();
            tareasPanel.removeAll();
            for(MovimientoClass tarea : tareas){
                MovimientoVisualizar tareaVisualizar = new MovimientoVisualizar(tarea);
                tareasList.add(tareaVisualizar);
                tareasPanel.add(tareaVisualizar);
            }
            validate();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void eliminarTarea(MovimientoVisualizar tarea) {
        tareasList.remove(tarea);
        tareasPanel.remove(tarea);
        validate();
    }
}
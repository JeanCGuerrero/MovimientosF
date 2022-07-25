/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acciones.MovimientoAcciones;
import clases.MovimientoClass;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JEANG
 */
public class MovimientoVisualizar extends Movimiento {
    
    final MovimientoClass movimientoClass;
    
    public MovimientoVisualizar(MovimientoClass movimientoClass){
        this.movimientoClass = movimientoClass;
        conceptoText.setEditable(false);
        conceptoText.setText(movimientoClass.concepto);                
        fechaSpinner.setEnabled(false);
        fechaSpinner.setValue(new Date(movimientoClass.fecha));
        montoText.setEditable(false);
        montoText.setText(movimientoClass.monto);  
        descripcionText.setEditable(false);
        descripcionText.setText(movimientoClass.descripcion);
        eliminarButton.setVisible(true);
        historiallButton.setVisible(true);
    }

    @Override
    void eliminar() {
        try {
            MovimientoAcciones.eliminarTarea(movimientoClass);
            movimientos.movimientos.principal.eliminarTarea(this);
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoVisualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    void marcar() {
        try {
            MovimientoAcciones.finalizarTarea(movimientoClass);
            movimientos.movimientos.principal.eliminarTarea(this);
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoVisualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
} 
 

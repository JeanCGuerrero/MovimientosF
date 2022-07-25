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
public class MovimientoHistorial extends Movimiento {
    
    final MovimientoClass movimientoClass;
    
    public MovimientoHistorial(MovimientoClass movimientoClass){
        this.movimientoClass = movimientoClass;
        conceptoText.setEditable(false);
        conceptoText.setText(movimientoClass.concepto);                
        fechaSpinner.setEnabled(false);
        fechaSpinner.setValue(new Date(movimientoClass.fecha));
        montoText.setEnabled(false); 
        montoText.setText(movimientoClass.monto);        
        descripcionText.setEnabled(false);       
        descripcionText.setText(movimientoClass.descripcion);       
        eliminarButton.setVisible(false);        
        historiallButton.setVisible(true);
        historiallButton.setText("Excluir del Historial");
     }

    @Override
    void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void marcar() {
         try {
            MovimientoAcciones.reactivarTarea(movimientoClass);
            Historial.obtenInstancia().eliminarTarea(this);
            movimientos.movimientos.principal.agregarTarea(movimientoClass);
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoHistorial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}



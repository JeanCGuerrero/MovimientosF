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
    
    final MovimientoClass tareaClass;
    
    public MovimientoHistorial(MovimientoClass tareaClass){
        this.tareaClass = tareaClass;
        conceptoText.setEditable(false);
        conceptoText.setText(tareaClass.concepto);                
        fechaSpinner.setEnabled(false);
        fechaSpinner.setValue(new Date(tareaClass.fecha));
        montoText.setEnabled(false); 
        montoText.setText(tareaClass.monto);        
        descripcionText.setEnabled(false);       
        descripcionText.setText(tareaClass.descripcion);       
        eliminarButton.setVisible(false);        
        historiallButton.setVisible(true); //**********BORRAR**********////////////
        historiallButton.setText("Reactivar"); //**********BORRAR**********////////////
     }

    @Override
    void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void marcar() {
         try {
            MovimientoAcciones.reactivarTarea(tareaClass);
            Historial.obtenInstancia().eliminarTarea(this);
            movimientos.movimientos.principal.agregarTarea(tareaClass);
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoHistorial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    }



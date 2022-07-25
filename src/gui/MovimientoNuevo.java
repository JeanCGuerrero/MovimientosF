/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import clases.MovimientoClass;
import java.util.Date;

/**
 *
 * @author JEANG
 */
public class MovimientoNuevo extends Movimiento {
    
    public MovimientoNuevo(){
        conceptoText.setEnabled(true);
        conceptoText.setText("");                
        fechaSpinner.setEnabled(true);
        montoText.setEnabled(true);
        montoText.setText("");
        descripcionText.setEnabled(true);
        descripcionText.setText(""); 
        eliminarButton.setVisible(false);
        historiallButton.setVisible(false);
    }
    
    MovimientoClass getTareaClass(){
        Date fecha = (Date) fechaSpinner.getValue();
        String concepto =  conceptoText.getText();            
        String monto =  montoText.getText();
        String descripcion =  descripcionText.getText();            
        MovimientoClass movimientoClass = new MovimientoClass(concepto, fecha.getTime(),  monto, descripcion);
        return movimientoClass;
    }   

    @Override
    void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void marcar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 

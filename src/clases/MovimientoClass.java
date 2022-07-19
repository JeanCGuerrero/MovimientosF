/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author JEANG
 */
public class MovimientoClass {
    long movimientoID; 
    public final String concepto;
    public final long fecha;  
    public final String monto; 
    public final String descripcion;
    
    public MovimientoClass(String concepto, long fecha, String monto, String descripcion) {
        this.concepto = concepto; 
        this.fecha = fecha;
        this.monto = monto; 
        this.descripcion = descripcion;         
    }

    public MovimientoClass(long movimientoID, String concepto, long fecha, String monto, String descripcion) {
        this.movimientoID = movimientoID;
        this.concepto = concepto; 
        this.fecha = fecha;
        this.monto = monto; 
        this.descripcion = descripcion; 
    }
    
    public void setID(long tareaID){
    this.movimientoID = tareaID;
}
    public long getID(){
    return movimientoID;
}
    
    
}

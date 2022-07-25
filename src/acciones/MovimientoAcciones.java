/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import clases.MovimientoClass;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author JEANG
 */
public class MovimientoAcciones {
    public static void guardarTarea(MovimientoClass movimientoClass) throws SQLException{
        long id = insertarTarea(movimientoClass);
        movimientoClass.setID(id);
    }
       

    static private long insertarTarea(MovimientoClass movimientoClass) throws SQLException {
        String sql = "insert into movimientos (concepto, fecha, monto, descripcion) "
                + "values (?,?,?,?);";
        PreparedStatement ps = Conexion.PepareStatement(sql); 
        ps.setString(1, movimientoClass.concepto);        
        ps.setLong(2, movimientoClass.fecha);
        ps.setString(3, movimientoClass.monto);        
        ps.setString(4, movimientoClass.descripcion);        
        int id=0;
        ps.execute();
        sql = "select last_insert_rowid();";
        ps = Conexion.PepareStatement(sql, true);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            id = rs.getInt(1);
        }
        return id;
    }

    public static ArrayList<MovimientoClass> obtenerTareas() throws SQLException {
        String sql = "select movimiento_id, concepto, fecha, monto, descripcion from movimientos order by fecha";
        PreparedStatement ps = Conexion.PepareStatement(sql);
        ArrayList<MovimientoClass> list = new ArrayList<>();
        try(ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                long id = rs.getLong("movimiento_id");
                String concepto = rs.getString("concepto");
                long fecha = rs.getLong("fecha");
                String monto = rs.getString("monto");
                String descripcion = rs.getString("descripcion");                
                MovimientoClass movimientoClass = new MovimientoClass(id, concepto, fecha,  monto, descripcion);
                list.add(movimientoClass);
            }
        }
        return list;
    }

    public static void eliminarTarea(MovimientoClass movimientoClass) throws SQLException{
        String sql = "delete from movimientos where movimiento_id=?";
        PreparedStatement ps = Conexion.PepareStatement(sql);
        ps.setLong(1, movimientoClass.getID());
        ps.execute();
    }

    public static void finalizarTarea(MovimientoClass movimientoClass) throws SQLException {
        insertarTareaHistorial(movimientoClass);
        eliminarTarea(movimientoClass);
    }

    private static void insertarTareaHistorial(MovimientoClass movimientoClass) throws SQLException {
        String sql = "insert into historial (movimiento_id, concepto, fecha,  monto, descripcion) "
                + "values (?,?,?,?,?);";
        PreparedStatement ps = Conexion.PepareStatement(sql);
        ps.setLong(1, movimientoClass.getID());
        ps.setString(2, movimientoClass.concepto);        
        ps.setLong(3, movimientoClass.fecha);   
        ps.setString(4, movimientoClass.monto);        
        ps.setString(5, movimientoClass.descripcion);         
        int id=0;
        ps.execute();
    }

    public static ArrayList<MovimientoClass> obtenerTareasHistoricas() throws SQLException {
        String sql = "select movimiento_id, concepto, fecha,  monto, descripcion from historial order by fecha desc";
        PreparedStatement ps = Conexion.PepareStatement(sql);
        ArrayList<MovimientoClass> list = new ArrayList<>();
        try(ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                long id = rs.getLong("movimiento_id");
                String concepto = rs.getString("concepto");
                long fecha = rs.getLong("fecha");                
                String monto = rs.getString("monto");
                String descripcion = rs.getString("descripcion");
                MovimientoClass movimientoClass = new MovimientoClass(id, concepto, fecha,  monto, descripcion);
                list.add(movimientoClass);
            }
        }
        return list;
}

    public static void reactivarTarea(MovimientoClass movimientoClass) throws SQLException {
        insertarTarea(movimientoClass); 
        eliminarTareaHistorial(movimientoClass);
    }

    private static void eliminarTareaHistorial(MovimientoClass movimientoClass) throws SQLException {
        String sql = "delete from historial where movimiento_id=?";
        PreparedStatement ps = Conexion.PepareStatement(sql);
        ps.setLong(1, movimientoClass.getID());
        ps.execute();
    } 
}

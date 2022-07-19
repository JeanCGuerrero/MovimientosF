package acciones;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
	private static Connection connection;
	public final static Conexion instancia = new Conexion();       
        
        public static PreparedStatement PepareStatement(String sql) throws SQLException{
	return connection.prepareStatement(sql);
}
	public static void cerrar() throws SQLException{
	connection.close();
}       
	public static PreparedStatement PepareStatement(String sql, boolean b) throws SQLException{
	return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
}	
	private Conexion(){
            String cadena = "jdbc:sqlite:F:/Programas/SQLITE/MovimientosF/movimientos.db";
		try{
			connection = DriverManager.getConnection(cadena);
		} catch (SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

		}
	}   
}
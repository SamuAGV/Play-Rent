
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SamuelGarduno
 * Para PHPMYADMIN LOCAL
 * "jdbc:mysql://localhost:3306/seminario","root",""
 * 
 * Para Conectarse Al Servidor Del Seminario Del Cecytem
 * "jdbc:mysql://52.90.30.165/seminario","alumno","Alumno2023+"
 */
public class Conexion {
     Connection con;
    
    public Conexion(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seminario","root","");
            //JOptionPane.showMessageDialog(null,"La conexión se ha realizado con éxito");
        }
        catch (SQLException e){
            System.err.print(e.toString());
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }        
    }
     

    public Connection getConeccetion() {
    return con;
    }

}

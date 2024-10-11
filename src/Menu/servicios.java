
package Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author samuelgarduno
 */
public class servicios {
     static final String URL = "jdbc:mysql://localhost:3306/play&rent";
    static final String USUARIO = "root";
    static final String CONTRASENA = "";
    

        /*
    static class Servicios {

        private String nombre;
        private String tipo;
        private String asesoria;
        private String rapidez;
        private String disponibilidad;
        
        
        public Servicios(String nombre, String tipo, String asesoria, String rapidez, String disponibilidad) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.asesoria = asesoria;
            this.rapidez = rapidez;
            this.disponibilidad = disponibilidad; 
                
        }

        public String getNombre() {
            return nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public String getAsesoria() {
            return asesoria;
        }
        public String getRapidez() {
            return rapidez;
        }
        public String getDisponibilidad() {
            return disponibilidad;
        }
    }
    */
//Mostra el menu de opciones para cliente
public class menuser{
    public static void main(String[] args) {
        
        Scanner opc = new Scanner(System.in);
         boolean salirs = false;//Para cerrar el menu
        while (!salirs) {
            System.out.println("\nMenú para Servicios:");
            //System.out.println("1. Insertar al cliente");
            System.out.println("1. Ver todos los servicios");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = opc.nextInt();
            opc.nextLine(); // Limpiar el scanner
            
            switch (opcion) {
                /*case 1:
                    //insertarCliente(opc);
                    break;*/
                case 1:
                    verTodosLosServicios();
                    break;
                case 2:
                    System.out.println("\nSaliendo de los servicios\n");
                    //opc.close();
                    //System.exit(0);
                    salirs= true;
                    break;
                default:
                    System.out.println("\nOpción no válida.\n");
            }
        }
    }
}
/*
//Pedir datos para poder insertar los clientes
    public static void insertarCliente(Scanner op1) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = op1.nextLine();

        System.out.println("Ingrese la fecha de nacimiento del cliente:");
        String fecha = op1.nextLine();

        System.out.println("Ingrese el correo del cliente:");
        String correo = op1.nextLine();
        op1.nextLine(); // Limpiar el buffer del scanner

        Cliente cliente = new Cliente(nombre, fecha, correo);
        insertarEnBD(cliente);
    }
*/

    //insertar las opciones que pidio el cliente a la BD 

/*
    public static void insertarEnBD(Cliente cliente) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "INSERT INTO clientes (nombre, fecha, correo) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getFecha());
            pstmt.setString(3, cliente.getCorreo());
            pstmt.executeUpdate();

            System.out.println("\nSe ha insertado el cliente en la base de datos.\n");
        } catch (SQLException e) {
        }
    }
    */

    
        //Ver Todos los clientes en la BD 
    public static void verTodosLosServicios() {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Servicios";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String rapidez = rs.getString("rapidez");
                String disponibilidad = rs.getString("disponibilidad");
                String precio = rs.getString("precio");            
                System.out.println("___________________________________________________________________________________");
                System.out.println("\nID: " + id +"\nNombre: " + nombre + "\nTipo: " + tipo +
                        "\nRapidez:"+rapidez+"\nDisponibilidad"+disponibilidad+"\nPrecio"+"\n");
                System.out.println("___________________________________________________________________________________");
            }
        } catch (SQLException e) {
        }
    }
}



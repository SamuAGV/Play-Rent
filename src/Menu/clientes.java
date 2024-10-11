
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
public class clientes {
    static final String URL = "jdbc:mysql://localhost:3306/play&rent";
    static final String USUARIO = "root";
    static final String CONTRASENA = "";
    

        
    static class Cliente {
        private String id;
        private String nombre;
        private String fecha;
        private String correo;
        
        
    public Cliente(String id,String nombre, String fecha, String correo) {

            this.id = id;
            this.nombre = nombre;
            this.fecha = fecha;
            this.correo = correo;
        }
        public String getId() {
            return id;
        }
        public String getNombre() {
            return nombre;
        }

        public String getFecha() {
            return fecha;
        }

        public String getCorreo() {
            return correo;
        }
    }
    
//Mostra el menu de opciones para cliente
public class menucli{
    public static void main(String[] args) {
        
        Scanner opc = new Scanner(System.in);
         boolean salirc = false;//Para cerrar el menu
        while (!salirc) {
            System.out.println("\nMenú para Clientes:");
            System.out.println("1. Insertar al cliente");
            System.out.println("2. Ver todos los clientes");
            System.out.println("3. Eliminar Clientes");
            System.out.println("4. Modificar Clientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int ops = opc.nextInt();
            opc.nextLine(); // Limpiar el scanner
            
            switch (ops) {
                case 1:
                    insertarCliente(opc);
                    break;
                case 2:
                    verTodosLosClientes();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    actualizarCliente();
                    break;
                case 5:
                    System.out.println("\nSaliendo del menu Clientes\n");
                    //opc.close();
                    //System.exit(0);
                    salirc= true;
                    break;
                default:
                    System.out.println("\nOpción no válida.\n");
            }
        }
    }
}

//Pedir datos para poder insertar los clientes
    public static void insertarCliente(Scanner op1) {
        System.out.println("Ingrese el ID del cliente:");
        String id = op1.nextLine();
        
        System.out.println("Ingrese el Nombre del cliente:");
        String nombre = op1.nextLine();

        System.out.println("Ingrese la Fehca de nacimiento del cliente:");
        String fecha = op1.nextLine();

        System.out.println("Ingrese el Correo del cliente:");
        String correo = op1.nextLine();
        op1.nextLine(); // Limpiar el buffer del scanner

        Cliente cliente = new Cliente(id,nombre, fecha, correo);
        id="";
        nombre="";
        fecha="";
        correo="";
        
        insertarEnBD(cliente);//llenado e imprsion de objeto
        System.out.println("El ID es: "+cliente.id+"\nEl Nombre Del Cliente es: "+cliente.nombre+
                "\nSu fecha nacimiento es el: "+cliente.fecha+"\nEl correo del cliente es:"+cliente.correo);
        
    }

    //insertar las opciones que pidio el cliente a la BD 
    public static void insertarEnBD(Cliente cliente) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "INSERT INTO clientes (id, nombre, fecha, correo) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cliente.getId());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getFecha());
            pstmt.setString(4, cliente.getCorreo());
            pstmt.executeUpdate();

            System.out.println("Se ha insertado el cliente en la base de datos.\n");
        } catch (SQLException e) {
        }
    }

    
        //Ver Todos los clientes en la BD 
    public static void verTodosLosClientes() {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM clientes";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String fecha = rs.getString("fecha");
                String correo = rs.getString("correo");
                System.out.println("___________________________________________________________________________________");
                System.out.println("\nID: " + id +"\nNombre: " + nombre + "\nfecha: " + fecha + "\nCorreo: " + correo+"\n");
                System.out.println("___________________________________________________________________________________");
            }
        } catch (SQLException e) {
        }
        
    }
    
    public static void eliminarCliente() {
    Scanner op1 = new Scanner (System.in)  ;  
    System.out.println("Ingrese el ID del cliente que desea eliminar:");
    int idCliente = op1.nextInt();
    op1.nextLine(); // Limpiar el scanner

    try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
         PreparedStatement pstmt = conn.prepareStatement("DELETE FROM clientes WHERE id = ?")) {
        pstmt.setInt(1, idCliente);
        int rowsAffected = pstmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Se ha eliminado el cliente de la base de datos.");
        } else {
            System.out.println("No se encontró ningún cliente con el ID proporcionado.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
public static void actualizarCliente() {
    Scanner op1 = new Scanner (System.in)  ;  
    System.out.println("Ingrese el ID del cliente que desea actualizar:");
    int idCliente = op1.nextInt();
    op1.nextLine(); // Limpiar el scanner
    
    System.out.println("Ingrese el Nuevo Nombre del cliente:");
    String nuevoNombre = op1.nextLine();

    System.out.println("Ingrese la Nueva Fecha de nacimiento del cliente:");
    String nuevaFecha = op1.nextLine();

    System.out.println("Ingrese el Nuevo Correo del cliente:");
    String nuevoCorreo = op1.nextLine();

    try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
         PreparedStatement pstmt = conn.prepareStatement("UPDATE clientes SET nombre = ?, fecha = ?, correo = ? WHERE id = ?")) {
        pstmt.setString(1, nuevoNombre);
        pstmt.setString(2, nuevaFecha);
        pstmt.setString(3, nuevoCorreo);
        pstmt.setInt(4, idCliente);
        
        int rowsAffected = pstmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Se ha actualizado el cliente en la base de datos.");
        } else {
            System.out.println("No se encontró ningún cliente con el ID proporcionado.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
}



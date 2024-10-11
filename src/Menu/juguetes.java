package Menu;

import java.sql.*;
import java.util.Scanner;

public class juguetes {
    static final String URL = "jdbc:mysql://localhost:3306/play&rent";
    static final String USUARIO = "root";
    static final String CONTRASENA = "";

    static class Juguete {
        private String nombre;
        private String categoria;
        private String precio;

        public  Juguete(String nombre, String categoria, String precio) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCategoria() {
            return categoria;
        }

        public String getPrecio() {
            return precio;
        }

    }
public class menujug{
    public static void main(String[] args) {
        Scanner op = new Scanner(System.in);
        boolean salirj = false;
        while (!salirj) {
            System.out.println("\nMenú para Juguetes:");
            System.out.println("1. Insertar juguete");
            System.out.println("2. Ver todos los juguetes");            
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int ops = op.nextInt();
            op.nextLine(); // Limpiar elscanner
            
            switch (ops) {
                case 1:
                    insertarJuguete(op);
                    break;
                case 2:
                    verTodosLosJuguetes();
                    break;
                case 3:
                    System.out.println("\nSaliendo del menu Juguetes...\n");
                   //op.close();
                    //System.exit(0);
                    salirj= true;
                    break;
                default:
                    System.out.println("\nOpción no válida.\n");
            }
        }
    }
   }   

    public static void SeleccionarJuguete(Scanner op1) {
        System.out.println("Ingrese el nombre del juguete:");
        String nombre = op1.nextLine();

        System.out.println("Ingrese la categoría del juguete:");
        String categoria = op1.nextLine();

        System.out.println("Ingrese el precio del juguete:");
        String precio = op1.nextLine();
        op1.nextLine(); // Limpiar el buffer del scanner

        Juguete juguete = new Juguete(nombre, categoria, precio);
        insertarEnBD(juguete);
    }
    
    public static void insertarJuguete(Scanner op1) {
        System.out.println("Ingrese el nombre del juguete:");
        String nombre = op1.nextLine();

        System.out.println("Ingrese la categoría del juguete:");
        String categoria = op1.nextLine();

        System.out.println("Ingrese el precio del juguete:");
        String precio = op1.nextLine();
        op1.nextLine(); // Limpiar el buffer del scanner

        Juguete juguete = new Juguete(nombre, categoria, precio);
        nombre="";
        categoria="";
        precio="";
        insertarEnBD(juguete);
        System.out.println("Nombre"+juguete.nombre+"\nCategoria"+juguete.categoria+"\nPrecio"+juguete.precio);
    }

    public static void insertarEnBD(Juguete juguete) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "INSERT INTO juguetes (nombre, categoria, precio) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, juguete.getNombre());
            pstmt.setString(2, juguete.getCategoria());
            pstmt.setString(3, juguete.getPrecio());
            pstmt.executeUpdate();

            System.out.println("\nSe ha insertado el juguete en la base de datos.\n");
        } catch (SQLException e) {
        }
    }

    public static void verTodosLosJuguetes() {

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM juguetes";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                System.out.println("___________________________________________________________________________________");
                System.out.println("\nID: " + id +"\nNombre: " + nombre + "\nCategoría: " + categoria + "\nPrecio: " + precio+"\n");
                System.out.println("___________________________________________________________________________________");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
/*
     public static void consulta(){
         Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);
    double sumaProductos = 0;

        try {
            // Paso 1: Registrar el driver JDBC
//            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 2: Establecer la conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/play&rent";
            String usuario = "root";
            String contraseña = "";
            connection = DriverManager.getConnection(url, usuario, contraseña);

            // Paso 3: Crear el statement
            statement = connection.createStatement();

            for (int i = 0; i < 2; i++) { // Solicitar dos veces el ID
                // Solicitar al usuario el valor del ID a buscar
                System.out.print("\nIngrese el ID del producto a buscar: ");
                int idBusqueda = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner

                // Paso 4: Ejecutar la consulta SQL con el ID proporcionado por el usuario
                String sql = "SELECT id, nombre, categoria, precio FROM juguetes WHERE id = " + idBusqueda;
                resultSet = statement.executeQuery(sql);
                // Paso 5: Procesar los resultados de la consulta
                if (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String nombre = resultSet.getString("nombre");
                    String categoria = resultSet.getString("categoria");
                    String precio = resultSet.getString("precio");
                System.out.println("ID: " + id + "\nNombre: " + nombre + "\nCategoria: " + categoria + "\nPrecio: $" + precio);
                    
                } else {
                    System.out.println("No se encontró ningún producto con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
    */
 
}

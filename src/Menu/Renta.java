package Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Renta {
    public static void main(String[] args) {
        // Conexión a la base de datos
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        // Crear un objeto Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        try {
            // Paso 1: Establecer la conexión con la base de datos

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/play&rent", "root", "");

            // Paso 2: Crear una declaración
            stmt = con.createStatement();

            // Paso 3: Obtener los datos de productos
            String consultaProductos = "SELECT * FROM productos";
            rs = stmt.executeQuery(consultaProductos);

            // Mostrar los productos disponibles
            System.out.println("Productos disponibles:");
            while (rs.next()) {
                int idProducto = rs.getInt("id");
                String nombreProducto = rs.getString("nombre");
                double precioProducto = rs.getDouble("precio");
                System.out.println(idProducto + ". " + nombreProducto + " - Precio: $" + precioProducto);
            }

            // Paso 4: Obtener los datos de servicios
            String consultaServicios = "SELECT * FROM servicios";
            rs = stmt.executeQuery(consultaServicios);

            // Mostrar los servicios disponibles
            System.out.println("Servicios disponibles:");
            while (rs.next()) {
                int idServicio = rs.getInt("id");
                String nombreServicio = rs.getString("nombre");
                double precioServicio = rs.getDouble("precio");
                System.out.println(idServicio + ". " + nombreServicio + " - Precio: $" + precioServicio);
            }

            // Paso 5: Permitir al usuario seleccionar lo que desea comprar o contratar
            List<Double> preciosSeleccionados = new ArrayList<>();
            while (preciosSeleccionados.size() < 5) {
                System.out.println("Ingrese el ID del producto o servicio que desea agregar a su compra:");
                int idSeleccionado = scanner.nextInt();

                // Verificar si el ID corresponde a un producto o servicio
                rs = stmt.executeQuery("SELECT tipo FROM productos WHERE id = " + idSeleccionado);
                if (rs.next()) {
                    // Es un producto
                    rs = stmt.executeQuery("SELECT precio FROM productos WHERE id = " + idSeleccionado);
                    if (rs.next()) {
                        preciosSeleccionados.add(rs.getDouble("precio"));
                    }
                } else {
                    // Es un servicio
                    rs = stmt.executeQuery("SELECT precio FROM servicios WHERE id = " + idSeleccionado);
                    if (rs.next()) {
                        preciosSeleccionados.add(rs.getDouble("precio"));
                    }
                }
            }

            // Paso 6: Calcular el total de la compra
            double total = 0;
            for (double precio : preciosSeleccionados) {
                total += precio;
            }

            // Paso 7: Mostrar el total de la compra
            System.out.println("El total de la compra es: $" + total);

            System.out.println("La compra se ha registrado correctamente.");
        } catch (SQLException e) {
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                // Cerrar el scanner
                scanner.close();
            } catch (SQLException e) {
            }
        }
    }
}


/*public class Renta {
    public static void main(String[] args) {
        // Conexión a la base de datos
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        // Crear un objeto Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        try {
            // Paso 1: Establecer la conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/play&rent";
            String usuario = "root";
            String contraseña = "";
            con = DriverManager.getConnection(url, usuario, contraseña);

            // Paso 2: Crear una declaración
            stmt = con.createStatement();

            // Paso 3: Obtener los datos de servicios
            String consultaServicios = "SELECT * FROM servicios";
            rs = stmt.executeQuery(consultaServicios);

            // Mostrar los servicios disponibles
            System.out.println("Servicios disponibles:");
            while (rs.next()) {
                int idServicio = rs.getInt("id");
                String nombreServicio = rs.getString("nombre");
                String precioServicio = rs.getString("precio");
                System.out.println("Id"+idServicio + ". " + nombreServicio + " - Precio: $" + precioServicio);
            }

            // Paso 4: Obtener los datos de juguetes
            String consultaJuguetes = "SELECT * FROM juguetes";
            rs = stmt.executeQuery(consultaJuguetes);

            // Mostrar los juguetes disponibles
            System.out.println("\nJuguetes disponibles:");
            while (rs.next()) {
                int idJuguete = rs.getInt("id");
                String nombreJuguete = rs.getString("nombre");
                String precioJuguete = rs.getString("precio");
                System.out.println("Id"+idJuguete + ". " + nombreJuguete + " - Precio: $" + precioJuguete);
            }

            // Paso 5: Permitir al usuario seleccionar lo que desea rentar
            System.out.println("\nIngrese el ID del servicio que desea rentar:");
            int idServicioSeleccionado = scanner.nextInt();
            System.out.println("Ingrese el ID del juguete que desea rentar:");
            int idJugueteSeleccionado = scanner.nextInt();

            // Paso 6: Calcular el total de la renta
            double total = 0;
            // Obtener el precio del servicio seleccionado
            rs = stmt.executeQuery("SELECT precio FROM servicios WHERE id = " + idServicioSeleccionado);
            if (rs.next()) {
                total += rs.getDouble("precio");
            }
            // Obtener el precio del juguete seleccionado
            rs = stmt.executeQuery("SELECT precio FROM juguetes WHERE id = " + idJugueteSeleccionado);
            if (rs.next()) {
                total += rs.getDouble("precio");
            }
            // Mostrar el total de la renta
            System.out.println("\nEl total de la renta es: $" + total);

            // Paso 7: Registrar la transacción en la base de datos
            String insertTransaccion = "INSERT INTO transacciones (ids, idj, fecha, total) VALUES (?, ?, CURRENT_DATE, ?)";
            PreparedStatement ps = con.prepareStatement(insertTransaccion);
            ps.setInt(1, idServicioSeleccionado);
            ps.setInt(2, idJugueteSeleccionado);
            ps.setDouble(3, total);
            ps.executeUpdate();

            System.out.println("\nLa renta se ha registrado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                // Cerrar el scanner
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/
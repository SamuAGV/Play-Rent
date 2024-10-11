import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rentass {
    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/play&rent", "root", "")) {
            Statement stmt = con.createStatement();

            // Obtener y mostrar productos y servicios disponibles
            List<Double> preciosProductos = obtenerProductos(stmt);
            List<Double> preciosServicios = obtenerServicios(stmt);

            // Permitir al usuario seleccionar productos y servicios
            float total = seleccionarProductos(scanner, preciosProductos);
            total += seleccionarServicios(scanner, preciosServicios);

            // Calcular y mostrar el total de la renta con IVA
            float totalConIVA = calcularTotalConIVA(total);
            System.out.println("El Total De La Renta Con IVA Es: $" + totalConIVA);

            System.out.println("*** GRACIAS POR SU RENTA ***");
            System.out.println("\nSaliendo del menú Rentas....\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener los productos disponibles
    private static List<Double> obtenerProductos(Statement stmt) throws SQLException {
        List<Double> preciosProductos = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT * FROM juguetes");

        System.out.println("Juguetes Disponibles:");
        while (rs.next()) {
            int idProducto = rs.getInt("id");
            String nombreProducto = rs.getString("nombre");
            double precioProducto = rs.getDouble("precio");
            preciosProductos.add(precioProducto);
            System.out.println("ID " + idProducto + ". " + nombreProducto + " - Precio: $" + precioProducto);
        }
        return preciosProductos;
    }

    // Método para obtener los servicios disponibles
    private static List<Double> obtenerServicios(Statement stmt) throws SQLException {
        List<Double> preciosServicios = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT * FROM servicios");

        System.out.println("\nServicios Disponibles:");
        while (rs.next()) {
            int idServicio = rs.getInt("id");
            String nombreServicio = rs.getString("nombre");
            double precioServicio = rs.getDouble("precio");
            preciosServicios.add(precioServicio);
            System.out.println("ID " + idServicio + ". " + nombreServicio + " - Precio: $" + precioServicio);
        }
        return preciosServicios;
    }

    // Método para seleccionar productos
    private static float seleccionarProductos(Scanner scanner, List<Double> preciosProductos) {
        float total = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("\nIngrese el ID del JUGUETE que desea comprar:");
            int idProductoSeleccionado = scanner.nextInt();
            total += preciosProductos.get(idProductoSeleccionado - 1); // Restamos 1 porque los índices comienzan desde 0
        }
        return total;
    }

    // Método para seleccionar servicios
    private static float seleccionarServicios(Scanner scanner, List<Double> preciosServicios) {
        float total = 0;
        for (int i = 0; i < 2; i++) {
            System.out.println("\nIngrese el ID del SERVICIO que desea contratar:");
            int idServicioSeleccionado = scanner.nextInt();
            total += preciosServicios.get(idServicioSeleccionado - 1); // Restamos 1 porque los índices comienzan desde 0
            // Verificar si es entrega a domicilio y solicitar los kilómetros
            if (idServicioSeleccionado == 2) {
                System.out.println("Ingrese la cantidad de kilómetros para la entrega a domicilio:");
                float kilometros = scanner.nextFloat();
                float cargoExtra = calcularCargoExtra(kilometros);
                total += cargoExtra;
                System.out.println("Se ha agregado un cargo extra por la entrega a domicilio de $" + cargoExtra);
            }
        }
        return total;
    }

    // Método para calcular el cargo extra por la entrega a domicilio
    private static float calcularCargoExtra(float kilometros) {
        float costoPorKilometro = 50.50f; // Puedes ajustar este valor según tu tarifa
        return kilometros * costoPorKilometro;
    }

    // Método para calcular el total de la renta con IVA
    private static float calcularTotalConIVA(float total) {
        float res = (total * 0.16f); // 16% de IVA
        return total + res;
    }
}

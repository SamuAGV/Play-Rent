package Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mensaje.mensaje;

public class rentas {


    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        // Crear un objeto Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        try {
            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/play&rent", "root", "");

            // Crear una declaración
            stmt = con.createStatement();

            //  Obtener los datos de productos
            String consultaProductos = "SELECT * FROM juguetes";
            rs = stmt.executeQuery(consultaProductos);

            // Mostrar los productos disponibles
            System.out.println("Juguetes Disponibles:");
            List<Double> preciosProductos = new ArrayList<>();
            while (rs.next()) {
                int idProducto = rs.getInt("id");
                String nombreProducto = rs.getString("nombre");
                double precioProducto = rs.getDouble("precio");
                preciosProductos.add(precioProducto);
                System.out.println("ID "+idProducto + ". \n" + nombreProducto + " - Precio: $" + precioProducto);
            }

            // Obtener los datos de servicios
            String consultaServicios = "SELECT * FROM servicios";
            rs = stmt.executeQuery(consultaServicios);

            // Mostrar los servicios disponibles
            System.out.println("\nServicios Disponibles:");
            List<Double> preciosServicios = new ArrayList<>();
            while (rs.next()) {
                int idServicio = rs.getInt("id");
                String nombreServicio = rs.getString("nombre");
                double precioServicio = rs.getDouble("precio");
                preciosServicios.add(precioServicio);
                System.out.println("ID "+idServicio + ". \n" + nombreServicio + " - Precio: $" + precioServicio);

            }
                System.out.println("(El Cargo Extra Por Entregra A Domicilio Es De $50.50 Pesos Por Cada Kilometro)");
                
            // Permitir al usuario seleccionar juguetes a rentar
            float total = 0;
            for (int i = 0; i < 3; i++) {
                
                System.out.println("\nIngrese el ID del JUGUETE que desea comprar:");
                int idProductoSeleccionado = scanner.nextInt();
                total += preciosProductos.get(idProductoSeleccionado - 1); // Restamos 1 porque los índices comienzan desde 0

            }
            
            // Permitir al usuario seleccionar servicios a rentar
            for (int i = 0; i < 2; i++) {
    System.out.println("\nIngrese el ID del SERVICIO que desea contratar:");
    int idServicioSeleccionado = scanner.nextInt();
    
    double costoServicio = preciosServicios.get(idServicioSeleccionado - 1); // Obtener el costo del servicio
    
    // Verificar si el servicio seleccionado es entrega a domicilio
    if (idServicioSeleccionado == 2) {
        System.out.println("Ingrese la cantidad de kilómetros para la entrega a domicilio:");
        float kilometros = scanner.nextFloat();
        // Calcular el costo extra basado en los kilómetros
        float costoPorKilometro = 50.50f; // Puedes ajustar este valor según tu tarifa
        float cargoExtraPorKilometros = kilometros * costoPorKilometro;
        System.out.println("Se ha agregado un cargo extra por la entrega a domicilio de $" + cargoExtraPorKilometros+" Pesos");
        costoServicio += cargoExtraPorKilometros; // Sumar el costo extra al costo del servicio
    }
    
    total += costoServicio; // Sumar el costo del servicio (con o sin cargo extra) al total de la renta
}



    
                
            // Mostrar el total de la compra
            System.out.println("El Total De La Renta Es: $" + total);
            float res =(total*.16f);
            float iva = res+total;
            System.out.println("El Total De La Renta Con IVA Es: $"+iva);
            System.out.println();
            System.out.println("*** GRACIAS POR SU RENTA ***");
            System.out.println("\nSaliendo del menu Rentas....\n");
        } catch (SQLException e) {
        }
    }
}

/*
for (int i = 0; i < 2; i++) {
                System.out.println("\nIngrese el ID del SERVICIO que desea contratar:");
                int idServicioSeleccionado = scanner.nextInt();
                total += preciosServicios.get(idServicioSeleccionado - 1); // Restamos 1 porque los índices comienzan desde 0
                 
            }
            //Cargo Extra
            System.out.println("¿Desea agregar un cargo extra por el servicio? (S/N)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("S")) {
                System.out.println("Ingrese el monto del cargo extra por el servicio:");
                    float cargoExtra = scanner.nextFloat();
                    total += cargoExtra;
                    System.out.println("Se ha agregado un cargo extra por el servicio de $" + cargoExtra);
    }
*/
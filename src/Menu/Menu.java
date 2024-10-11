package Menu;

import java.util.Scanner;
import Menu.clientes.menucli;
import Menu.juguetes.menujug;
import Menu.servicios.menuser;

public class Menu{
    public static void main(String[] args) {
        Scanner leermenu = new Scanner(System.in);

        //Aqui solo hay pan y vrg, y ya se termino el pan
        while (true) {
            System.out.println("\nBienvenido al Menú Principal:");
            System.out.println("1. Juguete");
            System.out.println("2. Cliente");
            System.out.println("3. Servicios");
            System.out.println("4. Renta");            
            System.out.println("5. Salir");
            
            System.out.print("Seleccione una opción: ");
            int men = leermenu.nextInt();
            
            switch (men) {
                case 1:
                    System.out.println("\nHa seleccionado Juguete");
                    menujug.main(args);
                    break;
                    
                case 2:
                    System.out.println("\nHa seleccionado Cliente");
                    menucli.main(args);
                    //Sobre escritura y Sobrecarga de metodos
                    break;
                case 3:
                    System.out.println("\nA seleccionado Servicios");
                    menuser.main(args);
                    break;
                    
                case 4:
                    System.out.println("\nA seleccionado La Renta");
                    rentas.main(args);
                    break;
                    
                case 5:
                    System.out.println("\nCerrando El Menu Principal....");
                    System.exit( 0);
                    
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    
}

package tiendajdbc;

import java.util.Scanner;
import tiendajdbc.servicios.FabricanteService;
import tiendajdbc.servicios.ProductoService;

/**
 *
 * @author Maria Emilia
 */
public class TiendaJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FabricanteService fabricanteService = new FabricanteService();
        ProductoService productoService = new ProductoService();
        String op;
        do {
            System.out.println("\n ¿QUÉ ACCIÓN DESEA REALIZAR? \n"
                    + "a) Lista el nombre de todos los productos que hay en la tabla producto.\n"
                    + "b) Lista los nombres y los precios de todos los productos de la tabla producto.\n"
                    + "c) Listar aquellos productos que su precio esté entre 120 y 202.\n"
                    + "d) Buscar y listar todos los Portátiles de la tabla producto.\n"
                    + "e) Listar el nombre y el precio del producto más barato.\n"
                    + "f) Ingresar un producto a la base de datos.\n"
                    + "g) Ingresar un fabricante a la base de datos\n"
                    + "h) Editar un producto con datos a elección.\n"
                    + "i) Mostrar todos los productos y su detalle.\n"
                    + "j) Salir.");

            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            op = leer.nextLine();
            op = op.toLowerCase();

            try {
                if (op == null) {
                    throw new Exception("Debe indicar la acción que desea realizar");
                }
                switch (op) {
                    case "a":
                        System.out.println("a. Lista el nombre de todos los productos que hay en la tabla producto");
                        try {
                            productoService.imprimirNombreProductos();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error del sistema por \n" + e.getMessage());
                        }
                        break;
                    case "b":
                        System.out.println("\nb. Lista los nombres y los precios de todos los productos de la tabla producto.");
                        try {
                            productoService.imprimirNombreYprecioProductos();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error del sistema por \n" + e.getMessage());
                        }
                        break;
                    case "c":
                        System.out.println("\nc. Listar aquellos productos que su precio esté entre 120 y 202.");
                        try {
                            productoService.imprimirPrecio120y202();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error del sistema por \n" + e.getMessage());
                        }
                        break;
                    case "d":
                        System.out.println("\nd. Buscar y listar todos los Portátiles de la tabla producto.");
                        try {
                            productoService.imprimirPortatiles();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error del sistema por \n" + e.getMessage());
                        }
                        break;
                    case "e":
                        System.out.println("\ne. Listar el nombre y el precio del producto más barato.");
                        try {
                            productoService.imprimirMasBarato();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error del sistema por \n" + e.getMessage());
                        }
                        break;
                    case "f":
                        System.out.println("\nf. Ingresar un producto a la base de datos.");
                        try {
                            productoService.ingresarProducto();
                            productoService.imprimirProductos();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error del sistema por \n" + e.getMessage());
                        }
                        break;
                    case "g":
                        System.out.println("\ng. Ingresar un fabricante a la base de datos");
                        try {
                            fabricanteService.ingresarFabricante();                           
                            fabricanteService.imprimirFabricantes();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error del sistema por \n" + e.getMessage());
                        }
                        break;

                    case "h":
                        System.out.println("\nh. Editar un producto con datos a elección.");
                        try {
                            productoService.modificarProducto();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error del sistema por \n" + e.getMessage());
                        }
                        break;

                    case "i":
                        System.out.println("i. Imprimir todos los productos y su detalle");
                        try {
                            productoService.imprimirProductos();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error del sistema por \n" + e.getMessage());
                        }
                        break;
                    case "j":
                        break;
                    default:
                        System.out.println("La opción ingresada no es válida");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error del sistema por \n" + e.getMessage());
            }
        } while (!"j".equals(op));
    }

}

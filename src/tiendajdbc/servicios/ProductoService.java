package tiendajdbc.servicios;

import java.util.Collection;
import java.util.Scanner;
import tiendajdbc.entidades.Producto;
import tiendajdbc.persistencia.ProductoDAO;

/**
 *
 * @author Maria Emilia
 */
public class ProductoService {

    private ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }

    public void ingresarProducto() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {
            System.out.println("Nombre:");
            String nombre = leer.next();
            
            System.out.println("Precio:");
            Double precio = leer.nextDouble();
            
            System.out.println("Código de Fabricante:");
            int codigoFabricante = leer.nextInt();

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);

            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(Producto producto) throws Exception {

    }

    public Collection<Producto> listarProducto() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {
            Collection<Producto> productos = listarProducto();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarNombreProductos() throws Exception {

        try {

            Collection<Producto> nombreProductos = dao.listarNombreProductos();

            return nombreProductos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirNombreProductos() throws Exception {

        try {

            Collection<Producto> nombreProductos = listarNombreProductos();

            if (nombreProductos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : nombreProductos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarNombreYprecioProductos() throws Exception {

        try {

            Collection<Producto> nombreProductos = dao.listarNombreYprecioProductos();

            return nombreProductos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirNombreYprecioProductos() throws Exception {

        try {

            Collection<Producto> Productos = listarNombreYprecioProductos();

            if (Productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : Productos) {
                    System.out.println(p.getNombre() + " $" + p.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarPrecio120y202() throws Exception {

        try {

            Collection<Producto> nombreProductos = dao.listarPrecio120y202();

            return nombreProductos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirPrecio120y202() throws Exception {

        try {

            Collection<Producto> Productos = listarPrecio120y202();

            if (Productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : Productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarPortatiles() throws Exception {

        try {

            Collection<Producto> nombreProductos = dao.listarPortatiles();

            return nombreProductos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirPortatiles() throws Exception {

        try {

            Collection<Producto> Productos = listarPortatiles();

            if (Productos.isEmpty()) {
                throw new Exception("No existen portatiles para imprimir");
            } else {
                for (Producto p : Productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarMasBarato() throws Exception {

        try {

            Collection<Producto> Productos = dao.listarMasBarato();

            return Productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirMasBarato() throws Exception {

        try {

            Collection<Producto> Productos = listarMasBarato();

            if (Productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : Productos) {
                    System.out.println(p.getNombre() + " $" + p.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

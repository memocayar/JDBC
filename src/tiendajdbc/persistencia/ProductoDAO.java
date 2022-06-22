/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendajdbc.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tiendajdbc.entidades.Producto;

/**
 *
 * @author Maria Emilia
 */
public class ProductoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }

            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ( '" + producto.getNombre() + "' , " + producto.getPrecio() + " , " + producto.getCodigoFabricante() + " );";
            
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }

            String sql = "UPDATE producto SET "
                    + "nombre = '" + producto.getNombre() + "', precio = " + producto.getPrecio() + " , codigo_fabricante = " + producto.getCodigoFabricante() 
                    + ", WHERE codigo = '" + producto.getCodigo() + "';";
            
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(String nombre) throws Exception {
        try {

            String sql = "DELETE FROM producto WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarproductoPorNombre(String nombre) throws Exception {
        try {

            String sql = "SELECT * FROM producto "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Producto buscarproductoPorCodigo(Integer codigo) throws Exception {
        try {

            String sql = "SELECT * FROM producto "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT codigo, nombre, precio, codigo_fabricante FROM producto ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    public Collection<Producto> listarNombreProductos() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> nombreProductos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                nombreProductos.add(producto);
            }
            desconectarBase();
            return nombreProductos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    public Collection<Producto> listarNombreYprecioProductos() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> nombreProductos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                nombreProductos.add(producto);
            }
            desconectarBase();
            return nombreProductos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    public Collection<Producto> listarPrecio120y202() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto WHERE precio BETWEEN 120 AND 202";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> nombreProductos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                nombreProductos.add(producto);
            }
            desconectarBase();
            return nombreProductos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    public Collection<Producto> listarPortatiles() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto WHERE nombre LIKE 'Portátil%'";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> nombreProductos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                nombreProductos.add(producto);
            }
            desconectarBase();
            return nombreProductos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    public Collection<Producto> listarMasBarato() throws Exception {
        try {
            String sql = "SELECT nombre, MIN(precio) FROM producto";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> nombreProductos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                nombreProductos.add(producto);
            }
            desconectarBase();
            return nombreProductos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}

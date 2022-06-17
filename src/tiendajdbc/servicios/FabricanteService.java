/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendajdbc.servicios;

import java.util.Collection;
import java.util.Scanner;
import tiendajdbc.entidades.Fabricante;
import tiendajdbc.persistencia.FabricanteDAO;

/**
 *
 * @author Maria Emilia
 */
public class FabricanteService {

    private FabricanteDAO dao;

    public FabricanteService() {
        this.dao = new FabricanteDAO();
    }

    public void ingresarFabricante() throws Exception {

        try {
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Nombre:");
            String nombre = leer.next();

            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);

            dao.guardarFabricante(fabricante);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(String nombre) throws Exception {

        try {
            if (nombre == null) {
                throw new Exception("Debe indicar el nombre del fabricante que desea eliminar");
            }
            dao.eliminarFabricante(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricante() throws Exception {

        try {

            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantes() throws Exception {

        try {
            Collection<Fabricante> fabricantes = listarFabricante();

            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Fabricante f : fabricantes) {
                    System.out.println(f.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

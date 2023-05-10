/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerig;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guerig
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        
        List<Factura> listaFactura = new ArrayList(); 
        
        // Instancia de la factura DAO
        FacturaDAO fdao = new FacturaDAO();
        
        // Leemos y almacenamos los datos del fichero
        listaFactura = Fichero.leer("facturas.csv");
        
        System.out.println("Lista de facturas: ");
        for (Factura factura : listaFactura) {
            System.out.println(factura);
        }
        
        // Insertar lista de facturas en la bbdd
        fdao.insertFactura(listaFactura);
        
        // Insertar cada una de las facturas
//        for (Factura factura : listaFactura) {
//            fdao.insertFactura(factura);
//        }
        
        // Obtener todas las facturas
        List<Factura> listaDAO = new ArrayList();
        listaDAO = fdao.getAll();
        
        System.out.println("\nTodas las facturas de la bbdd");
        for (Factura factura : listaDAO) {
            System.out.println(factura);
        }
        
        // Obtener un dato por su PK
        Factura facturaPK = fdao.findByPk(1);
        
        System.out.println("\nFactura obtenida por su PK:");
        System.out.println(facturaPK);
        
        // Insertar nueva factura
        Factura factInsert = new Factura(100, LocalDate.of(2020, Month.MARCH, 18), "prueba", 58);
                
        fdao.insertFactura(factInsert);
        
        System.out.println("Nueva factura insertada: ");
        System.out.println(factInsert);
        
        
        // Eliminar todas las facturas
        fdao.deleteFactura();
        
        // Eliminar una factura determinada
        fdao.deleteFactura(listaFactura.get(49));
        
        Factura factUpdate = new Factura(1, LocalDate.of(2023, Month.APRIL, 15), "actualizado", 100);

        
    }
}

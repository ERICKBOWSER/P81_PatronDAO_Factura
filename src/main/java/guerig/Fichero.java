/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerig;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author guerig
 */
public class Fichero {
    public static List<Factura> leer(String nombre){
        // Fichero a leer con datos de ejemplo
        String idFichero = nombre;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        List<Factura> lista = new ArrayList();

//        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                
                Factura fact = new Factura();
                
                fact.setCodigo(Integer.parseInt(tokens[0]));
                
                if(tokens[1].equalsIgnoreCase("")){
                    fact.setFechaEmision(null);
                }else{
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // formato como esta guardado en el csv
                    
                    LocalDate fecha = LocalDate.parse(tokens[1], formato);
                    
                    fact.setFechaEmision(fecha);
                }
                
                fact.setDescripcion(tokens[2]);
                fact.setTotalImporteFactura(Double.parseDouble(tokens[3]));
                
                // Añadimos los datos a la lista de facturas
                lista.add(fact);               
                                
            }
            
//            for (Factura factura : lista) {
//                    System.out.println(factura);
//            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}

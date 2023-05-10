/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author guerig
 */
public class Factura {

    public static Random getGenerar() {
        return generar;
    }

    public static void setGenerar(Random aGenerar) {
        generar = aGenerar;
    }
    private int codigo;
    private LocalDate fechaEmision;
    private String descripcion;
    private double totalImporteFactura;
    private static Random generar = new Random();    
    private static int contador = 0;
    

    public Factura(int codigo, LocalDate fechaEmision, String descripcion, double totalImporteFactura) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.descripcion = descripcion;
        this.totalImporteFactura = totalImporteFactura;
    }


    public Factura() {
    }
    
    public static double generarDouble(){
        DoubleStream stream = generar.doubles(1, 100, 1000);
        
        // findFirst() devuelve el primer elemento que encuentre
        // getAsDouble() devuelve el elemento como tipo double
        double res = stream.findFirst().getAsDouble(); // Si no se hace esto funciona pero no sale el resultado esperado
        return res;
    }    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTotalImporteFactura() {
        return totalImporteFactura;
    }

    public void setTotalImporteFactura(double totalImporteFactura) {
        this.totalImporteFactura = totalImporteFactura;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codigo).append(";");
        sb.append(fechaEmision).append(";");;
        sb.append(descripcion).append(";");;
        sb.append(totalImporteFactura).append(";");;
        return sb.toString();
    }  
        
        
    
    
}

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
    private String codigo;
    private LocalDate fechaEmision;
    private String descripcion;
    private double totalImporteFactura;
    private static Random generar = new Random();    
    private static int contador = 0;
    

    public Factura() {
        this.codigo = String.valueOf(contador++);
        
        this.fechaEmision = LocalDate.now(); // Sacar fecha actual del sistema
        
        this.descripcion = RandomStringUtils.randomAlphabetic(50);
        
        this.totalImporteFactura = generarDouble();
    }
    
    public static double generarDouble(){
        DoubleStream stream = generar.doubles(1, 100, 1000);
        
        // findFirst() devuelve el primer elemento que encuentre
        // getAsDouble() devuelve el elemento como tipo double
        double res = stream.findFirst().getAsDouble(); // Si no se hace esto funciona pero no sale el resultado esperado
        return res;
    }    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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
        sb.append("Factura{");
        sb.append("CODIGO=").append(codigo).append(";");
        sb.append("fechaEmision=").append(fechaEmision).append(";");;
        sb.append("descripcion=").append(descripcion).append(";");;
        sb.append("totalImporteFactura=").append(totalImporteFactura).append(";");;
        sb.append('}');
        return sb.toString();
    }  
        
        
    
    
}

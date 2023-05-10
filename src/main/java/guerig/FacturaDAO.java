/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerig;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guerig
 */
public class FacturaDAO implements IFactura{
    
    private Connection connect = null;
    
    public FacturaDAO(){
        connect = Conexion.getInstance();
    }

    @Override
    public List<Factura> getAll() throws SQLException {
        List<Factura> lista = new ArrayList<>();
        
        try(Statement st  = connect.createStatement()){
            
            // ResultSet obtiene las filas de la sentencia
            // executeQuery ejecuta la sentencia
            ResultSet res = st.executeQuery("SELECT * FROM factura");
            
            while(res.next()){
                // Con cada repetición se crea una nueva factura
                Factura f = new Factura();
                
                // Almacenamos los datos de cada tabla en una nueva factura
                f.setCodigo(res.getInt("codigo"));
                f.setDescripcion(res.getString("descripcion"));
                
                // Parseamos los datos para obtener la fecha
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Formato para la fecha
                LocalDate fecha = LocalDate.parse(res.getString("fechaEmision"), formato);
                f.setFechaEmision(fecha);         
                
                f.setTotalImporteFactura(res.getDouble("totalImporteFactura"));
                
                // Añadimos los datos a la lista
                lista.add(f);
            }
            
        }

        return lista;
    }

    // Encontrar factura por la PK
    @Override
    public Factura findByPk(int pk) throws SQLException {
        ResultSet res = null;
        Factura fact = new Factura();
        
        String sql = "SELECT * FROM factura WHERE codigo = ?";
        
        try(PreparedStatement prest = connect.prepareStatement(sql)){
            // Preparar sentencía parametrizada
            prest.setInt(1, pk);
            
            // Ejecutar la sentencia y obtener las filas en el objeto ResultSet
            res = prest.executeQuery();
            
            if(res.next()){
                fact.setCodigo(res.getInt("codigo"));
                fact.setFechaEmision(res.getDate("fechaEmision").toLocalDate());
                fact.setDescripcion(res.getString("descripcion"));
                fact.setTotalImporteFactura(res.getDouble("totalImporteFactura"));
                
                return fact;
            }
            return null;
        }
        
    }

    // Insertar nueva factura
    @Override
    public int insertFactura(Factura f) throws SQLException {

        int numFilas = 0;
        
        // Sentencia sql
        String sql = "INSERT INTO factura VALUES (?,?,?,?)";

        if(findByPk(f.getCodigo()) != null){
            
            // Si existe un registro con esa PK no se hace la inserción
            return numFilas;
        }else{
            
            try(PreparedStatement prest = connect.prepareStatement(sql)){
                prest.setInt(1, f.getCodigo());
                prest.setDate(2, Date.valueOf(f.getFechaEmision())); // Hay que importar "import java.sql.Date"
                prest.setString(3, f.getDescripcion());
                prest.setDouble(4, f.getTotalImporteFactura());
                
                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
        
    }

    // Insertar lista de facturas
    @Override
    public int insertFactura(List<Factura> lista) throws SQLException {
        int numFilas = 0;
        
        for (Factura factura : lista) {
            // Aumenta contador por cada llamada al propio método            
            numFilas += insertFactura(factura); // Llamada al otro método de insertFactura
        }
        return numFilas;
    }

    // Eliminar todas las facturas
    @Override
    public int deleteFactura() throws SQLException {
        String sql =  "DELETE FROM factura";
        
        int nFilas = 0;
        
        try (Statement st = connect.createStatement()){
            nFilas = st.executeUpdate(sql);
        }
        
        return nFilas;
    }

    // Eliminar una factura en concreto
    @Override
    public int deleteFactura(Factura f) throws SQLException {
        int numFilas = 0;
        
        String sql = "DELETE FROM factura WHERE codigo = ?";
        
        try(PreparedStatement prest = connect.prepareStatement(sql)){
            prest.setInt(1, f.getCodigo()); // Obtenemos el código para realizar la eliminación
            
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    // Actualizar una factura en concreto
    @Override
    public int updateFactura(int pk, Factura nuevosDatos) throws SQLException {
        int numFilas = 0;
        String sql = "UPDATE factura SET codigo = ?, fechaEmision = ?, descripcion = ?, totalImporteFactura = ? WHERE codigo = ?";
        
        if(findByPk(pk) == null){
            return numFilas;
        }else{
            try(PreparedStatement prest = connect.prepareStatement(sql)){
                prest.setInt(1, nuevosDatos.getCodigo());
                prest.setDate(2, Date.valueOf(nuevosDatos.getFechaEmision()));
                prest.setString(3, nuevosDatos.getDescripcion());
                prest.setDouble(4, nuevosDatos.getTotalImporteFactura());
                
                // Hay que colocar el codigo del WHERE si no no funciona
                prest.setInt(5, nuevosDatos.getCodigo());
                
                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }
    
}

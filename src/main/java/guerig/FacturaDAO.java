/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerig;

import java.sql.Connection;
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
                f.setCodigo(res.getNString("codigo"));
                f.setDescripcion(res.getString("descripcion"));
                
                // Parseamos los datos para obtener la fecha
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Formato para la fecha
                LocalDate fecha = LocalDate.parse(res.getString("fechaEmision"), formato);
                f.setFechaEmision(fecha);         
                
                f.setTotalImporteFactura(res.getDouble("totalImporteFactura"));
                
                // Añadimos los datos a la lista
                lista.add(f);
            }
            
        }

        return lista;
    }

    @Override
    public Factura findByPk(int pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertFactura(Factura f) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertFactura(List<Factura> lista) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteFactura(Factura f) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteFactura() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateFactura(int pk, Factura nuevosDatos) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

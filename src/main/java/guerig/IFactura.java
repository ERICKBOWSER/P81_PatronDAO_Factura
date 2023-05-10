/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package guerig;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author guerig
 */
public interface IFactura {
    // Método para obtener todos los registros de la tabla
    List<Factura> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    Factura findByPk(int pk) throws SQLException;
    
    // Método para insertar un registro
    int insertFactura (Factura f) throws SQLException;
    
    // Método para insertar varios registros
    int insertFactura (List<Factura> lista) throws SQLException;
    
    // Método para borrar una persona
    int deleteFactura (Factura f) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteFactura() throws SQLException;
    
    // Método para modificar una factura. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int updateFactura (int pk, Factura nuevosDatos) throws SQLException;
}

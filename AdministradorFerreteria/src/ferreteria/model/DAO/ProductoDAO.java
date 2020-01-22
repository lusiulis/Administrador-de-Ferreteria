
package ferreteria.model.DAO;

import ferreteria.model.entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {
    
    private final GestorBD gestor;
    
    private static ProductoDAO instancia = null;

    private ProductoDAO() {
        this.gestor = GestorBD.obtenerInstancia();
    }
    
    public ProductoDAO getInstancia(){
        if(instancia == null){
            instancia = new ProductoDAO();
        }
        return instancia;
    }
    
    public boolean AgregarMaterial(Producto Nuevo){
        boolean Exito = false;
        try(Connection cnx = gestor.obtenerConexion();
            PreparedStatement stm = cnx.prepareStatement(CMD_AGREGARMATERIAL);){
           
            stm.clearParameters();
            stm.setString(1, Nuevo.getNombre());
            stm.setInt(2, Nuevo.getCantidad());
            stm.setString(3, Nuevo.getDescripcion());
            stm.setDouble(4, Nuevo.getPrecio());
            stm.setString(5, Nuevo.getTipo());
            stm.setDouble(6, Nuevo.getLongitud());
            
            Exito = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return Exito;
    }
    
    public boolean AgregarHerramienta(Producto Nuevo){
        boolean Exito = false;
        try(Connection cnx = gestor.obtenerConexion();
            PreparedStatement stm = cnx.prepareStatement(CMD_AGREGARHERRAMIENTA);){
            
            stm.clearParameters();
            stm.setString(1, Nuevo.getNombre());
            stm.setInt(2, Nuevo.getCantidad());
            stm.setString(3, Nuevo.getDescripcion());
            stm.setDouble(4, Nuevo.getPrecio());
            stm.setString(5, Nuevo.getTipo());
            stm.setString(6, Nuevo.getCapacidadTrabajo());
            
            Exito = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return Exito;
    }
    
    public boolean Borrar(int i){
        boolean Exito = false;
        
        try(Connection cnx = gestor.obtenerConexion();
            PreparedStatement stm = cnx.prepareStatement(CMD_BORRAR);){
            
            stm.clearParameters();
            stm.setInt(1, i);
            
            Exito = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return Exito;
    }
    
    public List<Producto> ListarNombre(String nombre){
        List<Producto> lista = new ArrayList();
        
        try(Connection cnx = gestor.obtenerConexion();
            PreparedStatement stm = cnx.prepareStatement(CMD_LISTARNOMBRE);){
            
            stm.clearParameters();
            stm.setString(1, "%"+nombre+"%");
            
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                lista.add(new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("Nombre"),
                        rs.getInt("Cantidad"),
                        rs.getString("Descripcion"),
                        rs.getDouble("Precio"),
                        rs.getString("Tipo"),
                        rs.getDouble("Longitud"),
                        rs.getString("CapacidadTrabajo")
                ));
            }
            
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
             
        return lista;
    }
    private static final String CMD_AGREGARMATERIAL
            = "INSERT INTO producto (Nombre, Cantidad, Descripcion, Precio, Tipo, Longitud) "
            + "VALUES (?, ?, ?, ?, ?, ?);";
    
    private static final String CMD_AGREGARHERRAMIENTA
            = "INSERT INTO producto (Nombre, Cantidad, Descripcion, Precio, Tipo, CapacidadTrabajo) "
            + "VALUES (?, ?, ?, ?, ?, ?);";
    private static final String CMD_BORRAR
            = "delete from producto where idProducto=?";
    
     private static final String CMD_LISTARNOMBRE
            = "SELECT idProducto, Nombre, Precio, Cantidad, Descripcion, Precio, Tipo, Longitud, CapacidadTrabajo FROM producto where Nombre like ?;";
}

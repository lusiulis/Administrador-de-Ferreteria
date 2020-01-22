package ferreteria.model.DAO;

import ferreteria.model.entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public static ProductoDAO getInstancia() {
        if (instancia == null) {
            instancia = new ProductoDAO();
        }
        return instancia;
    }

    public Boolean AgregarProducto(Producto nuevo) {
        if (nuevo.getTipo().equals("material")) {
            return AgregarMaterial(nuevo);
        } else {
            return AgregarHerramienta(nuevo);
        }
    }

    public boolean AgregarMaterial(Producto nuevo) {

        boolean Exito = false;
        try (Connection cnx = gestor.obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGARMATERIAL);) {

            stm.clearParameters();
            stm.setString(1, nuevo.getNombre());
            stm.setInt(2, nuevo.getCantidad());
            stm.setString(3, nuevo.getDescripcion());
            stm.setDouble(4, nuevo.getPrecio());
            stm.setString(5, nuevo.getTipo());
            stm.setDouble(6, nuevo.getLongitud());

            Exito = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return Exito;
    }

    public boolean AgregarHerramienta(Producto nuevo) {
        boolean Exito = false;
        try (Connection cnx = gestor.obtenerConexion();
             PreparedStatement stm = cnx.prepareStatement(CMD_AGREGARHERRAMIENTA);) {

            stm.clearParameters();
            stm.setString(1, nuevo.getNombre());
            stm.setInt(2, nuevo.getCantidad());
            stm.setString(3, nuevo.getDescripcion());
            stm.setDouble(4, nuevo.getPrecio());
            stm.setString(5, nuevo.getTipo());
            stm.setString(6, nuevo.getCapacidadTrabajo());

            Exito = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return Exito;
    }


    public boolean Modificar(Producto nuevo){
        boolean Exito = false;
        
        try(Connection cnx = gestor.obtenerConexion();){
            Statement stm = cnx.createStatement();
            Exito = stm.executeUpdate("UPDATE producto Set Nombre = "+nuevo.getNombre()
                        +" , Cantidad = "+nuevo.getCantidad()
                        +" , Descripcion = "+nuevo.getDescripcion()
                        +" , Precio = "+nuevo.getPrecio()
                        +" , Tipo = "+ nuevo.getTipo()
                        +" , Longitud = "+nuevo.getLongitud()
                        +" , CapacidadTrabajo = "+ nuevo.getCapacidadTrabajo() 
                        + " where idProducto = "+nuevo.getId()) == 1;         
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return Exito;
    }  


    public boolean Borrar(int i) {
        boolean Exito = false;

        try (Connection cnx = gestor.obtenerConexion();
             PreparedStatement stm = cnx.prepareStatement(CMD_BORRAR);) {

            stm.clearParameters();
            stm.setInt(1, i);

            Exito = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return Exito;
    }

    public List<Producto> ListarNombre(String nombre) {
        List<Producto> lista = new ArrayList();

        try (Connection cnx = gestor.obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_LISTARNOMBRE);) {

            stm.clearParameters();
            stm.setString(1, "%" + nombre + "%");

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
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

    public List<Producto> ListarTipo(String tipo) {
        List<Producto> lista = new ArrayList();

        try (Connection cnx = gestor.obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_LISTARTIPO);) {

            stm.clearParameters();
            stm.setString(1, tipo);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
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
    
    public Producto recuperarProducto(int id) {
        Producto producto = null;

        try (Connection cnx = gestor.obtenerConexion();
             PreparedStatement stm = cnx.prepareStatement(CMD_BUSCARID);) {

            stm.clearParameters();
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                producto = new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("Nombre"),
                        rs.getInt("Cantidad"),
                        rs.getString("Descripcion"),
                        rs.getDouble("Precio"),
                        rs.getString("Tipo"),
                        rs.getDouble("Longitud"),
                        rs.getString("CapacidadTrabajo")
                );
            }

        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return producto;
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
            = "SELECT idProducto, Nombre, Precio, Cantidad, Descripcion, Tipo, Longitud, CapacidadTrabajo FROM producto where Nombre like ?;";

    private static final String CMD_LISTARTIPO
            = "SELECT idProducto, Nombre, Precio, Cantidad, Descripcion, Tipo, Longitud, CapacidadTrabajo FROM producto where Tipo like ?;";

    private static final String CMD_BUSCARID
            = "SELECT idProducto, Nombre, Precio, Cantidad, Descripcion, Precio, Tipo, Longitud, CapacidadTrabajo FROM producto where idProducto = ?;";


}

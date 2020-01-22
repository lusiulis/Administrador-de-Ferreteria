package ferreteria.model.DAO;

import ferreteria.model.entidades.Producto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductoDAO {
    private Properties cfg;
    private String baseDatos;
    private String usuario;
    private String clave;
    
    private static ProductoDAO instancia = null;
    

    private ProductoDAO() {
        this.cfg = new Properties();
        try{
            this.cfg.load(getClass().getResourceAsStream("configuracion.properties"));
            this.baseDatos = cfg.getProperty("base_datos");
            this.usuario = cfg.getProperty("usuario");
            this.clave = cfg.getProperty("clave");
        }catch(IOException ex){
            System.out.println("Excepción: "+ex.getMessage());
        }
    }
    
    public static ProductoDAO getInstancia(){
        if(instancia == null){
            instancia = new ProductoDAO();
        }
        return instancia;
    }
    
    private Connection getConexion() throws SQLException{
        return GestorBD.obtenerInstancia().obtenerConexion(baseDatos, usuario, clave);
    }
    
    public boolean agregar(Producto nuevo) throws SQLException {
        boolean exito = false;

        try (Connection cnx = getConexion();
            PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setInt(1, nuevo.getId());
            stm.setString(2, nuevo.getNombre());
            stm.setDouble(3, nuevo.getPrecio());
            stm.setInt(4, nuevo.getCantidad());
            stm.setString(5, nuevo.getDescripcion());
            stm.setString(6, nuevo.getProvedor());
            stm.setInt(7, nuevo.getIdTipo());
            stm.setInt(8, nuevo.getIdFactura());

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }
    
    public List<Producto> listar() throws SQLException {
        List<Producto> r = new ArrayList<>();

        try (Connection cnx = getConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

            while (rs.next()) {
                r.add(new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Cantidad"),
                        rs.getString("Descripcion"),
                        rs.getString("Provedor"),
                        rs.getInt("idTipo"),
                        rs.getInt("idFactura")
                ));
            }
        }
        return r;
    }
    
    public List<Producto> listarIdTipo(int i) throws SQLException {
        List<Producto> r = new ArrayList<>();

        try (Connection cnx = getConexion();
             PreparedStatement stm = cnx.prepareStatement(CMD_LISTAR_IDTIPO);) {
            
            stm.setInt(1, i);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                r.add(new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Cantidad"),
                        rs.getString("Descripcion"),
                        rs.getString("Provedor"),
                        rs.getInt("idTipo"),
                        rs.getInt("idFactura")
                ));
            }
        }
        return r;
    }
    
    public List<Producto> listarIdFactura(int i) throws SQLException {
        List<Producto> r = new ArrayList<>();

        try (Connection cnx = getConexion();
             PreparedStatement stm = cnx.prepareStatement(CMD_LISTAR_IDFACTURA);) {
            
            stm.setInt(1, i);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                r.add(new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Cantidad"),
                        rs.getString("Descripcion"),
                        rs.getString("Provedor"),
                        rs.getInt("idTipo"),
                        rs.getInt("idFactura")
                ));
            }
        }
        return r;
    }
    
    public List<Producto> listarNombre(String i) throws SQLException {
        List<Producto> r = new ArrayList<>();

        try (Connection cnx = getConexion();
             PreparedStatement stm = cnx.prepareStatement(CMD_LISTAR_NOMBRE);) {
            
            stm.setString(1, "%"+i+"%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                r.add(new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio"),
                        rs.getInt("Cantidad"),
                        rs.getString("Descripcion"),
                        rs.getString("Provedor"),
                        rs.getInt("idTipo"),
                        rs.getInt("idFactura")
                ));
            }
        }
        return r;
    }
    
    public boolean Borrar(int i) throws SQLException{
         boolean exito = false;
         
         try(Connection cnx = getConexion();
             PreparedStatement stm = cnx.prepareStatement(CMD_BORRAR);
              ){           
             stm.setInt(1, i);
             exito = stm.executeUpdate() == 1;            
         }
 
         return exito;
     }
    
    private static final String CMD_AGREGAR
            = "INSERT INTO producto (idProducto, Nombre, Precio, Cantidad, Descripcion, Provedor, idTipo, idFactura) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    
    private static final String CMD_LISTAR
            = "SELECT idProducto, Nombre, Precio, Cantidad, Descripcion, Provedor, idTipo, idFactura FROM producto;";

    private static final String CMD_LISTAR_IDTIPO
            = "SELECT idProducto, Nombre, Precio, Cantidad, Descripcion, Provedor, idTipo, idFactura FROM producto where idTipo=?;";
    
    private static final String CMD_LISTAR_NOMBRE
            = "SELECT idProducto, Nombre, Precio, Cantidad, Descripcion, Provedor, idTipo, idFactura FROM producto where Nombre like ?;";
    
    private static final String CMD_LISTAR_IDFACTURA
            = "SELECT idProducto, Nombre, Precio, Cantidad, Descripcion, Provedor, idTipo, idFactura FROM producto where idFactura=?;";
    
    private static final String CMD_BORRAR
            = "delete from producto where idProducto=?";
}

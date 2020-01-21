package ferreteria.model.DAO;

import ferreteria.model.entidades.TipoProducto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TipoProductoDAO {
    
    private Properties cfg;
    private String baseDatos;
    private String usuario;
    private String clave;
    
    private static TipoProductoDAO instancia = null;

    private static final String CMD_AGREGAR
            = "INSERT INTO tipo (idTipo, tipo, Longitud, CapacidadTrabajo) "
            + "VALUES (?, ?, ?, ?);";
    
     private static final String CMD_LISTAR
            = "SELECT idTipo, tipo, Longitud, CapacidadTrabajo FROM tipo;";
    
    public static TipoProductoDAO getInstancia(){
        if (instancia == null) {
            instancia = new TipoProductoDAO();
        }
        return instancia;
    }
     
     private TipoProductoDAO() {
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
 
    private Connection getConexion() throws SQLException{
        return GestorBD.obtenerInstancia().obtenerConexion(baseDatos, usuario, clave);
    }
    
     public boolean agregar(TipoProducto nuevo) throws SQLException {
        boolean exito = false;

        try (Connection cnx = getConexion();
            PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setInt(1, nuevo.getId());
            stm.setString(2, nuevo.getTipo());
            stm.setDouble(3, nuevo.getLongitud());
            stm.setString(4, nuevo.getCapacidadTrabajo());

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }
     
     public List<TipoProducto> listar() throws SQLException {
        List<TipoProducto> r = new ArrayList<>();

        try (Connection cnx = getConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

            while (rs.next()) {
                r.add(new TipoProducto(
                        rs.getInt("idTipo"),
                        rs.getString("tipo"),
                        rs.getDouble("Longitud"),
                        rs.getString("CapacidadTrabajo")
                ));
            }
        }

        return r;
    }
     
     
}

package ferreteria.model.DAO;

import ferreteria.model.entidades.Factura;
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

public class FacturaDAO {
    private Properties cfg;
    private String baseDatos;
    private String usuario;
    private String clave;
    
    private static FacturaDAO instancia = null;

    private FacturaDAO() {
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
    
    public FacturaDAO getInstancia(){
        if(instancia == null){
            instancia = new FacturaDAO();
        }
        return instancia;
    }
    
    private Connection getConexion() throws SQLException{
        return GestorBD.obtenerInstancia().obtenerConexion(baseDatos, usuario, clave);
    }
    
    public boolean agregar(Factura nuevo) throws SQLException {
        boolean exito = false;

        try (Connection cnx = getConexion();
            PreparedStatement stm = cnx.prepareStatement(CMD_AGREGAR)) {
            stm.clearParameters();
            stm.setInt(1, nuevo.getId());
            stm.setString(2, nuevo.getFecha());
            stm.setString(3, nuevo.getVendedor());
            stm.setDouble(4, nuevo.getTotal());
            stm.setDouble(5, nuevo.getSubTotal());
            stm.setDouble(6, nuevo.getImpuesto());
            stm.setDouble(7, nuevo.getDescuento());

            exito = stm.executeUpdate() == 1;
        }

        return exito;
    }
    
    public List<Factura> listar() throws SQLException {
        List<Factura> r = new ArrayList<>();

        try (Connection cnx = getConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

            while (rs.next()) {
                r.add(new Factura(
                        rs.getInt("idFactura"),
                        rs.getString("Fecha"),
                        rs.getString("Vendedor"),
                        rs.getDouble("Total"),
                        rs.getDouble("SubTotal"),
                        rs.getDouble("Impuesto"),
                        rs.getDouble("Descuento")
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
            = "INSERT INTO factura (idFactura, Fecha, Vendedor, Total, SubTotal, Impuesto, Descuento) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?);";
     
     private static final String CMD_LISTAR
            = "SELECT idFactura, Fecha, Vendedor, Total, SubTotal, Impuesto, Descuento FROM factura;";

      private static final String CMD_BORRAR
            = "delete from factura where idFactura=?";
}

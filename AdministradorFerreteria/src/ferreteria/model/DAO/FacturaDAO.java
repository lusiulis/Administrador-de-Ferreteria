package ferreteria.model.DAO;

import ferreteria.model.entidades.Factura;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FacturaDAO {

    private final GestorBD gestor;

    private static FacturaDAO instancia = null;

    private FacturaDAO() {
        this.gestor = GestorBD.obtenerInstancia();
    }

    public static FacturaDAO getInstancia() {
        if (instancia == null) {
            instancia = new FacturaDAO();
        }
        return instancia;
    }

    public int AgregarFactura(Factura nuevo) {
        int id = 0;
        try (Connection cnx = gestor.obtenerConexion();
             PreparedStatement stm = cnx.prepareStatement(CMD_AGREGARFACTURA)) {

            stm.clearParameters();
            stm.setDate(1, new Date(1,1,1));
            stm.setString(2, nuevo.getVendedor());
            stm.setDouble(3, nuevo.getTotal());

            stm.executeUpdate();
            
            Statement st = cnx.createStatement();
            st.execute(CMD_ULTIMO);
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return id;
    }

    private static final String CMD_AGREGARFACTURA
            = "INSERT INTO factura (Fecha, Vendedor, Total) "
            + "VALUES (?, ?, ?)";
    
    private static final String CMD_ULTIMO
            = "select @last_id := max(idFactura) from factura";
}

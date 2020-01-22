package ferreteria.model.DAO;

import ferreteria.model.entidades.Factura;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public boolean AgregarFactura(Factura nuevo) {
        boolean Exito = false;

        try (Connection cnx = gestor.obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGARFACTURA)) {

            stm.clearParameters();
            stm.setDate(1, Date.valueOf(nuevo.getFecha()));
            stm.setString(2, nuevo.getVendedor());
            stm.setDouble(3, nuevo.getTotal());

            Exito = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return Exito;
    }

    private static final String CMD_AGREGARFACTURA
            = "INSERT INTO factura (Fecha, Vendedor, Total) "
            + "VALUES (?, ?, ?)";
}

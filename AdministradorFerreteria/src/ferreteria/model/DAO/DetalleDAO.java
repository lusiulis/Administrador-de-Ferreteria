package ferreteria.model.DAO;

import ferreteria.model.entidades.Detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DetalleDAO {

    private final GestorBD gestor;

    private static DetalleDAO instancia = null;

    private DetalleDAO() {
        this.gestor = GestorBD.obtenerInstancia();
    }

    public static DetalleDAO getInstancia() {
        if (instancia == null) {
            instancia = new DetalleDAO();
        }
        return instancia;
    }

    public boolean AgregarDetalle(Detalle nuevo) {
        boolean Exito = false;
        try (Connection cnx = gestor.obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_AGREGARDETALLE);) {

            stm.clearParameters();
            stm.setInt(1, nuevo.getCantidad());
            stm.setInt(2, nuevo.getIdFactura());
            stm.setInt(3, nuevo.getIdProducto());

            Exito = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return Exito;
    }

    private static final String CMD_AGREGARDETALLE
            = "INSERT INTO detalle (Cantidad, idFactura, idProducto) "
            + "VALUES (?, ?, ?)";
}

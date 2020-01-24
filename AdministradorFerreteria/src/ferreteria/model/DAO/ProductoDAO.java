package ferreteria.model.DAO;

import ferreteria.model.entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        if (nuevo.getTipo().equals("Material")) {
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
    
    public boolean LLenarInventario(){
        boolean Exito = false;
        try (Connection cnx = gestor.obtenerConexion();
             PreparedStatement stm = cnx.prepareStatement(CMD_LLENARINVENTARIO);) {

            stm.clearParameters();
            Exito = stm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return Exito;
    }
    
    public boolean Modificar(Producto nuevo){
        boolean Exito = false;

        try(Connection cnx = gestor.obtenerConexion();
            PreparedStatement smt = cnx.prepareStatement(CMD_MODIFICAR)){
            
            smt.clearParameters();
            smt.setString(1, nuevo.getNombre());
            smt.setInt(2, nuevo.getCantidad());
            smt.setString(3, nuevo.getDescripcion());
            smt.setDouble(4, nuevo.getPrecio());
            smt.setString(5, nuevo.getTipo());
            smt.setDouble(6, nuevo.getLongitud());
            smt.setString(7, nuevo.getCapacidadTrabajo());
            smt.setInt(8, nuevo.getId());
            
            Exito = smt.executeUpdate() == 1;
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
            while (rs.next()) {
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

    public List<Producto> listarTipoYNombre(String nombre, String tipo) {
        List<Producto> lista = new ArrayList();

        try (Connection cnx = gestor.obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_LISTARAMBOS);) {

            stm.clearParameters();
            stm.setString(1, tipo);
            stm.setString(2, nombre);

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

    private static final String CMD_LISTARAMBOS
            = "SELECT idProducto, Nombre, Precio, Cantidad, Descripcion, Precio, Tipo, Longitud, CapacidadTrabajo FROM producto where Tipo like ? AND Nombre like ?;";

    private static final String CMD_MODIFICAR
            = "UPDATE producto Set Nombre = ?, Cantidad = ?, Descripcion = ?, Precio =  ?, Tipo = ?, Longitud = ?, CapacidadTrabajo = ? WHERE idProducto = ?;";
    
    private static final String CMD_LLENARINVENTARIO
            = "INSERT into producto (idProducto,Nombre,Cantidad,Descripcion,Precio,Tipo,Longitud,CapacidadTrabajo) VALUES \n" +
            "('2','Clavos','10','Kilos de Clavos','2000','Material','13',null),\n" +
            "('3','Martillo','13','Martillo Pioner','11150','Herramienta',null,'Mediano'),\n" +
            "('4','Clavos','20','Kilos de Clavos','1500','Material','5.5',null),\n" +
            "('5','Tornillos','15','Kilos de Tornillos','1000','Material','2.5',null),\n" +
            "('6','Pala','50','Pala de desagues','10000','Herramienta',null,'Liviano'),\n" +
            "('7','Hacha','13','Hacha de acero inoxidable','15000','Herramienta',null,'Mediano'),\n" +
            "('8','Clavos','50','Kilos de Clavos de acero','5000','Material','15.5',null),\n" +
            "('9','Tornillos','25','Kilos de tornillos de acero','5000','Material','15.5',null),\n" +
            "('10','Hacha','13','Hacha de acero inoxidable','15000','Herramienta',null,'Mediano'),\n" +
            "('11','Pico','30','Pico Pioner','20000','Herramienta',null,'Pesado'),\n" +
            "('12','Mazo','35','Mazo para destruccion','20000','Herramienta',null,'Pesado'),\n" +
            "('13','Taladro','23','Taladro electrico con kit de brocas','20000','Herramienta',null,'Liviano'),\n" +
            "('14','Maquina de soldar','10','Maquina de soldar Pioner','20000','Herramienta',null,'Pesado'),\n" +
            "('15','Clavos','33','Kilos de Clavos de acero','10000','Material','25.5',null)";
}

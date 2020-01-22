package ferreteria.model.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GestorBD {

    private GestorBD() {
        this.cfg = new Properties();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            this.cfg.load(getClass().getResourceAsStream("configuracion.properties"));
            this.baseDatos = cfg.getProperty("base_datos");
            this.usuario = cfg.getProperty("usuario");
            this.clave = cfg.getProperty("clave");
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException | IOException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static GestorBD obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorBD();
        }
        return instancia;
    }

    public Connection obtenerConexion()
            throws SQLException {
        Connection cnx;
        String URL_conexion
                = String.format("%s//%s/%s",
                        "jdbc:mysql:", "localhost", baseDatos);

        cnx = DriverManager.getConnection(URL_conexion, usuario, clave);
        return cnx;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getBaseDatos() {
        return baseDatos;
    }
    
    private Properties cfg;
    private String baseDatos;
    private String usuario;
    private String clave;
    
    private static GestorBD instancia = null;
}

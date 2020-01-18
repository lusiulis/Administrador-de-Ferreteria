package administradorferreteria;

import ferrateria.control.ControlFerreteria;
import ferreteria.views.VentanaInventario;
import ferreteria.views.VentanaFacturacion;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AdministradorFerreteria {

    public static void main(String[] args) {
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        xD xd = new xD();
        new AdministradorFerreteria().iniciar();
    }

    private void iniciar() {
       
        SwingUtilities.invokeLater(() -> {
            new VentanaFacturacion( new ControlFerreteria()).init();
        });
    }
}

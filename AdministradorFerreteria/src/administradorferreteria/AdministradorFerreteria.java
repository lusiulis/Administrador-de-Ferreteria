package administradorferreteria;

import ferrateria.control.ControlFerreteria;
import ferreteria.views.VentanaInventario;

public class AdministradorFerreteria {

    public static void main(String[] args) {
        ControlFerreteria gestor = new ControlFerreteria();
        VentanaInventario ventana = new VentanaInventario(gestor);
    }
    
}

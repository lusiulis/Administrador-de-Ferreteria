package administradorferreteria;

import ferrateria.control.ControlFerreteria;
import ferreteria.views.Ventana;

public class AdministradorFerreteria {

    public static void main(String[] args) {
        ControlFerreteria gestor = new ControlFerreteria();
        Ventana ventana = new Ventana(gestor);
    }
    
}

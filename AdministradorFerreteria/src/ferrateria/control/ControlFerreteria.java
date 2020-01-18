/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrateria.control;

import ferreteria.model.ModeloFerreteria;
import ferreteria.views.VentanaFacturacion;
import java.util.Observer;

/**
 *
 * @author lusiu
 */
public class ControlFerreteria {

    private final ModeloFerreteria modelo;

    public ControlFerreteria() {
        modelo = new ModeloFerreteria();
    }

    public void registrar(Observer observador) {
        modelo.addObserver(observador);
    }

    public void cerrarAplicacion() {
        modelo.deleteObservers();
        System.exit(0);
    }

    public void suprimir(Observer observador) {
        modelo.deleteObserver(observador);
        if (modelo.countObservers() == 0) {
            System.exit(0);
        }
    }

}

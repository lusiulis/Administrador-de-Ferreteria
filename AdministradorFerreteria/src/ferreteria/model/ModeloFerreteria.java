/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.model;

import ferreteria.model.DAO.ProductoDAO;
import ferreteria.model.entidades.Detalle;
import ferreteria.model.entidades.Factura;
import ferreteria.model.entidades.Producto;
import java.util.Observable;

/**
 *
 * @author lusiu
 */
public class ModeloFerreteria extends Observable {

    private Factura facturaActual;

    public ModeloFerreteria() {
        facturaActual = new Factura();
    }

    public void agregarProducto(Integer codigo, Integer cantidad) {

        Producto pro = ProductoDAO.getInstancia().recuperarProducto(codigo);
        if (pro != null && pro.getCantidad() > cantidad) {
            facturaActual.agregarDetalle(new Detalle(null, cantidad, null, codigo));
        }else{
            //no se pudo agregar
        }
        setChanged();
        notifyObservers(facturaActual);
    }

    public void cancelarFactura() {
        //TODO
        //agregar a bd todos los productos que pertenecen a factura actual

        //final TODO
        facturaActual = new Factura();
        setChanged();
        notifyObservers(facturaActual);
    }

    public void vender() {
        //TODO
        //agregar venta a bd
        //Final TODO
        facturaActual = new Factura();
        setChanged();
        notifyObservers(facturaActual);
    }

    public void getFacturaActual() {
        setChanged();
        notifyObservers(facturaActual);
    }

    public void eliminarArticulo(int row) {
        //Producto productoRemovido = facturaActual.getProductos().remove(row);
        //TODO
        //agregar productoRemovido a base de datos
        //Final TODO
        //facturaActual.actualizarTotales();
        setChanged();
        notifyObservers(facturaActual);
    }

}

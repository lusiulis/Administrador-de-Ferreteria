/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrateria.control;

import ferreteria.model.DAO.ProductoDAO;
import ferreteria.model.ModeloFerreteria;
import ferreteria.model.entidades.Producto;
import java.util.List;
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

    public void agregarProductoAFactura(Integer codigo, Integer cantidad) {
        modelo.agregarProducto(codigo, cantidad);
    }

    public void cancelarFactura() {
        modelo.cancelarFactura();
    }

    public void vender(String vendedor) {
        modelo.vender(vendedor);
    }

    public void solicitarFacturaActual() {
        modelo.getFacturaActual();
    }

    public void eliminarArticuloDeFactura(Integer numeroArt) {
        modelo.eliminarArticulo(numeroArt);
    }

    public List<Producto> buscarArticulos(String nombreProducto, String tipoProducto) {
        if (nombreProducto.equals("")) {
            if (!tipoProducto.equals("Ambos")) {
                return ProductoDAO.getInstancia().ListarTipo(tipoProducto);
            }
            return ProductoDAO.getInstancia().ListarNombre(nombreProducto);
        }
        return ProductoDAO.getInstancia().listarTipoYNombre(nombreProducto, tipoProducto);
    }

    public Boolean eliminarDeInventario(Integer codigoArticulo) {
        return ProductoDAO.getInstancia().Borrar(codigoArticulo);
    }

    public Boolean agregarAInventario(Producto productoNuevo) {
        return ProductoDAO.getInstancia().AgregarProducto(productoNuevo);
    }

    public Boolean modificarEnInventario(Producto productoAModificar) {
        return ProductoDAO.getInstancia().Modificar(productoAModificar);
    }

    public Producto getProducto(Integer codigoProducto) {
        return ProductoDAO.getInstancia().recuperarProducto(codigoProducto);
    }
}

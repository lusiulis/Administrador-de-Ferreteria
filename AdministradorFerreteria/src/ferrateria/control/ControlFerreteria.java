package ferrateria.control;

import ferreteria.model.DAO.ProductoDAO;
import ferreteria.model.ModeloFerreteria;
import ferreteria.model.entidades.Producto;
import java.util.List;
import java.util.Observer;

public class ControlFerreteria {

    private final ModeloFerreteria modelo;

    public ControlFerreteria() {
        modelo = new ModeloFerreteria();
        iniciarContadorTransacciones();
    }

    public void registrar(Observer observador) {
        modelo.addObserver(observador);
    }

    public void cerrarAplicacion() {
        modelo.deleteObservers();
        modelo.detenerContadorTransacciones();
        System.exit(0);
    }

    public void suprimir(Observer observador) {
        modelo.deleteObserver(observador);
        if (modelo.countObservers() == 0) {
            modelo.detenerContadorTransacciones();
            System.exit(0);
        }
    }

    public void agregarProductoAFactura(Integer codigo, Integer cantidad) {
        modelo.agregarProducto(codigo, cantidad);
        modelo.aumentarTransacciones();
    }

    public void cancelarFactura() {
        modelo.cancelarFactura();
        modelo.aumentarTransacciones();
    }

    public void vender(String vendedor) {
        modelo.vender(vendedor);
        modelo.aumentarTransacciones();
    }

    public void solicitarFacturaActual() {
        modelo.getFacturaActual();
        modelo.aumentarTransacciones();
    }

    public void eliminarArticuloDeFactura(Integer numeroArt) {
        modelo.eliminarArticulo(numeroArt);
        modelo.aumentarTransacciones();
    }

    public List<Producto> buscarArticulos(String nombreProducto, String tipoProducto) {
        modelo.aumentarTransacciones();
        if (nombreProducto.equals("")) {
            if (!tipoProducto.equals("Ambos")) {
                return ProductoDAO.getInstancia().ListarTipo(tipoProducto);
            }
            return ProductoDAO.getInstancia().ListarNombre(nombreProducto);
        }
        return ProductoDAO.getInstancia().listarTipoYNombre(nombreProducto, tipoProducto);
    }

    public Boolean eliminarDeInventario(Integer codigoArticulo) {
        modelo.aumentarTransacciones();
        return ProductoDAO.getInstancia().Borrar(codigoArticulo);
    }

    public Boolean agregarAInventario(Producto productoNuevo) {
        modelo.aumentarTransacciones();
        return ProductoDAO.getInstancia().AgregarProducto(productoNuevo);
    }

    public Boolean modificarEnInventario(Producto productoAModificar) {
        modelo.aumentarTransacciones();
        return ProductoDAO.getInstancia().Modificar(productoAModificar);
    }

    public Producto getProducto(Integer codigoProducto) {
        modelo.aumentarTransacciones();
        return ProductoDAO.getInstancia().recuperarProducto(codigoProducto);
    }
    
    private void iniciarContadorTransacciones(){
        modelo.iniciarContadorTransacciones();
    }
    
    public void LlenarInvantario(){
        modelo.LlenarInventario();
    }
}

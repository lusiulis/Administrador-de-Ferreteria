package ferreteria.model;

import ferreteria.model.DAO.DetalleDAO;
import ferreteria.model.DAO.FacturaDAO;
import ferreteria.model.DAO.ProductoDAO;
import ferreteria.model.entidades.Detalle;
import ferreteria.model.entidades.Factura;
import ferreteria.model.entidades.Producto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ModeloFerreteria extends Observable {

    private Factura facturaActual;
    private Integer cantTransacciones;//cantidad de transacciones realizadas 
    private ScheduledExecutorService exec;

    public ModeloFerreteria() {
        facturaActual = new Factura();
        cantTransacciones = 0;
    }

    public void agregarProducto(Integer codigo, Integer cantidad) {

        Producto pro = ProductoDAO.getInstancia().recuperarProducto(codigo);
        if (pro != null && pro.getCantidad() > cantidad) {
            facturaActual.agregarDetalle(new Detalle(null, cantidad, null, codigo));
        } else {
            //no se pudo agregar
        }
        setChanged();
        notifyObservers(facturaActual);
    }

    public void cancelarFactura() {
        facturaActual = new Factura();
        setChanged();
        notifyObservers(facturaActual);
    }

    public void vender(String vendedor) {
        facturaActual.setVendedor(vendedor);
        facturaActual.setFecha(LocalDate.now());
        int idFactura = FacturaDAO.getInstancia().AgregarFactura(facturaActual);
        for (Detalle d : facturaActual.getDetalles()) {
            d.setIdFactura(idFactura);
            DetalleDAO.getInstancia().AgregarDetalle(d);
            Producto producto = ProductoDAO.getInstancia().recuperarProducto(d.getIdProducto());
            producto.setCantidad(producto.getCantidad() - d.getCantidad());
            ProductoDAO.getInstancia().Modificar(producto);
        }

        facturaActual = new Factura();
        setChanged();
        notifyObservers(facturaActual);
    }

    public void getFacturaActual() {
        setChanged();
        notifyObservers(facturaActual);
    }

    public void eliminarArticulo(Integer posicion) {
        facturaActual.remover(posicion);
        setChanged();
        notifyObservers(facturaActual);
    }

    public void aumentarTransacciones() {
        cantTransacciones++;
    }

    public void iniciarContadorTransacciones() {
        exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {

            Integer actualizaciones = 0;
            List<Integer> transaccionesRealizadasCadaMinuto = new ArrayList();

            @Override
            public void run() {
                Integer sumaTotalTransacciones = 0;
                for (Integer i : transaccionesRealizadasCadaMinuto) {
                    sumaTotalTransacciones += i;
                }
                setChanged();
                if (transaccionesRealizadasCadaMinuto.size() == 0) {
                    notifyObservers("Promedio Transacciones/minuto: " + 0 + "                Transacciones este minuto: " + cantTransacciones + "                Minutos en ejecucion: " + 0);

                } else {
                    notifyObservers("Promedio Transacciones/minuto: " + sumaTotalTransacciones / transaccionesRealizadasCadaMinuto.size() + "                Transacciones este minuto: " + cantTransacciones + "                Minutos en ejecucion: " + transaccionesRealizadasCadaMinuto.size());
                }
                actualizaciones++;
                if (actualizaciones == 120) {
                    actualizaciones = 0;
                    transaccionesRealizadasCadaMinuto.add(cantTransacciones);
                    cantTransacciones = 0;
                }
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }

    public void detenerContadorTransacciones() {
        exec.shutdown();
    }
}

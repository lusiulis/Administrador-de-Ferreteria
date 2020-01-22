package ferreteria.model.entidades;

import ferreteria.model.DAO.ProductoDAO;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura implements Serializable {

    private Integer id;
    private String vendedor;
    private Double total;
    private LocalDate fecha;
    private List<Detalle> detalles;

    public Factura() {
        detalles = new ArrayList<>();
    }

    public Factura(Integer id, String vendedor, Double total, LocalDate fecha, List<Detalle> detalles) {
        this.id = id;
        this.vendedor = vendedor;
        this.total = total;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", Fecha=" + fecha + ", Vendedor=" + vendedor + ", Total=" + total + ", Detalles=" + detalles + '}';
    }

    public void agregarDetalle(Detalle detalle) {
        detalles.add(detalle);
        total = 0d;
        for (Detalle d : detalles) {
            total += d.getCantidad() * (ProductoDAO.getInstancia().recuperarProducto(d.getIdProducto()).getPrecio());
        }
    }

}

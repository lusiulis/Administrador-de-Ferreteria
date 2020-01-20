package ferreteria.model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Factura implements Serializable{
    
    private int id;
    private String Fecha;
    private String Vendedor;
    private double Total;
    private double SubTotal;
    private double Impuesto;
    private double Descuento;
    
    private List<Producto> productos;

    public Factura() {
        productos = new ArrayList();
    }

    public Factura(int id, String Fecha, String Vendedor, double Total, double SubTotal, double Impuesto, double Descuento, List<Producto> productos) {
        this.id = id;
        this.Fecha = Fecha;
        this.Vendedor = Vendedor;
        this.Total = Total;
        this.SubTotal = SubTotal;
        this.Impuesto = Impuesto;
        this.Descuento = Descuento;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(double Impuesto) {
        this.Impuesto = Impuesto;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", Fecha=" + Fecha + ", Vendedor=" + Vendedor + ", Total=" + Total + ", SubTotal=" + SubTotal + ", Impuesto=" + Impuesto + ", Descuento=" + Descuento + ", productos=" + productos + '}';
    }
    
}

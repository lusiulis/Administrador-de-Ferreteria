package ferreteria.model.entidades;

import java.io.Serializable;

public class Producto implements Serializable {
    
    private int id;
    private String Nombre;
    private double Precio;
    private int Cantidad;
    private String Descripcion;
    private String Provedor;
    private int idTipo;
    private int idFactura;

    private TipoProducto tipo;
    private Factura factura;
    
    public Producto() {
        tipo = new TipoProducto();
        factura = new Factura();
    }

    public Producto(int id, String Nombre, double Precio, int Cantidad, String Descripcion, String Provedor, int idTipo, int idFactura) {
        this.id = id;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.Descripcion = Descripcion;
        this.Provedor = Provedor;
        this.idTipo = idTipo;
        this.idFactura = idFactura;
    }
    
    public Producto(Producto pro){
        this.id = pro.getId();
        this.Nombre = pro.getNombre();
        this.Precio = pro.getPrecio();
        this.Cantidad = pro.getCantidad();
        this.Descripcion = pro.getDescripcion();
        this.Provedor = pro.getProvedor();
        this.idTipo = pro.getId();
        this.idFactura = pro.getIdFactura();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getProvedor() {
        return Provedor;
    }

    public void setProvedor(String Provedor) {
        this.Provedor = Provedor;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", Nombre=" + Nombre + ", Precio=" + Precio + ", Cantidad=" + Cantidad + ", Descripcion=" + Descripcion + ", Provedor=" + Provedor + ", idTipo=" + idTipo + ", idFactura=" + idFactura + '}';
    }
    
    
}

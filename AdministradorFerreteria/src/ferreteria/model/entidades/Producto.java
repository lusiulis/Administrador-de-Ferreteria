package ferreteria.model.entidades;

import java.io.Serializable;

public class Producto implements Serializable {

    private int id;
    private String nombre;
    private Integer cantidad;//cantidad en inventario 
    private String descripcion;
    private Double precio; //precio por unidad
    private String tipo;//herramienta o material
    private Double Longitud;
    private String capacidadTrabajo;

    public Producto() {
    }

    public Producto(int id, String nombre, Integer cantidad, String descripcion, Double precio, String tipo, Double Longitud, String capacidadTrabajo) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.Longitud = Longitud;
        this.capacidadTrabajo = capacidadTrabajo;
    }

    public Producto(Producto pro){
        this.id = new Integer(pro.getId());
        this.nombre = new String(pro.getNombre());
        this.cantidad = new Integer(pro.getCantidad());
        this.descripcion = pro.getDescripcion();
        this.precio = new Double(pro.getPrecio());
        this.tipo = new String(pro.getTipo());
        this.Longitud = pro.getLongitud();
        this.capacidadTrabajo = pro.getCapacidadTrabajo();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double Longitud) {
        this.Longitud = Longitud;
    }

    public String getCapacidadTrabajo() {
        return capacidadTrabajo;
    }

    public void setCapacidadTrabajo(String capacidadTrabajo) {
        this.capacidadTrabajo = capacidadTrabajo;
    }

    

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", Nombre=" + nombre + ", Precio=" + precio + ", Cantidad=" + cantidad + ", Descripcion=" + descripcion + "'}'";
    }

}

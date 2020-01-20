package ferreteria.model.entidades;

import java.io.Serializable;

public class TipoProducto implements Serializable{
    private int id;
    private String tipo;
    private double Longitud;
    private String CapacidadTrabajo;

    public TipoProducto() {
    }

    public TipoProducto(int id, String tipo, double Longitud, String CapacidadTrabajo) {
        this.id = id;
        this.tipo = tipo;
        this.Longitud = Longitud;
        this.CapacidadTrabajo = CapacidadTrabajo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double Longitud) {
        this.Longitud = Longitud;
    }

    public String getCapacidadTrabajo() {
        return CapacidadTrabajo;
    }

    public void setCapacidadTrabajo(String CapacidadTrabajo) {
        this.CapacidadTrabajo = CapacidadTrabajo;
    }

    @Override
    public String toString() {
        return "tipo{" + "id=" + id + ", tipo=" + tipo + ", Longitud=" + Longitud + ", CapacidadTrabajo=" + CapacidadTrabajo + '}';
    }
    
    
}

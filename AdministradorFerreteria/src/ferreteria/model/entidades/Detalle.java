/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.model.entidades;

import java.io.Serializable;

/**
 *
 * @author Kevin
 */
public class Detalle implements Serializable {
    private Integer id;
    private Integer cantidad; //cantidad del producto que se compro
    private Integer idFactura; //factura a la que pertenece el detalle
    private Integer idProducto;

    public Detalle() {
    }

    public Detalle(Integer id, Integer cantidad, Integer idFactura, Integer idProducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    
}

package com.turing.santabarbara.model.clas;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Producto {
    private IntegerProperty idProducto;
    private StringProperty producto;
    private StringProperty compuesto;
    private StringProperty lote;
    private StringProperty cantidad;
    private StringProperty caducidad;
    private DoubleProperty precio;
    private StringProperty proveedor;
    private StringProperty almacen;

    public Producto() {
        this.idProducto = null;
        this.producto = null;
        this.compuesto = null;
        this.lote = null;
        this.cantidad = null;
        this.caducidad = null;
        this.precio = null;
        this.proveedor = null;
        this.almacen = null;
    }

    public Producto(Integer idProducto, String producto, String compuesto, 
            String lote, String cantidad, String caducidad, double precio, 
            String proveedor, String almacen) {
        this.idProducto = new SimpleIntegerProperty(idProducto);
        this.producto = new SimpleStringProperty(producto);
        this.compuesto = new SimpleStringProperty(compuesto);
        this.lote = new SimpleStringProperty(lote);
        this.cantidad = new SimpleStringProperty(cantidad);
        this.caducidad = new SimpleStringProperty(caducidad);
        this.precio = new SimpleDoubleProperty(precio);
        this.proveedor = new SimpleStringProperty(proveedor);
        this.almacen = new SimpleStringProperty(almacen);
    }

    public Integer getIdProducto() {
        return idProducto.get();
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto =new SimpleIntegerProperty(idProducto);
    }

    public String getProducto() {
        return producto.get();
    }

    public void setProducto(String producto) {
        this.producto = new SimpleStringProperty(producto);
    }

    public String getCompuesto() {
        return compuesto.get();
    }

    public void setCompuesto(String compuesto) {
        this.compuesto = new SimpleStringProperty(compuesto);
    }

    public String getLote() {
        return lote.get();
    }

    public void setLote(String lote) {
        this.lote = new SimpleStringProperty(lote);
    }

    public String getCantidad() {
        return cantidad.get();
    }

    public Double getPrecio() {
        return precio.get();
    }

    public void setPrecio(Double precio) {
        this.precio = new SimpleDoubleProperty(precio);
    }

    public void setCantidad(String cantidad) {
        this.cantidad = new SimpleStringProperty(cantidad);
    }

    public String getCaducidad() {
        return caducidad.get();
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = new SimpleStringProperty(caducidad);
    }

    public String getProveedor() {
        return proveedor.get();
    }

    public void setProveedor(String proveedor) {
        this.proveedor = new SimpleStringProperty(proveedor);
    }

    public String getAlmacen() {
        return almacen.get();
    }

    public void setAlmacen(String almacen) {
        this.almacen = new SimpleStringProperty(almacen);
    }
    
    public String datos(){
        return this.idProducto.get() + " - " + this.producto.get() + " " 
               + this.compuesto.get();
    }
   
}

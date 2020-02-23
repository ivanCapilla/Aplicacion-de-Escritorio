package com.turing.santabarbara.model.clas;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class CompraProducto {
    private IntegerProperty id;
    private StringProperty folio;
    private StringProperty producto;
    private StringProperty fecha;
    private StringProperty hora;
    private DoubleProperty total;

    public CompraProducto() {
        this.id = null;
        this.folio = null;
        this.producto = null;
        this.fecha = null;
        this.hora = null;
        this.total = null;
    }

    public CompraProducto(Integer id, String folio, String producto, 
            String fecha, String hora, Double total) {
        this.id = new SimpleIntegerProperty(id);
        this.folio = new SimpleStringProperty(folio);
        this.producto = new SimpleStringProperty(producto);
        this.fecha = new SimpleStringProperty(fecha);
        this.hora = new SimpleStringProperty(hora);
        this.total = new SimpleDoubleProperty(total);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getFolio() {
        return folio.get();
    }

    public void setFolio(String folio) {
        this.folio = new SimpleStringProperty(folio);
    }

    public String getProducto() {
        return producto.get();
    }

    public void setProducto(String producto) {
        this.producto = new SimpleStringProperty(producto);
    }
   
    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fecha) {
        this.fecha = new SimpleStringProperty(fecha);
    }

    public String getHora() {
        return hora.get();
    }

    public void setHora(String hora) {
        this.hora = new SimpleStringProperty(hora);
    }

    public Double getTotal() {
        return total.get();
    }

    public void setTotal(Double total) {
        this.total = new SimpleDoubleProperty(total);
    }
   
}

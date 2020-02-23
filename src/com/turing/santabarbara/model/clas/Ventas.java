package com.turing.santabarbara.model.clas;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ventas {
    private IntegerProperty folio;
    private StringProperty articulo;
    private IntegerProperty cantidad;
    private DoubleProperty subtotal;
    private IntegerProperty idCliente;

    public Integer getFolio() {
        return folio.get();
    }

    public void setFolio(Integer folio) {
        this.folio = new SimpleIntegerProperty(folio);
    }

    public String getArticulo() {
        return articulo.get();
    }

    public void setArticulo(String articulo) {
        this.articulo = new SimpleStringProperty(articulo);
    }

    public Integer getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }

    public Double getSubtotal() {
        return subtotal.get();
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = new SimpleDoubleProperty(subtotal);
    }

    public Integer getIdCliente() {
        return idCliente.get();
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = new SimpleIntegerProperty(idCliente);
    }
    
}

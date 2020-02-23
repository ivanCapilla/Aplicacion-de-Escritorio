/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.santabarbara.model.clas;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author rocki
 */
public class Proveedores {
    private IntegerProperty idProveedor;
    private StringProperty nombre;
    private StringProperty direccion;
    private StringProperty telefono;
    private StringProperty rfc;

    public Proveedores() {
        
    }

    public Proveedores(Integer idProveedor, String nombre, String direccion, 
            String telefono, String rfc) {
        this.idProveedor = new SimpleIntegerProperty(idProveedor);
        this.nombre = new SimpleStringProperty(nombre);
        this.direccion = new SimpleStringProperty(direccion);
        this.telefono = new SimpleStringProperty(telefono);
        this.rfc = new SimpleStringProperty(rfc);
    }

    public Integer getIdProveedor() {
        return idProveedor.get();
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = new SimpleIntegerProperty(idProveedor) ;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre) ;
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion = new SimpleStringProperty(direccion);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono = new SimpleStringProperty(telefono);
    }

    public String getRfc() {
        return rfc.get();
    }

    public void setRfc(String rfc) {
        this.rfc = new SimpleStringProperty(rfc);
    }
  
}

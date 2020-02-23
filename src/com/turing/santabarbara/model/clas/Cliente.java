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
 * @author Iván Díaz
 */
public class Cliente {
    private IntegerProperty idCliente;
    private StringProperty nombre;
    private StringProperty apellido;
    private StringProperty fechaReg;
    private StringProperty email;
    private StringProperty telefono;

    public Cliente() {
        this.idCliente = null;
        this.nombre = null;
        this.apellido= null;
        this.fechaReg= null;
        this.email = null;
        this.telefono = null;
    }

    public Cliente(Integer idCliente, String nombre, String apellido, 
            String fechaReg, String email, String telefono) {
        this.idCliente = new SimpleIntegerProperty(idCliente);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.fechaReg = new SimpleStringProperty(fechaReg);
        this.email = new SimpleStringProperty(email);
        this.telefono = new SimpleStringProperty(telefono);
    }

    public Integer getIdCliente() {
        return idCliente.get();
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = new SimpleIntegerProperty(idCliente);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre) ;
    }

    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido = new SimpleStringProperty(apellido);
    }

    public String getFechaReg() {
        return fechaReg.get();
    }

    public void setFechaReg(String fechaReg) {
        this.fechaReg = new SimpleStringProperty(fechaReg);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono = new SimpleStringProperty(telefono);
    }
   
}

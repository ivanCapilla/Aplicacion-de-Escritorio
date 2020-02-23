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
public class Empleado {
    private IntegerProperty idUsuario;
    private StringProperty nombre;
    private StringProperty apeP;
    private StringProperty apeM;
    private StringProperty usuario;
    private StringProperty password;
    private StringProperty email;
    private StringProperty direccion;
    private StringProperty telefono;
    private StringProperty fechaNacimiento;
    private StringProperty fechaIngreso;
    private StringProperty nss;
    private StringProperty rfc;
    private StringProperty curp;
    private IntegerProperty idSuc;
    private IntegerProperty idTurno;
    private IntegerProperty idPuesto;
    private IntegerProperty idImss;
    private IntegerProperty actUsuario;

    public Empleado() {
        this.idUsuario = null;
        this.nombre = null;
        this.apeP = null;
        this.apeM = null;
        this.usuario = null;
        this.password = null;
        this.email = null;
        this.direccion = null;
        this.telefono = null;
        this.fechaNacimiento = null;
        this.fechaIngreso=null;
        this.nss = null;
        this.rfc = null;
        this.curp = null;
        this.idSuc = null;
        this.idTurno = null;
        this.idPuesto = null;
        this.idImss = null;
        this.actUsuario = null;
    }
    
    public Empleado(int idUsuario, String nombre, String apeP, String apeM,
            String usuario, String password, String email, String direccion, 
            String telefono, String fechaNacimiento, String fechaIngreso, 
            String nss, String rfc, String curp, int idSuc, int idTurno, 
            int idPuesto, int idImss, int actUsuario) {
        this.idUsuario = new SimpleIntegerProperty(idUsuario);
        this.nombre = new SimpleStringProperty(nombre);
        this.apeP = new SimpleStringProperty(apeP);
        this.apeM = new SimpleStringProperty(apeM);
        this.usuario = new SimpleStringProperty(usuario);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.direccion = new SimpleStringProperty(direccion);
        this.telefono = new SimpleStringProperty(telefono);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
        this.fechaIngreso = new SimpleStringProperty(fechaIngreso);
        this.nss = new SimpleStringProperty(nss);
        this.rfc = new SimpleStringProperty(rfc);
        this.curp = new SimpleStringProperty(curp);
        this.idSuc = new SimpleIntegerProperty(idSuc);
        this.idTurno = new SimpleIntegerProperty(idTurno);
        this.idPuesto = new SimpleIntegerProperty(idPuesto);
        this.idImss = new SimpleIntegerProperty(idImss);
        this.actUsuario = new SimpleIntegerProperty(actUsuario);
    }
    
    

    public Integer getIdUsuario() {
        return idUsuario.get();
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = new SimpleIntegerProperty(idUsuario);
    }
    

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getApeP() {
        return apeP.get();
    }

    public void setApeP(String apeP) {
        this.apeP = new SimpleStringProperty(apeP);
    }
    public String getApeM() {
        return apeM.get();
    }

    public void setApeM(String apeM) {
        this.apeM = new SimpleStringProperty(apeM);
    }

    public String getUsuario() {
        return usuario.get();
    }

    public void setUsuario(String usuario) {
        this.usuario = new SimpleStringProperty(usuario);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
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

    public String getFechaNacimiento() {
        return fechaNacimiento.get();
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
    }

    public String getFechaIngreso() {
        return fechaIngreso.get();
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = new SimpleStringProperty(fechaIngreso);
    }

    public String getNss() {
        return nss.get();
    }

    public void setNss(String nss) {
        this.nss = new SimpleStringProperty(nss);
    }

    public String getRfc() {
        return rfc.get();
    }

    public void setRfc(String rfc) {
        this.rfc = new SimpleStringProperty(rfc);
    }

    public String getCurp() {
        return curp.get();
    }

    public void setCurp(String curp) {
        this.curp = new SimpleStringProperty(curp);
    }

    public int getIdSuc() {
        return idSuc.get();
    }

    public void setIdSuc(int idSuc) {
        this.idSuc = new SimpleIntegerProperty(idSuc);
    }

    public Integer getIdTurno() {
        return idTurno.get();
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = new SimpleIntegerProperty(idTurno);
    }

    public Integer getIdPuesto() {
        return idPuesto.get();
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = new SimpleIntegerProperty(idPuesto);
    }

    public Integer getIdImss() {
        return idImss.get();
    }

    public void setIdImss(int idImss) {
        this.idImss = new SimpleIntegerProperty(idImss);
    }

    public Integer getActUsuario() {
        return actUsuario.get();
    }

    public void setActUsuario(int actUsuario) {
        this.actUsuario = new SimpleIntegerProperty(actUsuario);
    }
    
}

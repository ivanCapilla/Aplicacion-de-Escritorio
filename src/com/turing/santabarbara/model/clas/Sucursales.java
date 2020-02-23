package com.turing.santabarbara.model.clas;

import java.util.Objects;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sucursales {
    private IntegerProperty idSuc;
    private StringProperty nombreSuc;
    private StringProperty direccionSuc;

    public Sucursales() {
        this.direccionSuc = null;
        this.idSuc = null;
        this.nombreSuc = null;
    }

    public Sucursales(Integer idSuc, String nombreSuc, String direccionSuc) {
        this.idSuc = new SimpleIntegerProperty(idSuc);
        this.nombreSuc = new SimpleStringProperty(nombreSuc);
        this.direccionSuc = new SimpleStringProperty(direccionSuc);
    }
    
    public Integer getIdSuc() {
        return idSuc.get();
    }

    public void setIdSuc(int idSuc) {
        this.idSuc = new SimpleIntegerProperty(idSuc);
    }

    public String getNombreSuc() {
        return nombreSuc.get();
    }

    public void setNombreSuc(String nombreSuc) {
        this.nombreSuc = new SimpleStringProperty(nombreSuc);
    }

    public String getDireccionSuc() {
        return direccionSuc.get();
    }

    public void setDireccionSuc(String direccionSuc) {
        this.direccionSuc = new SimpleStringProperty(direccionSuc);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sucursales other = (Sucursales) obj;
        if (!Objects.equals(this.idSuc, other.idSuc)) {
            return false;
        }
        return true;
    }
    
}

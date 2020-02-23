/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.santabarbara.control;

import com.turing.santabarbara.modelo.BaseDatos;
import com.turing.santabarbara.modelo.Logica;
import com.turing.santabarbara.model.clas.Sucursales;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControlSucursal implements Initializable {
    //Modelo
    BaseDatos db;
    Logica log;
    
    //Configuraciones
    Properties config;
    
    @FXML private TextField txtAddres;
    @FXML private TextField txtName;
    @FXML public TextField txtIdSuc;
    @FXML private Button btn_add;
    @FXML private Button btn_exit;
    
    //Enviar parametros
    private Sucursales suc;
    private ObservableList<Sucursales> sucursales;
    
    //Inicializar metodos
    public void construc(Properties config, BaseDatos db, Logica log){
        this.config = config;
        this.db = db;
        this.log = log;
    }
    
    public void iniAtt(ObservableList<Sucursales> sucursales){
        this.sucursales = sucursales;
        this.suc = null;
    }
    
    public void iniAtt(ObservableList<Sucursales> sucursales, Sucursales suc){
        this.sucursales = sucursales;
        this.suc=suc;
        this.txtIdSuc.setText(String.valueOf(suc.getIdSuc()));
        this.txtName.setText(suc.getNombreSuc());
        this.txtAddres.setText(suc.getDireccionSuc());
    }
    
    public Sucursales getSuc() {
        return suc;
    }
    
    //Metodos de la vista
    @FXML public void add(){
            int id = Integer.parseInt(txtIdSuc.getText());
            String nombre = txtName.getText();
            String dir = txtAddres.getText();
            if(this.suc != null){
                this.suc.setIdSuc(id);
                this.suc.setNombreSuc(nombre);
                this.suc.setDireccionSuc(dir);
                db.actualizar("update sucursal set nomSucursal = '"+nombre+"', "
                              + "direccionSucursal = '"+dir+"' "
                              + "Where idSucursal = "+id+" ;");
                info("¡La sucursal fue actualizada!");
            }else{
                Sucursales s = new Sucursales(id, nombre, dir);
                db.actualizar("insert into sucursal values ("+id+", '"
                              +nombre+"', '"+dir+"');");
                this.suc = s;
                info("¡La sucursal fue agregada!");
            }
            Stage stage = (Stage) this.btn_add.getScene().getWindow();
            stage.close();
    }
    
    @FXML public void exit(){
        this.suc = null;
        Stage stage = (Stage) this.btn_add.getScene().getWindow();
        stage.close();
    }
    
    //Mensajes de Pantalla
    @FXML void error(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(config.getProperty("name.proyect"+" - Error"));
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    private void info(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(config.getProperty("name.proyect")+" - Alert ");
        alert.setHeaderText(mensaje);
        alert.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

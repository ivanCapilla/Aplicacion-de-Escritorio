/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.santabarbara.control;

import com.turing.santabarbara.modelo.BaseDatos;
import com.turing.santabarbara.modelo.Logica;
import com.turing.santabarbara.model.clas.Proveedores;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iván Díaz
 */
public class ControlProve implements Initializable {
    
    //Modelo
    BaseDatos db;
    Logica log;
    
    //Configuraciones
    Properties config;
    
    @FXML public Label lblNumProve;
    @FXML private TextField txtNameProve;
    @FXML private TextField txtDirProve;
    @FXML private TextField txtTelProve;
    @FXML private TextField txtRfcProve;
    @FXML private Button btnAceptar;
    @FXML private Button btnCancel;
    
    //Enviar parametros
    private Proveedores pro;
    private ObservableList<Proveedores> proveedores;
    
    //Inicializar metodos
    public void construc(Properties config, BaseDatos db, Logica log){
        this.config = config;
        this.db = db;
        this.log = log;
    }
    
    public void iniAtt(ObservableList<Proveedores> proveedores){
        this.proveedores = proveedores;
        this.pro=null;
    }
    public void iniAtt(ObservableList<Proveedores> proveedores, 
                       Proveedores pro){
        this.proveedores = proveedores;
        this.pro = pro;
        this.lblNumProve.setText(String.valueOf(pro.getIdProveedor()));
        this.txtNameProve.setText(pro.getNombre());
        this.txtDirProve.setText(pro.getDireccion());
        this.txtTelProve.setText(pro.getTelefono());
        this.txtRfcProve.setText(pro.getRfc());
        
    }
    public Proveedores getPro(){
        return pro;
    }
    
    //Metodos de la vista
    @FXML public void add(){
        int idProveeedor = Integer.parseInt(lblNumProve.getText());
        String nombreProveedor = txtNameProve.getText();
        String direccionProve = txtDirProve.getText();
        String telProve = txtTelProve.getText();
        String rfcProve = txtRfcProve.getText();
        if (this.pro!= null) {
            this.pro.setIdProveedor(idProveeedor);
            this.pro.setNombre(nombreProveedor);
            this.pro.setDireccion(direccionProve);
            this.pro.setTelefono(telProve);
            this.pro.setRfc(rfcProve);
            db.actualizar("update proveedor set nombre = '"+nombreProveedor+"',"
                          + "direccion = '"+direccionProve+"', telefono= '"
                          +telProve+"', rfc='"+rfcProve+"' where idproveedor ="
                          +idProveeedor+";");
        }else{
            Proveedores prove = new Proveedores(idProveeedor, nombreProveedor, 
                                direccionProve, telProve, rfcProve);
            db.actualizar("insert into proveedor (nombre, direccion, telefono, "
                          + "rfc) values ('"+nombreProveedor+"','"
                          +direccionProve+"','"+telProve+"','"+rfcProve+"');");
            System.out.println("insert into proveedor (nombre, direccion, "
                               + "telefono, rfc) values ('"+nombreProveedor+"',"
                               + "'"+direccionProve+"','"+telProve+"','"
                               +rfcProve+"');");
            this.pro = prove;
            info("¡La sucursal fue agregada!");
        }
            Stage stage = (Stage) this.btnAceptar.getScene().getWindow();
            stage.close();
    }
    @FXML public void exit(){
        this.pro = null;
        Stage stage = (Stage) this.btnAceptar.getScene().getWindow();
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
        // TODO
    } 
    
}

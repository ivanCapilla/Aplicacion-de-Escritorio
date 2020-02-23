/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.santabarbara.control;


import com.turing.santabarbara.modelo.BaseDatos;
import com.turing.santabarbara.modelo.Logica;
import com.turing.santabarbara.model.clas.Cliente;
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
 * @author Iván Díaz, Uziel Enriquez
 */
public class ControlCliente implements Initializable {
    //Modelo
    BaseDatos db;
    Logica log;
    
    //Configuraciones
    Properties config;
    
    @FXML private TextField txtNameCli;
    @FXML private TextField txtApeCli;
    @FXML private TextField txtFechRegCli;
    @FXML private TextField txtEmaCli;
    @FXML private TextField txtTelCli;
    @FXML public Label lblNumCli;
    @FXML private Button btnExit;
    @FXML private Button btnAdd;
    
    //Enviar parametros
    private Cliente cli;
    private ObservableList<Cliente> cliente;
    
    //Inicializar métodos
    public void construc(Properties config, BaseDatos db, Logica log){
        this.config = config;
        this.db = db;
        this.log = log;
    }
    
    public void iniAtt(ObservableList<Cliente> cliente){
        this.cliente = cliente;
        this.cli=null;
    }
    
    public void iniAtt(ObservableList<Cliente> cliente, Cliente cli){
        this.cliente = cliente;
        this.cli=cli;
        this.lblNumCli.setText(String.valueOf(cli.getIdCliente()));
        this.txtNameCli.setText(cli.getNombre());
        this.txtApeCli.setText(cli.getApellido());
        this.txtFechRegCli.setText(cli.getFechaReg());
        this.txtEmaCli.setText(cli.getEmail());
        this.txtTelCli.setText(cli.getTelefono());
    }
    
    public Cliente getCli(){
        return cli;
    }
    
    //Métodos de la vista
    @FXML public void add(){
        int id = Integer.parseInt(lblNumCli.getText());
        String nombre = txtNameCli.getText();
        String apellido = txtApeCli.getText();
        String fechaReg = txtFechRegCli.getText();
        String email = txtEmaCli.getText();
        String telefono = txtTelCli.getText();
        if (this.cli != null) {
            this.cli.setIdCliente(id);
            this.cli.setNombre(nombre);
            this.cli.setApellido(apellido);
            this.cli.setFechaReg(fechaReg);
            this.cli.setEmail(email);
            this.cli.setTelefono(telefono);
            db.actualizar("update cliente set nombre ='"+nombre+"', apellido= '"
                           +apellido+"', fechaRegistro='"+fechaReg+"', email='"
                           +email+"', telefono='"+telefono+"' where id = "
                           +id+";");                                                                                                                                               
        }else{
            Cliente client = new Cliente(id,  nombre, apellido, fechaReg, email, 
                                         telefono);
            db.actualizar("insert into cliente (nombre, apellido,"
                           + "fechaRegistro, email, telefono) values ('"
                           +nombre+"','"+apellido+"','"+fechaReg+"','"
                           +email+"','"+telefono+"');");
            this.cli = client;
            info("¡EL cliente fue agregado!");
        }
        Stage stage = (Stage) this.btnAdd.getScene().getWindow();
            stage.close();
    }
    
    @FXML public void exit(){
        this.cli = null;
        Stage stage = (Stage) this.btnAdd.getScene().getWindow();
        stage.close();
    }
    
    //mensaje de pantalla
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.santabarbara.control;

import com.turing.santabarbara.modelo.HiloSplash;
import com.turing.santabarbara.modelo.BaseDatos;
import com.turing.santabarbara.modelo.Logica;
import com.turing.santabarbara.model.clas.Usuario;
import com.turing.santabarbara.view.VistaSplash;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Uziel
 */
public class ControlLogin implements Initializable {
     BaseDatos db;
     Logica log;
     Usuario userU;
     ControlPanel cPanel;
     Properties config;
     Stage stage;
     Scene sceneL;
     
     @FXML private TextField usuario;
     @FXML private PasswordField password;
     @FXML private Label error;
     @FXML private AnchorPane ap;
    
    public void actCons(Properties config, BaseDatos db, Logica log, 
            Usuario userU, Stage stage, Scene sceneL, ControlPanel cPanel) {
        this.config = config;
        this.db = db;
        this.log = log;
        this.userU = userU;
        this.cPanel = cPanel;
        this.stage = stage;
        this.sceneL = sceneL;
    }
    
    @FXML
    private void logIn(){     
        boolean res = db.datosUsuario(userU, usuario.getText(), 
                log.getMD5(password.getText()));
        if (res) {
            userU.setIdSuc(userU.getIdSuc());
            cPanel.cargarTabPro();
            cPanel.cargarCmbAlm();
            stage.setTitle(config.getProperty("name.proyect")+" - Bienvenido "
                           +userU.getNombre()+" "+userU.getApellidos());
            stage.setScene(sceneL);
            stage.initOwner(ap.getScene().getWindow());
            ((Stage) ap.getScene().getWindow()).close();
            
            //Splash
            VistaSplash animacion = new VistaSplash();
            HiloSplash hilo = new HiloSplash(animacion);
            animacion.setVisible(true);
            hilo.start();
            try{
                Thread.sleep(5000);
                stage.show();
            }catch(InterruptedException e){
            }
            
        } else {
            error.setText("Usuario y/o Contraseña Incorrecta.");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

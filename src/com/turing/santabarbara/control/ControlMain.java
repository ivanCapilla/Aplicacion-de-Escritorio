/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.santabarbara.control;

import com.turing.santabarbara.modelo.BaseDatos;
import com.turing.santabarbara.modelo.Logica;
import com.turing.santabarbara.model.clas.Usuario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Uziel
 */
public class ControlMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        try {
            //Ruta de la configuración
            String file = "src/config.properties";

            //Properties
            Properties config = new Properties();
            FileReader read = new FileReader(file);

            //Modelo
            BaseDatos db = new BaseDatos(config, read);
            db.Conexion();
            Logica log = new Logica(config, read);
            
            //Modelo Clases
            Usuario userU = new Usuario();
            userU.setIdSuc(0);
            
            //Vistas FXML
            //Vista Login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/"
                                + "turing/santabarbara/view/login.fxml"));
            Parent root = loader.load();
            
            //VistaGeneral
            FXMLLoader controlG = new FXMLLoader();
            URL location = ControlLogin.class.getResource("/com/turing/"
                           + "santabarbara/view/PanelPrincipal.fxml");
            controlG.setLocation(location);
            BorderPane pn = controlG.load();
            Stage stageL = new Stage();
            Scene sceneL = new Scene(pn);
            sceneL.getStylesheets().add(ControlMain.class.getResource("/com/"
                                        + "turing/santabarbara/vista/css/"
                                        + "panelprincipal.css").toExternalForm()
                                        );
            stageL.setResizable(false);
            
            //Controles
            //Control Panel
            ControlPanel controlP = controlG.<ControlPanel>getController();
            controlP.construc(config, db, log, userU);
            
            //Control Login
            ControlLogin control = loader.<ControlLogin>getController();
            control.actCons(config,db, log, userU, stageL, sceneL, controlP);
            
            //Otros
            Scene scene = new Scene(root);
            scene.getStylesheets().add(ControlMain.class.getResource("/com/"
                                       + "turing/santabarbara/vista/css/"
                                       + "login.css").toExternalForm());
            stage.setTitle(config.getProperty("name.proyect"));
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

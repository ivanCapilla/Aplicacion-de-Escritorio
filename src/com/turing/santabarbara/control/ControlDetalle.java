/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.santabarbara.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Uziel Enriquez
 */
public class ControlDetalle implements Initializable {

    @FXML public Label lblFolio;
    @FXML public Label lblTotal;
    @FXML public TextArea table;
    @FXML public TextArea table1;
    @FXML public TextArea table2;
    @FXML public Label date;
    @FXML public Label time;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

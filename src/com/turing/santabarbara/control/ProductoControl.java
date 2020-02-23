/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.santabarbara.control;

import com.turing.santabarbara.modelo.BaseDatos;
import com.turing.santabarbara.modelo.Logica;
import com.turing.santabarbara.model.clas.Producto;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Uziel
 */
public class ProductoControl implements Initializable {
    
    @FXML private TextField txtCanProduc;
    @FXML private TextField txtDatProduc;
    @FXML public Label lbIdProduct;
    @FXML private TextField txtLotProduc;
    @FXML private TextField txtNomProduc;
    @FXML private TextField txtComProduc;
    @FXML private TextField txtPreProduc;
    @FXML public ComboBox<String> cbAlmProduc;
    @FXML public ComboBox<String> cnProvProduc;
    @FXML private Button btn_add;
    @FXML private Button btn_exit;
    
    ObservableList<Producto> list;
    ObservableList<String> prov;
    ObservableList<String> alm;
    Producto producto;
    
    Logica log;
    BaseDatos db;
    Properties config;
    
    //Constructor
    public void construct(Properties config, BaseDatos db, Logica log){
        this.db = db;
        this.log = log;
        this.config = config;
    }
    
    public void iniAtt(ObservableList<Producto> producto){
        this.list = producto;
        this.producto = null;
    }
        
    public void iniAtt(ObservableList<Producto> producto, Producto produc){
        this.list = producto;
        this.producto = produc;
        this.lbIdProduct.setText(String.valueOf(produc.getIdProducto()));
        this.txtNomProduc.setText(produc.getProducto());
        this.txtComProduc.setText(produc.getCompuesto());
        this.txtLotProduc.setText(produc.getLote());
        this.txtCanProduc.setText(produc.getCantidad());
        this.txtDatProduc.setText(produc.getCaducidad());
        this.txtPreProduc.setText(String.valueOf(produc.getPrecio()));
        this.cnProvProduc.setItems(prov);
        this.cbAlmProduc.setItems(alm);
        this.cnProvProduc.getSelectionModel().select(produc.getProveedor());
        this.cbAlmProduc.getSelectionModel().select(produc.getAlmacen());
        System.out.println("");
    }
    
    public Producto getPro(){
        return producto;
    }
    
    @FXML public void add(){
            int id = Integer.parseInt(lbIdProduct.getText());
            String nombre = txtNomProduc.getText();
            String compuesto = txtComProduc.getText();
            String lote = txtLotProduc.getText();
            String cantidad = txtCanProduc.getText();
            String caducidad = txtDatProduc.getText();
            double precio = Double.parseDouble(txtPreProduc.getText());
            String idProv = cnProvProduc.getSelectionModel(). getSelectedItem();
            int pos = idProv.indexOf("-");
            String proveedor = idProv.substring(0, pos-1);
            String idAl = cbAlmProduc.getSelectionModel(). getSelectedItem();
            int posA = idAl.indexOf("-");
            String almacen = idAl.substring(0, posA-1);
            
            if(this.producto != null){
                 producto.setIdProducto(id);
                    producto.setProducto(nombre);
                    producto.setCompuesto(compuesto);
                    producto.setLote(lote);
                    producto.setCaducidad(caducidad);
                    producto.setPrecio(precio);
                    producto.setCantidad(cantidad);
                    producto.setProveedor(idProv);
                    producto.setAlmacen(idAl);
                db.actualizar("update producto set nombre = '"+nombre+"', "
                              + "compuesto = '"+compuesto+"', "+"numerolote = "
                              + "'"+lote+"', fechacad = '"+caducidad+"', "
                              + "cantidad = '"+cantidad+"', precio = "
                              +precio+" idproveedor = "+proveedor+", "
                              + "idalmacen = "+almacen+" where codigo = "+id+";"
                              );
                info("¡El producto fue actualizada!");
            }else{
                Producto p = new Producto(id, nombre, compuesto, lote, 
                             cantidad, caducidad, precio, proveedor, almacen);
                db.actualizar("insert into producto (codigo, nombre, compuesto,"
                              + " numerolote, fechacad, cantidad, precio, "
                              + "idproveedor, idalmacen) values ("+id+", '"
                              +nombre+"', '"+compuesto+"', '"+lote+"', '"
                              +caducidad+"', '"+cantidad+"', "+precio+" "
                              +proveedor+","+almacen+");");
                this.producto= p;
                info("¡El producto fue agregada!");
            }
            Stage stage = (Stage) this.btn_add.getScene().getWindow();
            stage.close();   
    }
    
    @FXML public void exit(){
        this.producto = null;
        Stage stage = (Stage) this.btn_add.getScene().getWindow();
        stage.close();
    }
    
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

package com.turing.santabarbara.control;

import com.turing.santabarbara.modelo.BaseDatos;
import com.turing.santabarbara.modelo.Logica;
import com.turing.santabarbara.model.clas.CompraProducto;
import com.turing.santabarbara.model.clas.Producto;
import com.turing.santabarbara.model.clas.Ventas;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author Turing
 * @version 1.0
 */

public class VentaControl implements Initializable {
    Ventas ven;
    ObservableList<String> listPro;
    ObservableList<String> filtrolistPro;
    ObservableList<Producto> producto;
    ObservableList<Ventas> venta;
    Producto aux;
    CompraProducto ventaP;
    ObservableList<Producto> todos;
    double totalVenta = 0;
    Logica log;
    BaseDatos db;
    Properties config;
    
    //Tabla
    @FXML private TableView<Ventas> tabProducts;
    @FXML private TableColumn clName;
    @FXML private TableColumn clAmount;
    @FXML private TableColumn clCount;
    
    // ComboBox
    @FXML public ComboBox cbProduct;
    
    //Datos producto
    @FXML public Label lbIdVenta;
    @FXML private Label total;
    @FXML private Label txtNameProduct;
    @FXML private Label txtPrecio;
    @FXML private TextField filterProduct;
    @FXML private TextField txtAmount;
    
    //Botones
    @FXML private Button btn_drop;
    @FXML private Button btn_add;
    @FXML private Button btn_saveSell;
    
    public void setList(ObservableList<String> product){
        this.listPro = product;
    }
    
    public void setProducto(ObservableList<String> pro){
        this.listPro = pro;
    }
    
    public void setProductoO(ObservableList<Producto> pro){
        this.producto = pro;
    }
    
    public void productosT(ObservableList pro){
        this.todos = pro;
    }
    
    public CompraProducto getCompraVenta(){
        return this.ventaP;
    }
    
    public Ventas getVenta(){
        return this.ven;
    }
    
    public void setVenta(Ventas ven){
        this.ven = ven;
    }
    
    //Constructor
    public void construct(Properties config, BaseDatos db, Logica log){
        this.db = db;
        this.log = log;
        this.config = config;
    }
    
    @FXML void addProduct() {
        int id = 0;
        int nCantidad = 0;
        try {
             ResultSet res = db.consulta("select folio from compra order "
                     + "by folio desc Limit 0,1;");
             if(res.next()){
                 id = Integer.parseInt(res.getString(1));
                 id++;
             }else{
                 id = 0;
             }
        } catch (Exception e) {
        }
        String producto = "";
        String precio = "";
        String cantidad = txtAmount.getText();
        producto = String.valueOf(
                   cbProduct.getSelectionModel().getSelectedItem());
        if(cantidad.isEmpty()){
            cantidad = "1";
        }
        precio = txtPrecio.getText();
        Producto aux = null;
        int productP = producto.indexOf("-")-1;
        if(!producto.isEmpty()){
            int idP = Integer.parseInt(producto.substring(0, productP));
            for(Producto p: this.producto){
                    if(p.getIdProducto().equals(idP)){
                        aux = p;
                    }
            }
            if(aux != null){
                if(Integer.parseInt(aux.getCantidad()) 
                   <= Integer.parseInt(cantidad)){
                    error("¡No hay sufientes articulos solicitados!");
                }else{
                    nCantidad = Integer.parseInt(aux.getCantidad()) 
                                - Integer.parseInt(cantidad);
                    aux.setCantidad(String.valueOf(nCantidad));
                    Ventas ven = new Ventas();
                    ven.setFolio(id);
                    ven.setArticulo(aux.getProducto());
                    ven.setCantidad(Integer.parseInt(cantidad));
                    double subtotal = aux.getPrecio() 
                                      * Double.parseDouble(cantidad);
                    ven.setSubtotal(subtotal);
                    ven.setIdCliente(0);
                db.actualizar("insert into compra (folio, articulo, cantidad, "
                              + "subtotal)"
                              + " values ( "+ven.getFolio() + ",'"
                              +ven.getArticulo()+
                              "', "+ven.getCantidad() + ", " + ven.getSubtotal()
                              +");");
                    System.out.println("insert into compra (folio, articulo, "
                                       + "cantidad, subtotal)"
                                       + " values ( " + ven.getFolio() + ",'"
                                       + ven.getArticulo() +
                                       "', "+ven.getCantidad() + ", " 
                                       + ven.getSubtotal() + ");");
                totalVenta += ven.getSubtotal();
                venta.add(ven);
                this.ven = ven;
                total.setText(String.valueOf(totalVenta));
            }
            tabProducts.setItems(venta);
            }
            txtNameProduct.setText("");
            txtAmount.setText("");
            txtPrecio.setText("");
            cbProduct.setValue(null);
            aux = null;
        }else{
            error("¡Debes seleccionar un producto!");
        }
    }

    @FXML void dropProduct() {
        Ventas p = tabProducts.getSelectionModel().getSelectedItem();
        venta.remove(p);
        db.actualizar("delete from compra where folio = "+p.getFolio()+";");
        totalVenta = totalVenta - p.getSubtotal();
        total.setText(String.valueOf(totalVenta));
        tabProducts.refresh();
    }
    
    @FXML void saveSell(){
        String folios = "";
        String productos = "";
        int idP = 0;
        int id = Integer.parseInt(lbIdVenta.getText());
        
        ventaP = new CompraProducto();
        ventaP.setId(id);
        for(Ventas v:venta){
            for(Producto p : producto){
                if(v.getArticulo().contains(p.getProducto())){
                    idP = p.getIdProducto();
                 }
            }
            folios += v.getFolio()+", ";
            productos += v.getArticulo()+", ";
            db.actualizar("insert into compra_producto (id, folio, codigo, "
                          + "fecha, hora, total) "
                          + "values ("+id+","+v.getFolio()+", "+idP+", "+"'"
                          +getFechaActual()+"',"+"'"+getHoraActual()+"', "
                          +totalVenta+");");
            System.out.println("insert into compra_producto (id, folio, codigo,"
                               + "fecha, hora, total) "
                               + "values ("+id+","+v.getFolio()+", "+idP+", "
                               +"'"+getFechaActual()+"',"+"'"+getHoraActual()
                               +"', "+totalVenta+");");
        }
        
        ventaP.setFolio(folios);
        ventaP.setProducto(productos);
        ventaP.setFecha(getFechaActual());
        ventaP.setHora(getHoraActual());
        ventaP.setTotal(totalVenta);
        System.out.println(ventaP.getId()+" "+ventaP.getFolio());
        Stage stage = (Stage) this.btn_add.getScene().getWindow();
        stage.close();
    }
    
    @FXML void actionProducto() {
        try {
            String producto = String.valueOf(cbProduct.getSelectionModel(). getSelectedItem());
        int productP = producto.indexOf("-")-1;
        if(producto.isEmpty()){
            producto = "0";
        }
        int idP = Integer.parseInt(producto.substring(0, productP));
        if(idP != 0){
            for(Producto p: this.producto){
                if(p.getIdProducto().equals(idP)){
                    txtNameProduct.setText(p.getProducto());
                    txtPrecio.setText("$"+String.valueOf(p.getPrecio()));
                    aux = p;
                }
            }
        }else{
            error("¡Debes seleccionar un producto!");
        }
        } catch (StringIndexOutOfBoundsException e) {
        }   
    }
    
    @FXML void filterProduct(KeyEvent event) {
        String producto = filterProduct.getText();
        filtrolistPro.clear();
        if(!producto.isEmpty()){
            for(String p : listPro){
                if(p.toLowerCase().contains(producto.toLowerCase())){
                    filtrolistPro.add(p);
                }
            }
            cbProduct.setItems(filtrolistPro);
        }else{
            cbProduct.setItems(listPro);
        }
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
        listPro = FXCollections.observableArrayList();
        filtrolistPro = FXCollections.observableArrayList();
        venta = FXCollections.observableArrayList();
        
        clName.setCellValueFactory(new PropertyValueFactory("articulo"));
        clAmount.setCellValueFactory(new PropertyValueFactory("cantidad"));
        clCount.setCellValueFactory(new PropertyValueFactory("subtotal"));
    }
    
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(ahora);
    }
    
    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }
    
}

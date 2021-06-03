package com.turing.santabarbara.control;

import com.turing.santabarbara.modelo.BaseDatos;
import com.turing.santabarbara.modelo.Logica;
import com.turing.santabarbara.model.clas.Cliente;
import com.turing.santabarbara.model.clas.CompraProducto;
import com.turing.santabarbara.model.clas.Empleado;
import com.turing.santabarbara.model.clas.Producto;
import com.turing.santabarbara.model.clas.Proveedores;
import com.turing.santabarbara.model.clas.Sucursales;
import com.turing.santabarbara.model.clas.Usuario;
import com.turing.santabarbara.model.clas.Ventas;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControlPanel implements Initializable {
    //Modelo
    BaseDatos db;
    Logica log;
    Usuario usuario;
    
    //Configuraciones
    Properties config;
    
    //Variables de Sistema
    @FXML Tab homeTab;
    @FXML Tab sucursalTab;
    @FXML Tab proveedorTab;
    @FXML Tab sellTab;
    @FXML Tab clientTab;
    @FXML Tab productTab;
    @FXML Tab empleadoTab;
    
    //Variables Inicio
    @FXML private CategoryAxis x;
    @FXML private NumberAxis y;
    @FXML private Label titulo;
    
    @FXML private BarChart<String, Integer> graphic;
    @FXML private BarChart<String, Integer> graphic2;
    @FXML private BarChart<String, Integer> graphic3;
    @FXML private BarChart<String, Integer> graphic4;
    @FXML private NumberAxis y3;
    @FXML private NumberAxis y4;
    @FXML private CategoryAxis x3;
    @FXML private CategoryAxis x4;
    
    //Variables Sucursal
    //Tabla
    ObservableList<Sucursales> sucursales;
    ObservableList<Sucursales> filtroSuc;
    @FXML private TableView<Sucursales> tab_suc;
    @FXML private TableColumn numSucTB;
    @FXML private TableColumn direccionSucTB;
    @FXML private TableColumn nomSucTB;
    //Text Field
    @FXML private TextField txtFilterSuc;
    //Botones
    @FXML private Button btn_addSuc;
    @FXML private Button btn_dropSuc;
    @FXML private Button btn_editSuc;
    
    //Variables Proveedores
    //Tabla
    ObservableList<Proveedores> proveedor;
    ObservableList<Proveedores> filtroProveedor;
    @FXML TableView <Proveedores> tablaProveedor;
    @FXML TableColumn numeroProve;
    @FXML TableColumn nombreProveedor;
    @FXML TableColumn direccionProveedor;
    @FXML TableColumn telProveedor;
    @FXML TableColumn rfcProveedor;
    @FXML TextField txtBuscarProve;
    @FXML Button btnAgregarProve;
    @FXML Button btnEditarProve;
    @FXML Button btnEliminar;
            
    //Variables Ventas
    ObservableList<CompraProducto> ventasP;
    ObservableList<CompraProducto> filtroVentasP;
    ObservableList<Ventas> ventasT;
    Ventas ven;
    @FXML TextField txtFilterSell;
    @FXML TableView<CompraProducto> tabSell;
    @FXML TableColumn clFolioVenta;
    @FXML TableColumn clNumVenta;
    @FXML TableColumn clProductVenta;
    @FXML TableColumn clFechaVenta;
    @FXML TableColumn clHoraVenta;
    @FXML TableColumn clTotalVenta;
    
    CompraProducto ventas;
    //Botones
    @FXML Button btn_addSell;
    @FXML Button btn_modSell;
    @FXML Button btn_dropSell;
    
    //Variables Clientes
    //Tabla
    ObservableList<Cliente> cliente;
    ObservableList<Cliente> filtroCliente;
    @FXML TableView <Cliente> tablCliente;
    @FXML TableColumn numCliente;
    @FXML TableColumn nomCliente;
    @FXML TableColumn apellidoCliente;
    @FXML TableColumn fechReg;
    @FXML TableColumn emailCliente;
    @FXML TableColumn telCliente;
    @FXML TextField txtBusCliente;
    @FXML Button btnAgregarCli;
    @FXML Button btnEditarCliente;
    @FXML Button btnEliminarCli;
    
    
    //Variables Productos
    //Tabla
    ObservableList<Producto> productos;
    ObservableList<Producto> filtroProducto;
    ObservableList<String> listProduct;
    Producto classProduct;
    @FXML TableView <Producto> tabProduct;
    @FXML TableColumn idProduct;
    @FXML TableColumn nomProduct;
    @FXML TableColumn comProduct;
    @FXML TableColumn fechaProduct;
    @FXML TableColumn cantidadProduct;
    //Text Field
    @FXML TextField txtFilterProdcuto;
    //Combobox
    ObservableList<String> Proveedor;
    ObservableList<String> Almacen;
    
    //Variables Empleados
    //Tabla
    ObservableList<Empleado> empleado;
    ObservableList<Empleado> filtroEmpleado;
    @FXML TableView <Empleado> tablaEmpleado;
    @FXML TableColumn colNumEmpleado;
    @FXML TableColumn colNomEmpleado;
    @FXML TableColumn colApeEmpleado;
    @FXML TableColumn colEmailEmpleado;
    @FXML TableColumn colDirEmpleado;
    @FXML TableColumn colNssEmpleado;
    @FXML TableColumn colSucEmpleado;
    @FXML TableColumn colTurnEmpleado;
    @FXML TextField txtBuscarEmpleado;
    @FXML Button btnAddEmpleado;
    @FXML Button btnEditEmpleado;
    @FXML Button btnDropEmpleado;
    
    //Constructor
    public void construc(Properties config, BaseDatos db, Logica log, 
                         Usuario user){
        this.config = config;
        this.db = db;
        this.log = log;
        this.usuario = user;
        titulo.setText(config.getProperty("name.proyect") + " - "
                                          + "Panel de Control");
        cargarDatos();
        cargarVentas();
        cargarTabSuc();
        cargarTabPro();
        cargarCmbProve();
        cargarCmbAlm();
        cargarTablaVenta();
        cargarTablaProve();
        cargarTablaCliente();
    }
    
    //Metodos Inicio
    @FXML public void cargarDatos(){
        cargarDatos2(graphic, db.consulta("SELECT COUNT(fechaRegistro) "
                     + "'cantidad', (fechaRegistro) 'fecha' FROM cliente "
                     + "GROUP BY fechaRegistro;"));
        cargarDatos2(graphic3, db.consulta("SELECT COUNT(fecha) 'cantidad', "
                     + "(fecha) 'fecha' FROM compra_producto GROUP BY fecha;"));
        cargarDatos2(graphic4, db.consulta("SELECT COUNT(fecha) 'cantidad', "
                     + "(fecha) 'fecha' FROM asistencia GROUP BY fecha;"));
    }
    @FXML
    public void cargarDatos2(BarChart<String, Integer> graphic, ResultSet res){
        graphic.getData().clear();
        try {
            if(res.next()){
                do{
                    String fecha = res.getString(2);
                    int cantidad = res.getInt(1);
                    XYChart.Series<String, Integer> 
                    dataSeries1 = new XYChart.Series<>();
                    dataSeries1.getData().add(new XYChart.Data("", cantidad));
                    dataSeries1.setName(fecha);
                    graphic.getData().add(dataSeries1);
                }while(res.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    //Metodos Sucursales
    //Metodo para agregar sucursales
    @FXML void addSuc(){
        try {
            int id=0;
                ResultSet res = db.consulta("select idSucursal from sucursal"
                                            +"order by idSucursal DESC LIMIT 0,1;");
                if(res.next()){
                id = Integer.parseInt(res.getString(1));
                }
            id++;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/"
                                + "turing/santabarbara/view/Sucursales.fxml"));
            Parent root = loader.load();
            ControlSucursal controlS = loader.getController();
            controlS.iniAtt(sucursales);
            controlS.construc(config, db, log);
            Stage stageS = new Stage();
            Scene sceneS = new Scene(root);
            stageS.initModality(Modality.APPLICATION_MODAL);
            stageS.setTitle(config.getProperty("name.proyect") 
                            + " - Sucursales");
            stageS.setScene(sceneS);
            controlS.txtIdSuc.setText(String.valueOf(id));
            stageS.showAndWait();
            Sucursales s = controlS.getSuc();
            if(s != null){
                this.sucursales.add(s);
                if(s.getNombreSuc().toLowerCase().contains(
                   this.txtFilterSuc.getText().toLowerCase())){
                    this.filtroSuc.add(s);
                }
                tab_suc.refresh();
            }
        } catch (IOException ex) {
        } catch (SQLException ex) {
        }
    }
    
    //Metodo para modificar sucursales
    @FXML void modSuc(){
        Sucursales suc = this.tab_suc.getSelectionModel().getSelectedItem();
        if(suc == null){
            error("Debes Seleccionar una sucursal a modificar");
        }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com"
                                    + "/turing/santabarbara/view/"
                                    + "Sucursales.fxml"));
                Parent root = loader.load();
                ControlSucursal controlS = loader.getController();
                controlS.iniAtt(sucursales, suc);
                controlS.construc(config, db, log);
                Stage stageS = new Stage();
                Scene sceneS = new Scene(root);
                stageS.initModality(Modality.APPLICATION_MODAL);
                stageS.setTitle(config.getProperty("name.proyect") 
                                                    +" - Sucursales");
                stageS.setScene(sceneS);
                stageS.showAndWait();
                
                Sucursales auxS = controlS.getSuc();
                if(auxS != null){
                    if(!auxS.getNombreSuc().toLowerCase().contains(
                       this.txtFilterSuc.getText().toLowerCase())){
                       this.filtroSuc.remove(auxS);
                    }
                    tab_suc.refresh();
                }
            } catch (IOException ex) {
            }
        }
    }
    
    //Metodo para eliminar sucursales
    @FXML void dropSuc(ActionEvent ev){
        Sucursales s = this.tab_suc.getSelectionModel().getSelectedItem();
        if(s == null){
            error("¡Debes seleccionar una sucursal de la tabla!");
        }else{
            info("¡Ha sido borrrada correctamente!");
            db.actualizar("delete from sucursal where idSucursal="
                           +s.getIdSuc()+";");
            this.sucursales.remove(s);
            this.filtroSuc.remove(s);
            this.tab_suc.refresh();
        }
    }
    
    //Metodo para el filtro por sucursales.
    @FXML void filterSuc(KeyEvent ev){
        String sucursal = this.txtFilterSuc.getText();
        if(sucursal.isEmpty()){
            this.tab_suc.setItems(sucursales);
        }else{
            this.filtroSuc.clear();
            for (Sucursales s : this.sucursales) {
                if(s.getNombreSuc().toLowerCase().contains(
                   sucursal.toLowerCase())){
                    this.filtroSuc.add(s);
                }
            }
            this.tab_suc.setItems(filtroSuc);
        }
        
    }
    
    //Cargar Sucursales de la db
    @FXML public void cargarTabSuc(){
        try {
            ResultSet res = db.consulta("select * from sucursal;");
            if(res.next()){
                do{
                    Sucursales suc = new Sucursales();
                    suc.setIdSuc(Integer.parseInt(res.getString(1)));
                    suc.setNombreSuc(res.getString(2));
                    suc.setDireccionSuc(res.getString(3));
                    sucursales.add(suc);
                }while(res.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error Tab Suc: "+ex.getMessage());
        }
    }
    
//Metodos Proveedores
     @FXML void agregarProveedor(){
        try {
            int id = 0;
            ResultSet res = db.consulta("select idproveedor from proveedor "
                                        + "order by idproveedor DESC limit 0,1;"
                                        + "");
            
            if(res.next()){
                id = Integer.parseInt(res.getString(1));
            }else{
                id = 1;
            }
            
            id++;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/"
                                + "turing/santabarbara/view/"
                                + "VistaProveedores.fxml"));
            Parent root = loader.load();
            ControlProve controlProv = loader.getController();
            controlProv.iniAtt(proveedor);
            controlProv.construc(config, db, log);
            Stage stageProv = new Stage();
            Scene sceneProv = new Scene(root);
            stageProv.initModality(Modality.APPLICATION_MODAL);
            stageProv.setTitle(config.getProperty("name.proyect") 
                               +" - Proveedores");
            stageProv.setScene(sceneProv);
            controlProv.lblNumProve.setText(String.valueOf(id));
            stageProv.showAndWait();
            Proveedores prov = controlProv.getPro();
            if(prov != null){
                this.proveedor.add(prov);
                if(prov.getNombre().toLowerCase().contains(
                   this.txtBuscarProve.getText().toLowerCase())){
                    this.filtroProveedor.add(prov);
                }
                tablaProveedor.refresh();
            }
        } catch (IOException ex) {
        } catch (SQLException ex) {
        }
    }
     
    @FXML void editarProveedor(){
        Proveedores prov = this.tablaProveedor.getSelectionModel().
                           getSelectedItem();
        if(prov == null){
            error("Debes Seleccionar una proveedor a modificar");
        }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com"
                                    + "/turing/santabarbara/view/"
                                    + "VistaProveedores.fxml"));
                Parent root = loader.load();
                ControlProve controlProv = loader.getController();
                controlProv.iniAtt(proveedor, prov);
                controlProv.construc(config, db, log);
                Stage stageProv = new Stage();
                Scene sceneProv = new Scene(root);
                stageProv.initModality(Modality.APPLICATION_MODAL);
                stageProv.setTitle(config.getProperty("name.proyect") 
                                   +" - Proveedores");
                stageProv.setScene(sceneProv);
                stageProv.showAndWait();
                
                Proveedores auxProv = controlProv.getPro();
                if(auxProv != null){
                    if(!auxProv.getNombre().toLowerCase().contains(
                       this.txtBuscarProve.getText().toLowerCase())){
                       this.filtroProveedor.remove(auxProv);
                    }
                    tablaProveedor.refresh();
                }
            } catch (IOException ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        }
    }
    
    @FXML void eliminarProveedore(){
        Proveedores prov = this.tablaProveedor.getSelectionModel()
                           .getSelectedItem();
        if(prov == null){
            error("¡Debes seleccionar un proveedor de la tabla!");
        }else{
            info("¡Ha sido borrrado correctamente!");
            db.consulta("delete from proveedor where idproveedor="
                        +prov.getIdProveedor()+";");
            System.out.println("delete from proveedor where idproveedor="
                               +prov.getIdProveedor()+";");
            this.proveedor.remove(prov);
            this.filtroProveedor.remove(prov);
            this.tablaProveedor.refresh();
        }
    }
    
    @FXML void buscarProveedores(){
        String provee = this.txtBuscarProve.getText();
        if(provee.isEmpty()){
            this.tablaProveedor.setItems(this.proveedor);
        }else{
            this.filtroProveedor.clear();
            for (Proveedores prov : this.proveedor) {
                if(prov.getNombre().toLowerCase().contains(
                   provee.toLowerCase())){
                    this.filtroProveedor.add(prov);
                }
            }
            this.tablaProveedor.setItems(filtroProveedor);
        }
    }
    
    public void cargarTablaProve(){
        try {
            ResultSet resultado = db.consulta("select * from proveedor;");
            if (resultado.next()) {
                do {     
                Proveedores objProveedores = new Proveedores();
                objProveedores.setIdProveedor(Integer.parseInt(
                resultado.getString(1)));
                objProveedores.setNombre(resultado.getString(2));
                objProveedores.setDireccion(resultado.getString(3));
                objProveedores.setTelefono(resultado.getString(4));
                objProveedores.setRfc(resultado.getString(5));
                proveedor.add(objProveedores);
                } while (resultado.next());
             
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Metodos Ventas
    @FXML void addSell(){
        try {
            int id = 0;
            
            ResultSet res = db.consulta("select id from compra_producto "
                            + "order by id desc LIMIT 0,1;");
            if(res.next()){
                id = Integer.parseInt(res.getString(1));
                id++;
            }else{
                id = 1;
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/"
                                + "turing/santabarbara/view/Venta.fxml"));
            Parent root = loader.load();
            VentaControl controlV = loader.getController();
            controlV.lbIdVenta.setText(String.valueOf(id));
            controlV.setVenta(ven);
            controlV.setList(listProduct);
            controlV.setProductoO(productos);
            controlV.productosT(productos);
            controlV.construct(config, db, log);
            controlV.cbProduct.setItems(listProduct);
            Stage stageV = new Stage();
            Scene sceneV = new Scene(root);
            stageV.initModality(Modality.APPLICATION_MODAL);
            stageV.setTitle(config.getProperty("name.proyect") +" - Ventas");
            stageV.setScene(sceneV);
            stageV.showAndWait();
            Ventas aux2 = controlV.getVenta();
            ven = aux2;
            CompraProducto aux = controlV.getCompraVenta();
            if(aux != null){
                ventasP.add(aux);
                ventasT.add(aux2);
                tabSell.refresh();
                cargarDatos();
            }
        } catch (IOException ex) {
        } catch (SQLException ex) {
        }
    }
    
    @FXML void detalle(){
        CompraProducto comP = this.tabSell.getSelectionModel()
        .getSelectedItem();
        if(comP != null){
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/"
            + "turing/santabarbara/view/VistaDetalle.fxml"));
            Parent root = loader.load();
            ControlDetalle controlD = loader.getController();
            controlD.lblFolio.setText(String.valueOf(comP.getId()));
            controlD.lblTotal.setText(String.valueOf(comP.getTotal()));
            controlD.date.setText(comP.getFecha());
            controlD.time.setText(comP.getHora());
            String folios = comP.getFolio();
            String[] datos = folios.split(", ");
            for(String item : datos){
              for(Ventas v: ventasT){
                  if(v.getFolio()== Integer.parseInt(item)){
                     controlD.table.setText(controlD.table.getText() + " " 
                     + v.getArticulo() + "\n");
                     controlD.table1.setText(controlD.table1.getText() + " " 
                     + v.getCantidad() + "\n");
                     controlD.table2.setText(controlD.table2.getText() + " " 
                     + v.getSubtotal() + "\n");
                      
                  }
              }
            }
            Stage stageS = new Stage();
            Scene sceneS = new Scene(root);
            stageS.initModality(Modality.APPLICATION_MODAL);
            stageS.setTitle(config.getProperty("name.proyect") 
            +" - Detalle Venta");
            stageS.setScene(sceneS);
            stageS.show();
        } catch (IOException ex) {
        }
        }else{
            error("¡Debes Seleccionar una venta!");
        }
    }
    
    @FXML void filtroSell(){
        String venta = this.txtFilterSell.getText();
        if(venta.isEmpty()){
            this.tabSell.setItems(ventasP);
        }else{
            this.filtroVentasP.clear();
            for (CompraProducto cp : this.ventasP) {
                if(cp.getFecha().toLowerCase().contains(venta.toLowerCase())){
                    this.filtroVentasP.add(cp);
                }
            }
            this.tabSell.setItems(filtroVentasP);
        }
    }
    
    public void cargarVentas(){
        try {
            ResultSet res = db.consulta("select * from compra;");
            if(res.next()){
                do {                    
                Ventas ven = new Ventas();
                ven.setFolio(Integer.parseInt(res.getString(1)));
                ven.setArticulo(res.getString(2));
                ven.setCantidad(Integer.parseInt(res.getString(3)));
                ven.setSubtotal(Double.parseDouble(res.getString(4)));
                if(res.getString(5) == null){
                    ven.setIdCliente(0);
                }else{
                    ven.setIdCliente(Integer.parseInt(res.getString(5)));
                }
                ventasT.add(ven);
                } while (res.next());
                
            }
        } catch (SQLException ex) {
        }
    }
    
    public void cargarTablaVenta(){
        String hora = "";
        String folio = "";
        String producto = "";
        int puntoH = 0;
        CompraProducto comP = null;
        try {
            ResultSet res = db.consulta("select id, fecha, hora, "
                            + "total from compra_producto GROUP BY id, fecha, "
                            + "hora, total ORDER BY id ASC;");
            if (res.next()) {
                do {
                folio = "";
                producto = "";
                comP = new CompraProducto();
                hora=res.getString(3);
                comP.setId(Integer.parseInt(res.getString(1)));
                ResultSet res2 = db.consulta("select folio from compra_producto"
                                 + "where id="+res.getString(1)+";");
                if(res2.next()){
                    do{
                        folio += res2.getString(1)+", ";
                    }while(res2.next());
                }
                ResultSet res3 = db.consulta("select p.nombre from producto p "
                                 + "join compra_producto cp on p.codigo "
                                 + "= cp.codigo where cp.id = "
                                 +res.getString(1)+";");
                if(res3.next()){
                    do{
                    producto += res3.getString(1)+", ";
                    }while(res3.next());
                }
                comP.setFolio(folio);
                comP.setProducto(producto);
                comP.setFecha(res.getString(2));
                comP.setHora(hora);
                comP.setTotal(Double.parseDouble(res.getString(4)));
                
                ventasP.add(comP);
                
                } while (res.next());
            }
        } catch (Exception e) {
        }
    }
    
    //Metodos Clientes
    @FXML void agregarCliente(){
        try {
            int id = 0;
            ResultSet res = db.consulta("select id from cliente order by id "
                            + "DESC LIMIT 0,1;");
            if(res.next()){
                id = Integer.parseInt(res.getString(1));
            }
            id++;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/"
                                + "turing/santabarbara/view/VistaCliente.fxml")
                                );
            Parent root = loader.load();
            ControlCliente controlC = loader.getController();
            controlC.iniAtt(cliente);
            controlC.construc(config, db, log);
            Stage stageC = new Stage();
            Scene sceneC = new Scene(root);
            stageC.initModality(Modality.APPLICATION_MODAL);
            stageC.setTitle(config.getProperty("name.proyect") +" - Clientes");
            stageC.setScene(sceneC);
            controlC.lblNumCli.setText(String.valueOf(id));
            stageC.showAndWait();
            Cliente c = controlC.getCli();
            if(c != null){
                this.cliente.add(c);
                if(c.getNombre().toLowerCase().contains(this.txtBusCliente
                   .getText().toLowerCase())){
                   this.filtroCliente.add(c);
                }
                tablCliente.refresh();
            }
        } catch (IOException ex) {
        } catch (SQLException ex) {
        }
    }
    
    @FXML void eliminarCliente(){
        Cliente c = this.tablCliente.getSelectionModel().getSelectedItem();
        if(c == null){
            error("¡Debes seleccionar un cliente de la tabla!");
        }else{
            info("¡Ha sido borrrado correctamente!");
            db.consulta("delete from cliente where id = "+c.getIdCliente()+";");
            this.cliente.remove(c);
            this.filtroCliente.remove(c);
            this.tablCliente.refresh();
        }
    }
    
    @FXML void editarCliente(){
        Cliente cli = this.tablCliente.getSelectionModel().getSelectedItem();
        if(cli == null){
            error("Debes Seleccionar un cliente a modificar");
        }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com"
                                    + "/turing/santabarbara/view/"
                                    + "VistaCliente.fxml"));
                Parent root = loader.load();
                ControlCliente controlC = loader.getController();
                controlC.iniAtt(cliente, cli);
                controlC.construc(config, db, log);
                Stage stageC = new Stage();
                Scene sceneC = new Scene(root);
                stageC.initModality(Modality.APPLICATION_MODAL);
                stageC.setTitle(config.getProperty("name.proyect") 
                                +" - Cliente");
                stageC.setScene(sceneC);
                stageC.showAndWait();
                
                Cliente auxC = controlC.getCli();
                if(auxC != null){
                    if(!auxC.getNombre().toLowerCase().contains(
                       this.txtBusCliente.getText().toLowerCase())){
                        this.filtroCliente.remove(auxC);
                    }
                    tablCliente.refresh();
                }
            } catch (IOException ex) {
            }
        }
    }
    
    @FXML void buscarCliente(){
        String client = this.txtBusCliente.getText();
        if(client.isEmpty()){
            this.tablCliente.setItems(cliente);
        }else{
            this.filtroCliente.clear();
            for (Cliente c: this.cliente) {
                if(c.getNombre().toLowerCase().contains(client.toLowerCase())){
                    this.filtroCliente.add(c);
                }
            }
            this.tablCliente.setItems(filtroCliente);
        }
    }
    
    public void cargarTablaCliente(){
        try {
                ResultSet resultado = db.consulta("select * from cliente;");
            if (resultado.next()) {
                do {     
                Cliente objCliente = new Cliente();
                objCliente.setIdCliente(Integer.parseInt(resultado.getString(1)
                ));
                objCliente.setNombre(resultado.getString(2));
                objCliente.setApellido(resultado.getString(3));
                objCliente.setFechaReg(resultado.getString(4));
                objCliente.setEmail(resultado.getString(5));
                objCliente.setTelefono(resultado.getString(6));
                cliente.add(objCliente);
                } while (resultado.next());
             
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Metodos Productos
    @FXML public void addProduct(){
        try {
            int id = 0;
            ResultSet res = db.consulta("select codigo from producto order by "
                            + "codigo desc LIMIT 0,1;");
            
            if(res.next()){
                id = Integer.parseInt(res.getString(1));
            }
            id++;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/"
                                + "turing/santabarbara/view/Producto.fxml"));
            Parent root = loader.load();
            ProductoControl controlP = loader.getController();
            controlP.iniAtt(productos);
            controlP.construct(config, db, log);
            controlP.cnProvProduc.setItems(Proveedor);
            controlP.cbAlmProduc.setItems(Almacen);
            Stage stageS = new Stage();
            Scene sceneS = new Scene(root);
            stageS.initModality(Modality.APPLICATION_MODAL);
            stageS.setTitle(config.getProperty("name.proyect") +" - Productos");
            stageS.setScene(sceneS);
            controlP.lbIdProduct.setText(String.valueOf(id));
            stageS.showAndWait();
            Producto p = controlP.getPro();
            if(p != null){
                this.productos.add(p);
                tab_suc.refresh();
            }
            
        } catch (IOException ex) {
        } catch (SQLException ex) {
        }
    }
    
    @FXML void modProduct(){
        Producto p = this.tabProduct.getSelectionModel().getSelectedItem();
        if(p == null){
            error("Debes Seleccionar una sucursal a modificar");
        }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com"
                                    + "/turing/santabarbara/view/Producto.fxml")
                                    );
                Parent root = loader.load();
                ProductoControl controlP = loader.getController();
                controlP.iniAtt(productos, p);
                controlP.construct(config, db, log);
                controlP.cnProvProduc.setItems(Proveedor);
                controlP.cbAlmProduc.setItems(Almacen);
                Stage stageP = new Stage();
                Scene sceneP = new Scene(root);
                stageP.initModality(Modality.APPLICATION_MODAL);
                stageP.setTitle(config.getProperty("name.proyect") 
                                +" - Productos");
                stageP.setScene(sceneP);
                stageP.showAndWait();
                
                Producto auxP = controlP.getPro();
                if(auxP != null){
                    tabProduct.refresh();
                }
            } catch (IOException ex) {
            }
        }
    }
    @FXML void dropProduct(ActionEvent ev){
        Producto p = this.tabProduct.getSelectionModel().getSelectedItem();
        if(p == null){
            error("¡Debes seleccionar una sucursal de la tabla!");
        }else{
            info("¡Ha sido borrrada correctamente!");
            db.consulta("delete from producto where codigo="+p.getIdProducto()
                        +";");
            this.productos.remove(p);
            this.filtroProducto.remove(p);
            this.tabProduct.refresh();
        }
    }
    
    @FXML void filterProduct(KeyEvent ev){
        String producto = this.txtFilterProdcuto.getText();
        if(producto.isEmpty()){
            this.tabProduct.setItems(productos);
        }else{
            this.filtroProducto.clear();
            for (Producto p : this.productos) {
                if(p.getCompuesto().toLowerCase().contains(producto.toLowerCase
                   ())){
                    this.filtroProducto.add(p);
                }
            }
            this.tabProduct.setItems(filtroProducto);
        }
    }
    
    @FXML public void cargarTabPro(){
        try {
            ResultSet res = db.consulta("select p.*, a.*, e.nombre 'proveedorN'"
                            + "from producto p join almacen a on "
                            + "p.idalmacen=a.idalmacen join sucursal s on "
                            + "s.idsucursal = a.idsucursal join proveedor e on "
                            + "p.idproveedor = e.idproveedor where "
                            + "s.idsucursal="+usuario.getIdSuc()+";");
            if(res.next()){
                do{
                    classProduct = new Producto();
                    classProduct.setIdProducto(Integer.parseInt(
                                               res.getString(1)));
                    classProduct.setProducto(res.getString(2));
                    classProduct.setCompuesto(res.getString(3));
                    classProduct.setLote(res.getString(4));
                    classProduct.setCaducidad(res.getString(5));
                    classProduct.setCantidad(res.getString(6));
                    classProduct.setProveedor(res.getString(8)+" - "
                    +res.getString("proveedorN"));
                    classProduct.setPrecio(Double.parseDouble(res.getString(7))
                    );
                    classProduct.setAlmacen(res.getString(9)+" - "
                                +res.getString("rack")+": "
                                +res.getString("ubicacion"));
                    productos.add(classProduct);
                    listProduct.add(classProduct.getIdProducto()+" - "
                                    +classProduct.getCompuesto());
                    
                }while(res.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error Tab Suc: "+ex.getMessage());
        }
    }
    
    public void cargarCmbProve(){
        try {
            ResultSet res = db.consulta("select idproveedor, nombre from "
                            + "proveedor;");
            if (res.next()) {
                do {
                Proveedor.add(res.getString(1)+" - "+res.getString(2));
                
                } while (res.next());
                
            }
        } catch (Exception e) {
        }
    }
    
    public void cargarCmbAlm(){
        try {
            ResultSet res = db.consulta("select * from almacen where idsucursal"
                            + " = "+usuario.getIdSuc()+";");
            if (res.next()) {
                do {
                Almacen.add(res.getString(1)+" - "+res.getString(2)+": "
                            +res.getString(3));
                } while (res.next());
                
                
            }
        } catch (Exception e) {
        }
    }
    
    //Metodos Empleados
    @FXML void agregarEmpleado(){
    
    }
    @FXML void eliminarEmpleado(){
    
    }
    @FXML void editarEmpleado(){
    
    }
    @FXML void buscarEmpleado(){
    
    }
    
    //Otros Metodos
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
        sucursales = FXCollections.observableArrayList();
        filtroSuc = FXCollections.observableArrayList();
        this.tab_suc.setItems(sucursales);
        this.numSucTB.setCellValueFactory(new PropertyValueFactory("idSuc"));
        this.nomSucTB.setCellValueFactory(new PropertyValueFactory("nombreSuc")
        );
        this.direccionSucTB.setCellValueFactory(new PropertyValueFactory(
                                                "direccionSuc"));
        
        productos = FXCollections.observableArrayList();
        filtroProducto = FXCollections.observableArrayList();
        listProduct = FXCollections.observableArrayList();
        
        //combobox
        Almacen = FXCollections.observableArrayList();
        Proveedor = FXCollections.observableArrayList();
        this.tabProduct.setItems(productos);
        this.idProduct.setCellValueFactory(new PropertyValueFactory(
                                           "idProducto"));
        this.nomProduct.setCellValueFactory(new PropertyValueFactory(
                                            "producto"));
        this.comProduct.setCellValueFactory(new PropertyValueFactory(
                                            "compuesto"));
        this.fechaProduct.setCellValueFactory(new PropertyValueFactory(
                                              "caducidad"));
        this.cantidadProduct.setCellValueFactory(new PropertyValueFactory(
                                                 "cantidad"));
        
        ventasP = FXCollections.observableArrayList();
        ventasT = FXCollections.observableArrayList();
        filtroVentasP = FXCollections.observableArrayList();
        this.tabSell.setItems(ventasP);
        this.clNumVenta.setCellValueFactory(new PropertyValueFactory(
                                            "id"));
        this.clFolioVenta.setCellValueFactory(new PropertyValueFactory(
                                              "folio"));
        this.clProductVenta.setCellValueFactory(new PropertyValueFactory(
                                                "producto"));
        this.clFechaVenta.setCellValueFactory(new PropertyValueFactory(
                                              "fecha"));
        this.clHoraVenta.setCellValueFactory(new PropertyValueFactory("hora"));
        this.clTotalVenta.setCellValueFactory(new PropertyValueFactory("total")
                                              );
     
        proveedor = FXCollections.observableArrayList();
        filtroProveedor = FXCollections.observableArrayList();
        this.tablaProveedor.setItems(proveedor);
        this.numeroProve.setCellValueFactory(new PropertyValueFactory(
                                             "idProveedor"));
        this.nombreProveedor.setCellValueFactory(new PropertyValueFactory(
                                                 "nombre"));
        this.direccionProveedor.setCellValueFactory(new PropertyValueFactory(
                                                    "direccion"));
        this.telProveedor.setCellValueFactory(new PropertyValueFactory(
                                              "telefono"));
        this.rfcProveedor.setCellValueFactory(new PropertyValueFactory(
                                              "rfc"));
        
        cliente = FXCollections.observableArrayList();
        filtroCliente = FXCollections.observableArrayList();
        this.tablCliente.setItems(cliente);
        this.numCliente.setCellValueFactory(new PropertyValueFactory(
                                            "idCliente"));
        this.nomCliente.setCellValueFactory(new PropertyValueFactory(
                                            "nombre"));
        this.apellidoCliente.setCellValueFactory(new PropertyValueFactory(
                                                 "apellido"));
        this.fechReg.setCellValueFactory(new PropertyValueFactory(
                                         "fechaReg"));
        this.emailCliente.setCellValueFactory(new PropertyValueFactory(
                                              "email"));
        this.telCliente.setCellValueFactory(new PropertyValueFactory(
                                            "telefono"));
    }   
    
}

package com.turing.santabarbara.modelo;

import com.turing.santabarbara.model.clas.Usuario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Conexion para la base de datos.
 * 
 * @author Turing
 * @version 1.0
 */

public class BaseDatos {
    Connection conex;
    String dbHost;
    String dbPort;
    String dbName;
    String dbUser;
    String dbPass;
    Properties config;
    FileReader read;
    
    /**
     * Metodo que inicia el constructor de la clase
     * @param config recibe la clase Properties de java para poder leer el 
     * archivo con el siguiente parametro
     * @param read recibe el archivo config.properties y lee mediante la clase 
     * FileReader.
     */
    public BaseDatos(Properties config, FileReader read) {
        this.config = config;
        this.read = read;
        datosServidor();
    }
    
    void datosServidor(){
        try {
            config.load(read);
            dbHost = config.getProperty("db.host");
            dbPort = config.getProperty("db.port");
            dbName = config.getProperty("db.name");
            dbUser = config.getProperty("db.user");
            dbPass = config.getProperty("db.password");
        }  catch (FileNotFoundException ex) {
            System.out.println("Error 3: "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error 4: "+ex.getMessage());
        }
    }
    
    public void Conexion(){
        try {
            //Conector para Mysql.
            Class.forName("com.mysql.cj.jdbc.Driver");
            String query = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName
                           +"?useUnicode=true&useJDBCCompliantTimezoneShift"
                           + "=true&useLegacyDatetimeCode=false&serverTimezone"
                           + "=UTC";
            conex = DriverManager.getConnection(query, dbUser, dbPass);
        } catch (SQLException ex) {
            System.out.println("Error 1: "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
                System.out.println("Error 2: "+ex.getMessage());
        }
    }
    
    /**
     * @param query recibe una cadena de texto con la consulta que se va a 
     * ejecutar
     * @return devuelve el valor de la consulta 
     */
    public ResultSet consulta(String query){
        ResultSet con=null;
        Statement sm;
        try {
            sm = conex.createStatement();
            con = sm.executeQuery(query);
        } catch (SQLException e) {
        }
        return con;
    }
    /**
     * @param query recibe una cadena de texto con la consulta que se va a 
     * ejecutar
     */
    public void actualizar(String query){
        Statement sm;
        try {
            sm = conex.createStatement();
            sm.execute(query);
        } catch (SQLException e) {
            System.err.println("Error "+e.getMessage());
        }
    }
    
    
    /**
     * 
     * @param userU Se utiliza la clase Usuario para utilizar los métodos del 
     * objeto
     * @param user Se para cmo parametro el cual contiene el nombre del usuario
     * @param pass Contiene la contraseña del usuario
     * @return se devuelve "true" o "false" según los datos sean encontrados
     */
    
    public boolean datosUsuario(Usuario userU, String user, String pass){
        try {
            ResultSet res = consulta("select * from empleado where "
                            + "nombreUsuario='"+user+"' and password='"
                            +pass+"' and activoUsuario='1';");
            if(res.next()){
                userU.setIdUsuario(Integer.parseInt(res.getString("idEmpleado")
                                   ));
                userU.setNombre(res.getString("nombre"));
                userU.setApellidos(res.getString("apellidoPaterno")+" "
                                   +res.getString("apellidoMaterno"));
                userU.setUsuario(res.getString("nombreUsuario"));
                userU.setPassword(res.getString("password"));
                userU.setEmail(res.getString("email"));
                userU.setDireccion(res.getString("direccion"));
                userU.setTelefono(res.getString("telefono"));
                userU.setFechaNacimiento(res.getString("fechaNacimiento"));
                userU.setFechaNacimiento(res.getString("fechaIngreso"));
                userU.setNss(res.getString("nss"));
                userU.setRfc(res.getString("rfc"));
                userU.setCurp(res.getString("curp"));
                userU.setIdSuc(Integer.parseInt(res.getString("idSucursal")));
                userU.setIdTurno(Integer.parseInt(res.getString("idTurno")));
                userU.setIdPuesto(Integer.parseInt(res.getString("idPuesto")));
                userU.setIdImss(Integer.parseInt(res.getString("idImss")));
                userU.setActUsuario(Integer.parseInt(res.getString(
                                    "activoUsuario")));
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error Login:"+ex.getMessage());
        }
        return false;
    }
    
}

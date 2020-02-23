package com.turing.santabarbara.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class Logica {

    Properties config;
    FileReader read;
    
    String proyectoN;
    String proyectoNS;

    public String getProyectoN() {
        return proyectoN;
    }
    
    public String getProyectoNS() {
        return proyectoNS;
    }
    
    /**
     * Constructor de la clase para cargar la configuracion predeterminada del 
     * archivo de configuracion
     * @param config Recibe la clase Properties para leer un archivo .properties
     * @param read recibe el archivo y comienza a leer las lineas de 
     * configuración.
     */
    
    public Logica(Properties config, FileReader read) {
        this.config = config;
        this.read = read;
        proyecto();
    }
    
    public void proyecto(){
        try {
            config.load(read);
            proyectoN = config.getProperty("name.proyect");
            proyectoNS = config.getProperty("name.proyectS");
        }  catch (FileNotFoundException ex) {
            System.out.println("Error 3: "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error 4: "+ex.getMessage());
        }
    }
    
    /**
     * Metodo para encryptar la contraseña en MD5
     * @param pass recibe la cadena con la contraseña del usuario
     * @return regresa la cadena de texto encryptada en MD5
     */
    
    public String getMD5(String pass) {
        try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(pass.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
}

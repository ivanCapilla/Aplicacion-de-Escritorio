
package com.turing.santabarbara.modelo;

import com.turing.santabarbara.view.VistaSplash;

public class HiloSplash extends Thread{
    
    VistaSplash vista;
    
    /**
     * Se inicializa el contructor HiloSplash
     * @param vista utiliza el objeto "vista" para hacer visible la interfaz 
     * "VistaSplash"
     */
    
    public HiloSplash(VistaSplash vista){
        this.vista = vista;
    }
     
    @Override
    public void run(){
        super.run();
        int cont = 0;
        boolean estado = true;
        while(estado){
        cont++;
            for(int i=0; i<9; i++){
                try{
                    vista.JlImagen.setIcon(vista.imagen[i]);
                    Thread.sleep(300);
                }catch(Exception e){
                    
                }
            }
        if(cont > 2){
                estado = false;
                vista.setVisible(false);
            }
        }
    }
}

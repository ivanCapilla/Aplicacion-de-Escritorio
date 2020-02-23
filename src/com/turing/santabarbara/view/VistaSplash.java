
package com.turing.santabarbara.view;

import javax.swing.ImageIcon;

public class VistaSplash extends javax.swing.JFrame {
    
    public ImageIcon imagen[] = new ImageIcon[10];

    public VistaSplash() {
        initComponents();
        setLocationRelativeTo(null);
        
        imagen[0] = new ImageIcon("img/Im1.png");
        imagen[1] = new ImageIcon("img/Im2.png");
        imagen[2] = new ImageIcon("img/Im3.png");
        imagen[3] = new ImageIcon("img/Im4.png");
        imagen[4] = new ImageIcon("img/Im5.png");
        imagen[5] = new ImageIcon("img/Im6.png");
        imagen[6] = new ImageIcon("img/Im7.png");
        imagen[7] = new ImageIcon("img/Im8.png");
        imagen[8] = new ImageIcon("img/Im9.png");
        imagen[9] = new ImageIcon("img/Im10.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JlImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/turing/santabarbara/view/Im1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JlImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JlImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JlImagen;
    // End of variables declaration//GEN-END:variables
}

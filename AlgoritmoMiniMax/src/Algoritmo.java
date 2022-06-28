/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RLandeta
 */
public class Algoritmo extends javax.swing.JFrame {

    /**
     * Creates new form Algoritmo
     */
    gato g=new gato();	
    gato r=new gato();	
    
    
    public void lee(gato g){	
        for (int i=0;i<3;i++){	
            for (int j=0;j<3;j++){	
                g.cat[i][j]=0;	
            }	
        }	
        if(jButton1.getText().equals("O")){	
            g.cat[0][0]=-1;	
        }	
        if(jButton1.getText().equals("X")){	
            g.cat[0][0]=1;	
        }	
        if(jButton2.getText().equals("O")){	
            g.cat[0][1]=-1;	
        }	
        if(jButton2.getText().equals("X")){	
            g.cat[0][1]=1;	
        }        	
        if(jButton3.getText().equals("O")){	
            g.cat[0][2]=-1;	
        }	
        if(jButton3.getText().equals("X")){	
            g.cat[0][2]=1;	
        }        	
        if(jButton4.getText().equals("O")){	
            g.cat[1][0]=-1;	
        }	
        if(jButton4.getText().equals("X")){	
            g.cat[1][0]=1;	
        }        	
        if(jButton5.getText().equals("O")){	
            g.cat[1][1]=-1;	
        }	
        if(jButton5.getText().equals("X")){	
            g.cat[1][1]=1;	
        }        	
        if(jButton6.getText().equals("O")){	
            g.cat[1][2]=-1;	
        }	
        if(jButton6.getText().equals("X")){	
            g.cat[1][2]=1;	
        }        	
        if(jButton7.getText().equals("O")){	
            g.cat[2][0]=-1;	
        }	
        if(jButton7.getText().equals("X")){	
            g.cat[2][0]=1;	
        }        	
        if(jButton8.getText().equals("O")){	
            g.cat[2][1]=-1;	
        }	
        if(jButton8.getText().equals("X")){	
            g.cat[2][1]=1;	
        }        	
        if(jButton9.getText().equals("O")){	
            g.cat[2][2]=-1;	
        }	
        if(jButton9.getText().equals("X")){	
            g.cat[2][2]=1;	
        }        	
    }	
    public void escribe(gato g){	
        if(g.cat[0][0]==1){	
            jButton1.setText("X");	
        }	
        if(g.cat[0][0]==-1){	
            jButton1.setText("O");	
        }	
        if(g.cat[0][1]==1){	
            jButton2.setText("X");	
        }	
        if(g.cat[0][1]==-1){	
            jButton2.setText("O");	
        }	
        if(g.cat[0][2]==1){	
            jButton3.setText("X");	
        }	
        if(g.cat[0][2]==-1){	
            jButton3.setText("O");	
        }	
        if(g.cat[1][0]==1){	
            jButton4.setText("X");	
        }	
        if(g.cat[1][0]==-1){	
            jButton4.setText("O");	
        }	
        if(g.cat[1][1]==1){	
            jButton5.setText("X");	
        }	
        if(g.cat[1][1]==-1){	
            jButton5.setText("O");	
        }	
        if(g.cat[1][2]==1){	
            jButton6.setText("X");	
        }	
        if(g.cat[1][2]==-1){	
            jButton6.setText("O");	
        }	
        if(g.cat[2][0]==1){	
            jButton7.setText("X");	
        }	
        if(g.cat[2][0]==-1){	
            jButton7.setText("O");	
        }	
        if(g.cat[2][1]==1){	
            jButton8.setText("X");	
        }	
        if(g.cat[2][1]==-1){	
            jButton8.setText("O");	
        }	
        if(g.cat[2][2]==1){	
            jButton9.setText("X");	
        }	
        if(g.cat[2][2]==-1){	
            jButton9.setText("O");	
        }	
        	
    }	

    
    
    
    
    public void sucesores(gato g,int quientira,gato hijos[]){	
        int n=0;	
        for (int i=0;i<3;i++){	
            for (int j=0;j<3;j++){	
                if (g.cat[i][j]==0){	
                    for (int k=0;k<3;k++){	
                        for (int l=0;l<3;l++){	
                            hijos[n].cat[k][l]=g.cat[k][l];	
                        }	
                    }	
                    hijos[n].cat[i][j]=quientira;	
                    n++;	
                }	
            }	
        }	
        g.numerohijos=n;	
    }	
    
    public boolean hayespacios(gato g){	
        for(int i=0;i<3;i++){	
            for(int j=0;j<3;j++){	
                if(g.cat[i][j]==0){	
                    return true;	
                }	
            }	
        }        	
        return false;	
    }	
    //recibe un gato g, quientira = 0 (maximizar =par, minimizar=non), entrego un gato r como el mejor
    public int minimax(gato g,int quientira,gato r){
        int valor1,valor2,temp; //valor1,2,temp son para llevar el control del valor del gato	
	valor1=evalua(g); //1 = maquina gano -1 si hombre gano 0 si hay empate y 2 aun no termina el juego
        gato hijos[],resultado2; //variables de paso y hijos[] seran los sucesores de g	
        hijos= new gato[9]; //creo 	
        for (int i=0;i<9;i++){	//instancio o inicializo
            hijos[i]=new gato();	
	}
        resultado2= new gato();	
        if (valor1>=-1 && valor1<=1){ //si el gato esta entre -1 y 1 exito
         for (int k=0;k<3;k++){	
           for (int l=0;l<3;l++){	
	     r.cat[k][l]=g.cat[k][l];
           }	
	 }
	}else{
          //si no fue exito
          temp=quientira%2;	
          if (temp==0){	
              //maquina maximiza
              //generar sucesores
              sucesores(g,1,hijos);	
              valor1=-10;	
              for (int n=0;n<g.numerohijos;n++){	
                valor2=minimax(hijos[n],quientira+1,resultado2);	
                if (valor2>valor1){	
                   valor1=valor2;	
                   for (int k=0;k<3;k++){	
                    for (int l=0;l<3;l++){	
                       r.cat[k][l]=hijos[n].cat[k][l];	
                    }	
                   }	
                }	
              }	
          }else{	
              //tira el hombre minimiza	
              sucesores(g,-1,hijos);	
              valor1=10;	
              for (int n=0;n<g.numerohijos;n++){	
                valor2=minimax(hijos[n],quientira+1,resultado2);	
                if (valor2<valor1){	
                   valor1=valor2;	
                   for (int k=0;k<3;k++){	
                    for (int l=0;l<3;l++){	
                       r.cat[k][l]=hijos[n].cat[k][l];	
                    }	
                   }	
                }	
              }	
              	
          }	
        }	
        return valor1;	
    }	
    
    public int evalua(gato g){	
        //suma de horizontales, verticales y diagonales
        int h1=g.cat[0][0]+g.cat[0][1]+g.cat[0][2];	
        int h2=g.cat[1][0]+g.cat[1][1]+g.cat[1][2];	
        int h3=g.cat[2][0]+g.cat[2][1]+g.cat[2][2];	
        int v1=g.cat[0][0]+g.cat[1][0]+g.cat[2][0];	
        int v2=g.cat[0][1]+g.cat[1][1]+g.cat[2][1];	
        int v3=g.cat[0][2]+g.cat[1][2]+g.cat[2][2];	
        int d1=g.cat[0][0]+g.cat[1][1]+g.cat[2][2];	
        int d2=g.cat[2][0]+g.cat[1][1]+g.cat[0][2];	
        if(h1==3||h2==3||h3==3||v1==3||v2==3||v3==3||d1==3||d2==3){	
            return 1;	
        }else{	
            if(h1==-3||h2==-3||h3==-3||v1==-3||v2==-3||v3==-3||d1==-3||d2==-3){	
                return -1;	
            }else{	
                if (hayespacios(g)){	
                    return 2;	
                }else{	
                    return 0;	
                }	
            }	
        }	
    }	
   
    public Algoritmo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Tira Maquina");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(57, 57, 57)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        // los botones los voy a traducir en un matriz clase gato
        lee(g);
        // envio la clase gato al algoritmo
        int valor=minimax(g,0,r);
        // regresa r el algoritmo
        // r lo traduzco modificando los textos en los botones
        escribe(r);
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jButton1.getText().equals("")){
            jButton1.setText("O");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (jButton2.getText().equals("")){
           jButton2.setText("O"); 
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jButton3.getText().equals("")){
            jButton3.setText("O");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jButton4.getText().equals("")){
            jButton4.setText("O");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (jButton5.getText().equals("")){
            jButton5.setText("O");
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (jButton6.getText().equals("")){
            jButton6.setText("O");
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (jButton7.getText().equals("")){
            jButton7.setText("O");
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (jButton8.getText().equals("")){
            jButton8.setText("O");
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         if (jButton9.getText().equals("")){
            jButton9.setText("O"); 
         }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Algoritmo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Algoritmo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Algoritmo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Algoritmo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Algoritmo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    // End of variables declaration//GEN-END:variables
}

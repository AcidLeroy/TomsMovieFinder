/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LimitSizePanel.java
 *
 * Created on Oct 7, 2011, 7:35:20 AM
 */
package views;

import controller.Controller;
import model.Model;

/**
 *
 * @author gq114c
 */
public class LimitSizePanel extends javax.swing.JPanel implements IUpdateView{

    
    private Controller controller; 
    /** Creates new form LimitSizePanel */
    public LimitSizePanel() {
	this(null); 
	
    }
    public LimitSizePanel(Controller controller){
	this.controller = controller; 
	initComponents();
	minFileSize.addPropertyChangeListener(controller);
	minFileSize.setName("File Size Change");
	//minFileSize.addPropertyChangeListener("File Size Change", this.controller);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        minFileSize = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("Minimum File Size:");

        minFileSize.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jLabel2.setText("GB");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minFileSize, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(minFileSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField minFileSize;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateView() {
	Model m = controller.getModel(); 
	minFileSize.setValue(new Float(m.getMinMovieFileSize()));
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SearchOptionsFrame.java
 *
 * Created on Oct 4, 2011, 6:35:26 PM
 */
package views;

import controller.Controller;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


/**
 *
 * @author gq114c
 */
public class SearchOptionsFrame extends javax.swing.JFrame implements IUpdateView {

    private Controller controller;

    /** Creates new form SearchOptionsFrame */
    public SearchOptionsFrame() {
	this(null);
    }

    public SearchOptionsFrame(Controller c) {
	this.controller = c;
	initComponents();
	
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vlcChooser = new javax.swing.JFileChooser();
        directoryKeywordPanel1 = new views.DirectoryKeywordPanel(controller);
        formatPanel1 = new views.FormatPanel(controller);
        jButton1 = new javax.swing.JButton();
        searchDepthField = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vlcPathField = new javax.swing.JTextField();
        vlcDialogBtn = new javax.swing.JButton();
        directoryOptionsPanel1 = new views.DirectoryOptionsPanel(controller);

        vlcChooser.setCurrentDirectory(new java.io.File("C:\\Program Files"));
        vlcChooser.setDialogTitle("Choose VLC ");

        setTitle("Search Options");

        directoryKeywordPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Directory Keyword Options"));

        formatPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Video Format Options"));

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        searchDepthField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel1.setText("Directory Search Depth:");

        jLabel2.setText("VLC Player Location:");

        vlcPathField.setEditable(false);
        vlcPathField.setText("vlc.exe");

        vlcDialogBtn.setText("Set VLC Location");
        vlcDialogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vlcDialogBtnActionPerformed(evt);
            }
        });

        directoryOptionsPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Directory Search Options"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(directoryOptionsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formatPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(directoryKeywordPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vlcPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(vlcDialogBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchDepthField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatPanel1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(directoryKeywordPanel1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(directoryOptionsPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchDepthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vlcDialogBtn)
                    .addComponent(jLabel2)
                    .addComponent(vlcPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	try {
	    searchDepthField.commitEdit();
	} catch (ParseException ex) {
	    Logger.getLogger(SearchOptionsFrame.class.getName()).log(Level.SEVERE, null, ex);
	}
	Number num = (Number) searchDepthField.getValue();
	controller.getModel().setSearchDepth(num.intValue());
	
	this.setVisible(false);
	updateView();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void vlcDialogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vlcDialogBtnActionPerformed
	if (vlcChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	    controller.getModel().setVlcLocation(vlcChooser.getSelectedFile());
	    updateView();
	}
    }//GEN-LAST:event_vlcDialogBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {

	    public void run() {
		new SearchOptionsFrame().setVisible(true);
	    }
	});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private views.DirectoryKeywordPanel directoryKeywordPanel1;
    private views.DirectoryOptionsPanel directoryOptionsPanel1;
    private views.FormatPanel formatPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField searchDepthField;
    private javax.swing.JFileChooser vlcChooser;
    private javax.swing.JButton vlcDialogBtn;
    private javax.swing.JTextField vlcPathField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateView() {
	searchDepthField.setValue(new Integer(controller.getModel().getSearchDepth()));
	directoryKeywordPanel1.updateView();
	directoryOptionsPanel1.updateView(); 
	formatPanel1.updateView();
	vlcPathField.setText(controller.getModel().getVlcLocation().toString());
    }
}

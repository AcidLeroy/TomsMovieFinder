/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MovieViewerPanel.java
 *
 * Created on Oct 3, 2011, 4:30:23 PM
 */
package views;

import javax.swing.table.*;
import model.Model;
import model.Movie;

/**
 *
 * @author gq114c
 */
public class MovieViewerPanel extends javax.swing.JPanel implements IUpdateView {

    DefaultTableModel tModel;
    private Model model;

    /** Creates new form MovieViewerPanel */
    public MovieViewerPanel(Model model) {
	this.model = model;
	initComponents();
	tModel = new DefaultTableModel();
	tModel.addColumn("Title");
	tModel.addColumn("Format");

	updateView();

    }

    public MovieViewerPanel() {
	initComponents();
	tModel = new DefaultTableModel();
	updateView();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        movieTable = new javax.swing.JTable();

        movieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Format"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(movieTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable movieTable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateView() {

//	for(int i =0 ; i<tModel.getRowCount(); i++){
//	    tModel.removeRow(i);
//	}

	if (tModel.getDataVector() != null) {
	    tModel.getDataVector().removeAllElements();
	}

	Object col[] = new Object[2];

	for (Movie m : model.getMovies().getMovieList()) {
	    col[0] = m.getTitle();
	    col[1] = m.getFormat();
	    tModel.addRow(col);
	}


	movieTable.setModel(tModel);


	System.out.println("called update views");



    }
}
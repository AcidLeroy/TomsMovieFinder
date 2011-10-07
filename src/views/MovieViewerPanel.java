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

import controller.Controller;
import java.util.HashMap;
import javax.swing.RowSorter;
import javax.swing.table.*;
import model.Model;
import model.Movie;

/**
 *
 * @author gq114c
 */
public class MovieViewerPanel extends javax.swing.JPanel implements IUpdateView {

    private DefaultTableModel tModel;
    private Controller controller;
    private HashMap<String, Movie> movieHash;
    private RowSorter<DefaultTableModel> tableSort;

    /** Creates new form MovieViewerPanel */
    public MovieViewerPanel(Controller controller) {

	this.controller = controller;

	initComponents();
	movieHash = new HashMap<String, Movie>();
	tModel = new DefaultTableModel() {

	    @Override
	    public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	    }
	};
	tModel.addColumn("Title");
	tModel.addColumn("Format");
	tModel.addColumn("Size (MB)");
	tableSort = new TableRowSorter<DefaultTableModel>(tModel);
	movieTable.setRowSorter(tableSort);

    }

    public MovieViewerPanel() {
	this(null);
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

        movieTable.setAutoCreateRowSorter(true);
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
        movieTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

	Model model = controller.getModel();

	movieHash.clear();

	if (tModel.getDataVector() != null) {
	    tModel.getDataVector().removeAllElements();
	}

	Object col[] = new Object[3];

	if (model.getMovies().getMovieList().isEmpty()) {
	    System.out.println("movie list is empty");
	    col[0] = "";
	    col[1] = "";
	    col[3] = ""; 
	    tModel.addRow(col);
	}

	for (Movie m : model.getMovies().getMovieList()) {
	    
	    if (m.getSize() > model.getMinMovieFileSize()) {
		col[0] = m.getTitle();
		col[1] = m.getFormat();
		col[2] = m.getSize(); 
		movieHash.put(m.getTitle(), m);
		tModel.addRow(col);
	    }
	}


	movieTable.setModel(tModel);

	movieTable.getColumnModel().getColumn(0).setPreferredWidth(400);
	movieTable.getColumnModel().getColumn(1).setPreferredWidth(60);


	System.out.println("called update views");

    }

    public Movie getSelectedMovie() {
	int sRow = movieTable.getSelectedRow();
	Movie m = movieHash.get(movieTable.getValueAt(sRow, 0));
	return m;
    }
}

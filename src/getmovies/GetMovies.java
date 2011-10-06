/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getmovies;

import controller.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import views.testFrame;

/**
 *
 * @author gq114c
 */
public class GetMovies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	Model m = new Model();
	m.getSearchFormats().add("mp3");
	m.getSearchFormats().add("mov");
	m.getSearchFormats().add("m4v");


	m.getSearchKeywords().add("Videos");
	m.getSearchKeywords().add("movies");

	Controller controller = new Controller(m);
	final testFrame t = new testFrame(controller);
	try {
	    controller.initialize();
	} catch (IOException ex) {
	    Logger.getLogger(GetMovies.class.getName()).log(Level.SEVERE, null, ex);
	}

	

	java.awt.EventQueue.invokeLater(new Runnable() {

	    public void run() {

		t.setLocationRelativeTo(null);
		t.setVisible(true);

	    }
	});


    }
}

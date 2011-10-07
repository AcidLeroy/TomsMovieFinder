package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import model.Model;
import model.Movie;
import views.IUpdateView;

/**
 *
 * @author Cody W. Eilar <Cody.Eilar@Gmail.com>
 */
public class Controller implements ActionListener, WindowListener, PropertyChangeListener {

    private Model model;
    private CopyOnWriteArrayList<IUpdateView> viewList;
    private static final String filename = "savedStateOfGui.ser";
    //output streams
    private FileOutputStream fos;
    private ObjectOutputStream out;
    //input streams
    private FileInputStream fis;
    private ObjectInputStream in;

    public Controller(Model m) {
	this.model = m;
	viewList = new CopyOnWriteArrayList();


    }

    public Model getModel() {
	return this.model;
    }

    public void addViews(IUpdateView iv) {
	viewList.add(iv);
    }

    public void removeViews(IUpdateView iv) {
	viewList.remove(iv);
    }

    public void populateMovies() throws IOException {
	//Get search paths for movies 
	model.getMovies().removeAllMovies();
	MoviePathSearcher mps = new MoviePathSearcher(model);
	File[] roots = File.listRoots();
	for (File r : roots) {
	    Path p = Paths.get(r.getAbsolutePath());
	    EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
	    Files.walkFileTree(p, opts, model.getSearchDepth(), mps);
	}

	MovieSearcher ms = new MovieSearcher(model);
	//Get all the paths that supposedly have movies
	Path[] paths = mps.getPathsToMovies();

	//search for all the movies within those directories... no limit to depth
	for (Path path : paths) {
	    if (path != null) {
		Files.walkFileTree(path, ms);
	    }
	}

	//upate all the views with the new model data. 
	updateViews();

	for (Movie mov : model.getMovies().getMovieList()) {
	    System.out.println("movies in list:" + mov.getTitle());
	}
    }

    public void updateViews() {
	for (IUpdateView iv : viewList) {
	    if (iv != null) {
		iv.updateView();
	    }
	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	String cmd = e.getActionCommand();

	if (cmd.equals("Add Keyword")) {
	}

    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
	//we want to save the current state of the gui
	//for initialization when it is reopened. 
	saveGuiState();

    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    /**
     * Write the current state of the model to a file. 
     */
    public void saveGuiState() {
	try {
	    fos = new FileOutputStream(filename);
	    out = new ObjectOutputStream(fos);
	    out.writeObject(model);
	    out.close();
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void initialize() throws IOException {
	try {
	    fis = new FileInputStream(filename);
	    in = new ObjectInputStream(fis);
	    model = (Model) in.readObject();
	    in.close();
	    updateViews();
	} catch (FileNotFoundException ex) {
	    this.populateMovies();
	    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);

	} catch (IOException ex) {
	    this.populateMovies();
	    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	} catch (ClassNotFoundException ex) {
	    this.populateMovies();
	    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
	if (evt.getSource() instanceof JFormattedTextField) {
	    JFormattedTextField jtf = (JFormattedTextField) evt.getSource();
	    if ("File Size Change".equals(jtf.getName())) {
		Number num = (Number) jtf.getValue();

		if (num != null) {
		    model.setMinMovieFileSize(num.longValue());
		    updateViews();
		}

	    }
	}
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.Serializable;

import java.util.ArrayList;

/**
 *
 * @author gq114c
 */
public class Model implements Serializable{

    private Movies movies;
    private int searchDepth;
    private ArrayList<String> searchKeywords;
    private ArrayList<String> searchFormats;
    private ArrayList<File> FilesToExclude; 
    private ArrayList<File> FilesToInclude; 
    private File vlcLocation; 
    private long minMovieFileSize; 

    //create all objects in the model 
    public Model() {
	searchKeywords = new ArrayList<String>();
	searchFormats = new ArrayList<String>();
	FilesToExclude = new ArrayList<File>(); 
	FilesToInclude = new ArrayList<File>(); 
	vlcLocation = new File("C:\\Program Files\\VideoLAN\\VLC\\vlc.exe");
	//default the search depth to 2;
	searchDepth = 2; 
	movies = new Movies();
    }

    public Movies getMovies() {
	return this.movies;
    }

    public ArrayList<String> getSearchFormats() {
	return searchFormats;
    }

    public ArrayList<String> getSearchKeywords() {
	return searchKeywords;
    }

    public int getSearchDepth() {
	return searchDepth;
    }

    public void setSearchDepth(int searchDepth) {
	this.searchDepth = searchDepth;
    }

    public ArrayList<File> getFilesToExclude() {
	return FilesToExclude;
    }

    public File getVlcLocation() {
	return vlcLocation;
    }

    public void setVlcLocation(File vlcLocation) {
	this.vlcLocation = vlcLocation;
    }

    public long getMinMovieFileSize() {
	return minMovieFileSize;
    }

    public void setMinMovieFileSize(long minMovieFileSize) {
	this.minMovieFileSize = minMovieFileSize;
    }

    public ArrayList<File> getFilesToInclude() {
	return FilesToInclude;
    }

    public void setFilesToInclude(ArrayList<File> FilesToInclude) {
	this.FilesToInclude = FilesToInclude;
    }
    
    
    
}

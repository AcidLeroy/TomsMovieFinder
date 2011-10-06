/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author gq114c
 */
public class Model {

    private Movies movies;
    private int searchDepth;
    private ArrayList<String> searchKeywords;
    private ArrayList<String> searchFormats;
    private ArrayList<Path> pathsToExclude; 
    private Path vlcLocation; 

    //create all objects in the model 
    public Model() {
	searchKeywords = new ArrayList<String>();
	searchFormats = new ArrayList<String>();
	pathsToExclude = new ArrayList<Path>(); 
	vlcLocation = Paths.get("C:\\Program Files\\VideoLAN\\VLC\\vlc.exe");
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

    public ArrayList<Path> getPathsToExclude() {
	return pathsToExclude;
    }

    public Path getVlcLocation() {
	return vlcLocation;
    }

    public void setVlcLocation(Path vlcLocation) {
	this.vlcLocation = vlcLocation;
    }
    
    
    
}

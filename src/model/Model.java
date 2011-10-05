/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author gq114c
 */
public class Model {

    private Movies movies;
    private ArrayList<String> searchKeywords;
    private ArrayList<String> searchFormats;

    //create all objects in the model 
    public Model() {
	searchKeywords = new ArrayList<String>();
	searchFormats = new ArrayList<String>();
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
}

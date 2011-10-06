package model;

import java.io.File;
import java.io.Serializable;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Cody W. Eilar <Cody.Eilar@Gmail.com>
 */
public class Movies implements Serializable{

    CopyOnWriteArrayList<Movie> movies;
    /**
     * directory names to look for movies in. 
     */
    String[] movieDirs;

    public CopyOnWriteArrayList<Movie> getMovieList() {
        return this.movies;
    }

    public Movies() {
        movies = new CopyOnWriteArrayList();
    }

    public String[] getMovieDirs() {
        return movieDirs;
    }

    public void setMovieDirs(String[] movieDirs) {
        this.movieDirs = movieDirs;
    }

    public void addMovie(File movieFile, String title, String format) {
        movies.add(new Movie(movieFile, title, format));
    }

    public void removeMovie(Movie movieFile) {
        movies.remove(movieFile);
    }
    
    public void removeAllMovies() {
	movies.clear();
    }
}

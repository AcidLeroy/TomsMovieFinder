package model;

import java.nio.file.Path;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Cody W. Eilar <Cody.Eilar@Gmail.com>
 */
public class Movies {

    CopyOnWriteArrayList<Movie> movies;
    /**
     * directory names to look for movies in. 
     */
    String[] movieDirs;

    public CopyOnWriteArrayList<Movie> getMovies() {
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

    public void addMovie(Path moviePath, String title, String format) {
        movies.add(new Movie(moviePath, title, format));
    }

    public void removeMovie(Movie moviePath) {
        movies.remove(moviePath);
    }
}

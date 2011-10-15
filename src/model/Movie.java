package model;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Cody W. Eilar <Cody.Eilar@Gmail.com>
 *
 */
public class Movie implements Serializable {

    private File movieFile;
    private String title;
    private String description;
    private String format;
    private float size;

    public Movie(File FileToMovie, String title, String format) {
        movieFile = FileToMovie;
        this.title = title; 
        this.format = format;
        float d = FileToMovie.length(); 
        size = (float)(d/1073741824); //convert bytes to megabytes
    }

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return format;
    }

    public File getMovieFile() {
        return movieFile;
    }

    public float getSize() {
        return size;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Movie other = (Movie) obj;
	if (this.movieFile != other.movieFile && (this.movieFile == null || !this.movieFile.equals(other.movieFile))) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
	int hash = 3;
	return hash;
    }
    
    
}

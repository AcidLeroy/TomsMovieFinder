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
    private long size;

    public Movie(File FileToMovie, String title, String format) {
        movieFile = FileToMovie;
        this.title = title; 
        this.format = format;
        size = 0;
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

    public long getSize() {
        return size;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

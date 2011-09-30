package model;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;

/**
 *
 * @author Cody W. Eilar <Cody.Eilar@Gmail.com>
 *
 */
public class Movie implements Serializable {

    private Path moviePath;
    private String title;
    private String description;
    private String format;
    private long size;

    public Movie(Path pathToMovie, String title, String format) {
        moviePath = pathToMovie;
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

    public Path getMoviePath() {
        return moviePath;
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

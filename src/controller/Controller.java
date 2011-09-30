package controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movie;
import model.Movies;

/**
 *
 * @author Cody W. Eilar <Cody.Eilar@Gmail.com>
 */
public class Controller {

    Movies movies;
    String[] dirs = {"movies", "videos"};
    private int depth = 2;

    public Controller(Movies m) {
        this.movies = m;

    }

    public void populateMovies() throws IOException {
        //Get search paths for movies 
        MoviePathSearcher mps = new MoviePathSearcher(dirs);
        File[] roots = File.listRoots();
        for (File r : roots) {
            Path p = Paths.get(r.getAbsolutePath());
            EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
            Files.walkFileTree(p, opts, depth, mps);
        }

        MovieSearcher ms = new MovieSearcher(movies);
        //Get all the paths that supposedly have movies
        Path[] paths = mps.getPathsToMovies();

        //search for all the movies within those directories... no limit to depth
        for (Path path : paths) {
            if (path != null) {
                Files.walkFileTree(path, ms);
            }
        }

    }

    public static void main(String... args) {
        Movies m = new Movies();
        Controller c = new Controller(m);
        try {
            c.populateMovies();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Movie mov : m.getMovies()) {
            System.out.println("Movie: " + mov.getTitle());
        }
    }
}

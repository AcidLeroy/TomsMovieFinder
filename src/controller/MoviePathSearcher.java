package controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movies;

/**
 *
 * @author gq114c
 */
public class MoviePathSearcher implements FileVisitor<Path> {

    private final PathMatcher[] matcher;
    private Path[] pathsToMovies;
    private int pathIndex;
    private Movies movies;

    public MoviePathSearcher(String... pattern) {
        pathsToMovies = new Path[100];
        matcher = new PathMatcher[100];
        pathIndex = 0;
        int i = 0;
        for (String s : pattern) {
            matcher[i++] = FileSystems.getDefault().getPathMatcher("glob:" + s);
        }
    }

    

    public Path[] getPathsToMovies() {
        return pathsToMovies;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path p = dir.getFileName();
        //Verify directory is good. 
        if ((attrs.isDirectory()) && (p != null)) {

            //check directory against each possible movie directory search. 
            for (PathMatcher pm : matcher) {
                if (pm != null) {
                    if (pm.matches(p)) {
                        System.out.println("adding: " + dir);
                        pathsToMovies[pathIndex++] = dir;
                    }
                }
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String... args) {



        File[] roots = File.listRoots();
        MoviePathSearcher ms = new MoviePathSearcher("movies");
        for (File r : roots) {
            Path p = Paths.get(r.getAbsolutePath());
            EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

            try {
                Files.walkFileTree(p, opts, 4, ms);
            } catch (IOException ex) {
                Logger.getLogger(MoviePathSearcher.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        Path[] moviePaths = ms.getPathsToMovies();
        System.out.println("Size is: " + moviePaths.length);
        for (Path pth : moviePaths) {
            if (pth != null) {
                System.out.println("A path I found: " + pth.getFileName());
            }
        }
    }
}

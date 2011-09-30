package controller;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Movies;

/**
 *
 * @author gq114c
 */
public class MovieSearcher implements FileVisitor<Path> {
    
    private Movies movies;
    String[] extensions = {"avi", "wmv", "mov", "m4v"};
    private static String regex1 = "(.+)\\.(";
    private static String regex2 = ")$";

    /**
     * After running the MoviePath searcher a movie searcher can be created
     */
    public MovieSearcher(Movies movies) {
        this.movies = movies;
    }
    
    public String[] getExtensions() {
        return extensions;
    }
    
    public void setExtensions(String[] extensions) {
        this.extensions = extensions;
    }
    
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        
        
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path p = file.getFileName();
        if (attrs.isRegularFile() && p != null) {
            Pattern pat = Pattern.compile(combineRegex(), Pattern.CASE_INSENSITIVE);
            Matcher m = pat.matcher(p.toString());
            System.out.println("Attempting to match: " + p);
            while (m.find()) {
                System.out.println("movie matched: "+m.group(1));
                this.movies.addMovie(file, m.group(1), m.group(2));
            }
        }
        
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc);
        return FileVisitResult.SKIP_SUBTREE;
    }
    
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
    
    private String formatExt() {
        String s = Arrays.toString(extensions);
        s = s.replace(',', '|');
        s = s.substring(1, s.length() - 1);
        return s;
    }
    
    private String combineRegex() {
        return regex1 + formatExt() + regex2;
    }
    
    public static void main(String... args) {
        Pattern p = Pattern.compile("(.*)\\.(agi|m4v|gif|GIF|doc|DOC|pdf|PDF)$",
                Pattern.CASE_INSENSITIVE);
        
        //TODO: this file matches fine here, but when running on the filesystem,
        // it no longer recogizes it. 
        String fileName = "christmas_show.m4v";
        Matcher m = p.matcher(fileName);
        
        while (m.find()) {
            //1 is name, 2 is extension
            System.out.println("Match is: " + m.group(1));
        }
        
        String[] exts = {"avi", "mp3", "rgb"};
        
        String s = Arrays.toString(exts);
        s = s.replace(',', '|');
        s = s.substring(1, s.length() - 1);
        System.out.println(s);
        
    }
}

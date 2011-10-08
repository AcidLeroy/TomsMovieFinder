package controller;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Model;
import model.Movie;
import model.Movies;

/**
 *
 * @author gq114c
 */
public class MovieSearcher implements FileVisitor<Path> {

    private Movies movies;
    private Model m;
    private static String regex1 = "(.*)\\.(";
    private static String regex2 = ")$";

    /**
     * After running the MoviePath searcher a movie searcher can be created
     */
    public MovieSearcher(Model m) {
	this.movies = m.getMovies();
	this.m = m;
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

	    while (m.find()) {
		System.out.println("Movie matched: " + m.group(1));
		this.movies.addMovie(file.toFile(), m.group(1), m.group(2));

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
	//String s = Arrays.toString(m.getSearchFormats());
	String s = Arrays.toString(m.getSearchFormats().toArray());

	s = s.replace(',', '|');
	s = s.substring(1, s.length() - 1);
	s = s.replaceAll("\\s", ""); //remove white space
	return s;
    }

    private String combineRegex() {
	return regex1 + formatExt() + regex2;
    }
}

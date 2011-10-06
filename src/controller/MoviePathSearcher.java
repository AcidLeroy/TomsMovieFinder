package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.BasicFileAttributes;
import model.Model;

/**
 *
 * @author gq114c
 */
public class MoviePathSearcher implements FileVisitor<Path> {

    private final PathMatcher[] matcher;
    private Path[] pathsToMovies;
    private int pathIndex;
    private Model m;

    public MoviePathSearcher(Model m) {
	this.m = m;
	pathsToMovies = new Path[100];
	matcher = new PathMatcher[100];
	pathIndex = 0;
	int i = 0;
	for (String s : m.getSearchKeywords()) {
	    matcher[i++] = FileSystems.getDefault().getPathMatcher("glob:" + s);
	}
    }

    public Path[] getPathsToMovies() {
	return pathsToMovies;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
	
	//Check to make sure that directory is not excluded 
	if(attrs.isDirectory()){
	    for(File pth : m.getFilesToExclude()){
		if(pth.equals(dir)){
		    return FileVisitResult.SKIP_SUBTREE;
		}
	    }
	}
	
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
}

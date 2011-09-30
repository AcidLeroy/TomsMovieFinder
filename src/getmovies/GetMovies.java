/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getmovies;

import java.io.File;

/**
 *
 * @author gq114c
 */
public class GetMovies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for (File r : roots) {
            System.out.println("This is a root: " + r);
            String[] ss = r.list();
            if (ss != null) {
                System.out.println();
                for (String s : ss) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }
    }
}

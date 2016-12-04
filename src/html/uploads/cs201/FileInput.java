package classexamples;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileInput {
    
    
    public static void main(String[] args) throws Exception {
        /*
         * Pseudocode:
         * 
         * Open file for reading
         * Read line 1 as title
         * Read line 2 as headings
         * 
         * for all remaining lines
         *      split by tab character
         *      assign individual values to new Film object
         *      add Film object to an array
         * 
         * Print out title
         * for each Film in array
         *      print to console
         * 
         * Open new file for writing
         * write title to file
         * write statistics to file
         * for each Film in array
         *      write summary to file
         */
        
        FileInputStream infile = new FileInputStream("films.txt");
        Scanner reader = new Scanner(infile);
        
        String title = reader.nextLine();
        String header = reader.nextLine();
        
        ArrayList<String> lines = new ArrayList<String>(50);
        ArrayList<Film> films = new ArrayList<Film>();
        
        while(reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
        
        reader.close();
        
        for(String line : lines) {
            String[] aryLine = line.split("\t");
            
            Film film = new Film();
            film.order = Short.parseShort(aryLine[0].trim());
            film.title = aryLine[1];
            film.worldwideGross = aryLine[2];
            film.year = Short.parseShort(aryLine[3].trim());
            
            films.add(film);
        }
        
        System.out.println(title);
        
        for(Film film : films) {
            System.out.println(film);
        }
        
        
        FileWriter outfile = new FileWriter("filmstats.txt", true);
        PrintWriter writer = new PrintWriter(outfile);
        
        writer.println(title);
        writer.println(Film.getStatistics(films));
        
        for(Film film : films) {
            writer.println(film.getSummary());
        }
        
        writer.close();
    }
    
    private static class Film {
        public short order;
        public String title;
        public String worldwideGross;
        public short year;
        
        /**
         * Displays a multi-line summary of the film, similar to toString()
         * @return A string representation of the Film object
         */
        public String getSummary() {
            String ret = title + "\n";
            ret += "\tYear Released: " + year + "\n";
            ret += "\tGross: " + worldwideGross + "\n";
            
            return ret;
        }
        
        /**
         * Returns the current Film's member variables as a String.
         * @return A string representation of the Film object
         */
        public String toString() {
            return String.format("%s released in %d which earned %s", title, year, worldwideGross);
        }
        
        /**
         * Determine basic statistics for all films in the provided list.
         * @param films A list of films
         * @return A formatted string containing the calculated statistics
         */
        public static String getStatistics(List<Film> films) {
            Film min = films.get(0); //The lowest grossing film in the list
            Film max = films.get(0); //The highest grossing film in the list
            Film newest = films.get(0); //The most recent film
            Film oldest = films.get(0); //The oldest film
            
            for(Film film : films) {
                if(film.order > min.order) {
                    min = film;
                }
                
                if(film.order < max.order) {
                    max = film;
                }
                
                if(film.year > newest.year) {
                    newest = film;
                }
                
                if(film.year < oldest.year) {
                    oldest = film;
                }
            }
            
            String ret = "Lowest Grossing: " + min + "\n";
            ret += "Highest Grossing: " + max + "\n";
            ret += "Most Recent: " + newest + "\n";
            ret += "Least Recent: " + oldest + "\n";
            return ret;
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rnixon
 */
public class Exceptions {
    
public static void main(String args) throws Exception {
        String location = "fils.txt";
        
        List<String> lines;
        try {
            lines = parseFile(location);
        }
        catch(FileNotFoundException ex) {
            throw new Exception("File was not found:" + location);
        }

        System.out.println("Here are all of the films found at " + location + ":");
        for(String line : lines) {
            System.out.println(line);
        }
    }
    
    public static List<String> parseFile(String filename) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>(50);
        Scanner reader = null;
        
        try {
            FileInputStream infile = new FileInputStream(filename);
            
            reader = new Scanner(infile);

            String title = reader.nextLine();
            String header = reader.nextLine();

            while(reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        }
        finally {
            if(reader != null) reader.close();
        }
        
        return lines;
    }
}

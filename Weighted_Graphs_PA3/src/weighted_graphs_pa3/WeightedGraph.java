/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weighted_graphs_pa3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author timbo
 */
public class WeightedGraph {
    
    String[] elements = new String[30];
    String[] vertices = new String[30];
    Charset charset = Charset.forName("US-ASCII");
    Path inputFile = FileSystems.getDefault().getPath("input", "matrix.csv");
    
    
    public WeightedGraph(){
        
    }
    
    public MST Prim(){
        
        return null;
    }
    
    public MST Kruskal(){
        
        return null;
    }
    
    int index = 0;
    
    public void readCSV(){
        try (BufferedReader reader = Files.newBufferedReader(inputFile, charset)) {
            String line = null;
            while((line = reader.readLine()) != null){
                String[] matrixValue = line.split(",");
                elements[index] = matrixValue[0];
                vertices[index] = matrixValue[1];
                index++;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
    
}

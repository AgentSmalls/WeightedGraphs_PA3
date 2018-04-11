/*
 * Authors: Timothy Small and James Jacobs
 * Date: 4/10/18
 * Overview: sets up the weighted graphs and adjacency matrices from the csv file
 */
package weighted_graphs_pa3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


public class Driver {
    
    public static void main(String[] args) {
        
        Charset charset = Charset.forName("US-ASCII");
        Path inputFile = FileSystems.getDefault().getPath("input","matrix.csv");
        
        AdjacencyMatrix directed = null; // Used for Prims and Kruskals
        AdjacencyMatrix undirected = null; // Used for Floyd Warshall
        
        try (BufferedReader reader = Files.newBufferedReader(inputFile, charset)) {
            directed = getMatrix(reader);
            undirected = getMatrix(reader);
            
            
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        
//        printMatrix(directed);
//        printMatrix(undirected);
        
        WeightedGraph graph = new WeightedGraph(directed);
        WeightedGraph fWarshall = new WeightedGraph(undirected);
        
        System.out.println("Directed weighted Graph");
        
        directed.printMatrix();
        MST k = new MST(graph);
        
        // Kruskal's algorithm stuff.
        k.kruskal(graph);
        System.out.print("Kruskal's algorithm tree: ");
        k.printTree();
        System.out.println();
        
        
        // Do Floyd Warshall on undirected graph!
        undirected.FloydWarshall();

    }
    
    /* This method creates an adjacency matrix by reading in a .csv file and 
        returns it to the caller */
    public static AdjacencyMatrix getMatrix(BufferedReader reader){
        int[][] matrix = null;
        char[] header = null;
        int index = 0;       
        
        try{
            String line = null;  // Reads in from file
            String[] headerChars = null;   // Used to hold strings that contain capitial characters
            line = reader.readLine();   // This reads in the character string
            headerChars = line.split(",");
            
            // Determine the dimensions of the matrix. Since there are commas inbetween each
            // entry, and because each entry is one character long, the algorithm for dimensions
            // is number of (entries and commas + 1) / 2
            int dim = (line.length()+1)/2;
            matrix = new int[dim][dim];
            header = new char[dim];

            while(index < dim){
                // Convert headerChars into header 
                header[index] = headerChars[index].charAt(0);
                
                // The following code reads in the values of the matrix and puts them into
                // the int[][] array.
                line = reader.readLine();
                String[] matrixValues = line.split(",");
                for(int i = 0; i < dim; i++){
                    matrix[index][i] = Integer.parseInt(matrixValues[i]);
                }
                index++;
            } 
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        
        return new AdjacencyMatrix(header, matrix);
    }
    
}

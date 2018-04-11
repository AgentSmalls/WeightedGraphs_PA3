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

/**
 *
 * @author timbo
 */
public class Driver {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*int[] weights = new int[30];
        Integer[] values = new Integer[30];
        String[] vertices = new String[30];*/
        
        Charset charset = Charset.forName("US-ASCII");
        Path inputFile = FileSystems.getDefault().getPath("input","matrix.csv");
        
        AdjacencyMatrix directed = null;
        AdjacencyMatrix undirected = null;
        
        //temporarily reading things into seperate arrays for testing
        //probably can do with one 2d array?
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

        k.kruskal(graph);
        System.out.print("Kruskal's algorithm tree: ");
        k.printTree();
        
        
        // Do Floyd Warshall on undirected graph!
        undirected.FloydWarshall();
        
    //    Heap h = graph.depthSearch();
        
        //h.printEdges();
        
        
        /*/  Test that heapEdges are working
        Vertex v = new Vertex();
        Vertex w = new Vertex();
        Edge e = new Edge(14, v, w);
        Heap h = new Heap(e);
        h.insertEdge(new Edge(11, v, w));
        h.insertEdge(new Edge(12, v, w));
        h.insertEdge(new Edge(8, v, w));
        h.insertEdge(new Edge(13, v, w));
        h.printEdges();
        h.removeEdge();
        h.insertEdge(new Edge(6, v, w));
        h.insertEdge(new Edge(12, v, w));
        h.printEdges();
        h.removeEdge();
        h.removeEdge();
        h.removeEdge();
        h.printEdges();
        h.removeEdge();
        h.printEdges();
        //*/
        
        /*  Test that Vertex numbering is working
        Vertex v = new Vertex();
        Vertex w = new Vertex();
        Vertex x = new Vertex();
        Vertex y = new Vertex();
        System.out.println(v.getName());
        System.out.println(w.getName());
        System.out.println(x.getName());
        System.out.println(y.getName());
        */        
    }
    
    public static AdjacencyMatrix getMatrix(BufferedReader reader){
        int[][] matrix = null;
        char[] header = null;
        int index = 0;       
        
        try{
            String line = null;
            String[] headerChars = null;
            line = reader.readLine();
            headerChars = line.split(",");
            
            int dim = (line.length()+1)/2;
            matrix = new int[dim][dim];
            header = new char[dim];

            while(index < dim){
                // Convert headerChars into header 
                header[index] = headerChars[index].charAt(0);
                
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
/*    
    public static void printMatrix(int[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
*/    
}

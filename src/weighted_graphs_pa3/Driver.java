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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*int[] weights = new int[30];
        Integer[] values = new Integer[30];
        String[] vertices = new String[30];*/
        
        int[][] matrix = null;
        
        Charset charset = Charset.forName("US-ASCII");
        Path inputFile = FileSystems.getDefault().getPath("input","matrix.csv");
        
        int index = 0;
        
        
        
        //temporarily reading things into seperate arrays for testing
        //probably can do with one 2d array?
        try (BufferedReader reader = Files.newBufferedReader(inputFile, charset)) {
            String line = null;
            line = reader.readLine();
            int dim = (line.length()+1)/2;
            matrix = new int[dim][dim];
            //System.out.println(dim);
            while(index < dim){
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
        
        printMatrix(matrix);
        
        
        /*  Test that heapEdges are working
        Vertex v = new Vertex();
        Edge e = new Edge(14, v);
        Heap h = new Heap(e);
        h.insertEdge(new Edge(11, v));
        h.insertEdge(new Edge(12, v));
        h.insertEdge(new Edge(8, v));
        h.insertEdge(new Edge(13, v));
        h.printEdges();
        h.removeEdge();
        h.insertEdge(new Edge(6, v));
        h.insertEdge(new Edge(12, v));
        h.printEdges();
        h.removeEdge();
        h.printEdges();
        */
        
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
    
    public static void printMatrix(int[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}

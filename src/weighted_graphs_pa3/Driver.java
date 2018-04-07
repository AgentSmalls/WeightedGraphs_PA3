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
        
        String[] weights = new String[30];
        String[] vertices = new String[30];
        
        Charset charset = Charset.forName("US-ASCII");
        Path inputFile = FileSystems.getDefault().getPath("input","matrix.csv");
        
        int index = 0;
        
        
        //temporarily reading things into seperate arrays for testing
        //probably can do with one 2d array?
        try (BufferedReader reader = Files.newBufferedReader(inputFile, charset)) {
            String line = null;
            while((line = reader.readLine()) != null){
                String[] matrixValues = line.split(",");
                vertices[index] = matrixValues[0];
                weights[index] = matrixValues[1];
                index++;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weighted_graphs_pa3;
import java.util.*;


/**
 *
 * @author timbo
 */
public class Vertex {
    private static final int A_IN_ASCII = 65; // Used for numbering vertices
    private static int numVertices; // Also used for numbering vertices
    private char name; // Starts with 'A' and continues through ascii table
    public ArrayList<Edge> edges = new ArrayList(); // Keeps track of all edges coming out of vertex
    
    public Vertex(){
        name = (char) (numVertices + A_IN_ASCII);
        numVertices++;
    }
    
    public char getName(){
        return name;
    }
    
    public void addEdge(Edge e){
        
    }
}

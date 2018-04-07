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
    public boolean visited = false;
    
    public Vertex(){
        name = (char) (numVertices + A_IN_ASCII);
        numVertices++;
    }
/*    
    public Edge[] getEdges(){
        Edge array[] = new Edge[5];
        array = edges.toArray(array);
        
        edges.trimToSize();
        
        int length = 0;
      //  while(edges[length] != null){
            
            
      //  }
        
    }
*/    
    public char getName(){
        return name;
    }
    
    public void addEdge(Edge e){
        
    }
}

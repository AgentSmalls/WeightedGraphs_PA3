/*
 * Authors: Timothy Small and James Jacobs
 * Date: 4/10/18
 * Overview: Establishes vertices as A,B,C etc and establishes vertex clusters
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
    
    // Clusters. These are used for finding a minimum spanning tree using Kruskal's algorithm
    private char[] cluster;
    private int numElemsInCluster;
    
    public Vertex(){
        name = (char) (numVertices + A_IN_ASCII);
        numVertices++;
    }
  
    public char getName(){
        return name;
    }
    
    public void addEdge(Edge e){
        edges.add(e);
    }

    /* Initializes the clusters. The first element of each cluster is the name
       of a vertex, i.e. A, B, C, ...
    */
    public void initializeCluster(int numElementsInCluster){
        cluster = new char[numElementsInCluster];           
        cluster[0] = name;
        numElemsInCluster++;
    }
    
    public char[] getCluster(){
        return cluster;
    }
    
    /* This method updates which vertices are in which cluster */
    public void updateClusters(Vertex v, Vertex w, Vertex[] all){
        // Vertices in a cluster always associate with the name of the vertex (which 
        // is also in the cluster) lowest in the alphabet. The vertex with the name
        // lowest in the alphabet is always the first one listed in a cluster.
        if(v.cluster[0] < w.cluster[0]){
            int i = 0;
            // Make sure all the elements of both clusters are grouped into the same cluster.
            while(w.numElemsInCluster > 0){
                v.cluster[v.numElemsInCluster] = w.cluster[i];
            //    w.cluster[i] = 0;
                v.numElemsInCluster++;
                w.numElemsInCluster--;
                i++;
            }
            // Make the two clusters equal to each other so that they reference
            // The same thing.
            char deleted = w.cluster[0];
            w.cluster = v.cluster;
            w.numElemsInCluster = v.numElemsInCluster;
            // Make sure all other vertices with either first character of the two
            // vertices in their clusters are also updated.
            for(i = 0; i < all.length; i++){
                if(v.cluster[0] == all[i].cluster[0]){
                    all[i].cluster = v.cluster;
                    all[i].numElemsInCluster = v.numElemsInCluster;
                }
                if(deleted == all[i].cluster[0]){
                    all[i].cluster = v.cluster;
                    all[i].numElemsInCluster = v.numElemsInCluster;
                }
            }
        }else if(v.cluster[0] > w.cluster[0]){
            int i = 0;
            // Make sure all the elements of both clusters are grouped into the same cluster.
            while(v.numElemsInCluster > 0){
                w.cluster[w.numElemsInCluster] = v.cluster[i];
            //    v.cluster[i] = 0;
                w.numElemsInCluster++;
                v.numElemsInCluster--;
                i++;
            }
            // Make the two clusters equal to each other so that they reference
            // The same thing.
            char deleted = w.cluster[0];
            v.cluster = w.cluster;
            v.numElemsInCluster = w.numElemsInCluster;
            
            // Make sure all other vertices with the same first character in their vertices are also updated
            for(i = 0; i < all.length; i++){
                if(w.cluster[0] == all[i].cluster[0]){
                    all[i].cluster = w.cluster;
                    all[i].numElemsInCluster = w.numElemsInCluster;
                }
                if(deleted == all[i].cluster[0]){
                    all[i].cluster = w.cluster;
                    all[i].numElemsInCluster = w.numElemsInCluster;
                }
            }
        } // End of if else
    } // End of update clusters
    
}

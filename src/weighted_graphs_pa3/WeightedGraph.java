 
package weighted_graphs_pa3;
import java.util.*;


public class WeightedGraph {
    private Vertex[] vertices;
    private Edge[] edges;
    AdjacencyMatrix adjacencyMatrix;
    
    public WeightedGraph(AdjacencyMatrix m){
        adjacencyMatrix = m;
        // matrix must be a square!!!
        vertices = new Vertex[m.matrix.length];
        // Max edges is (v^2)-v where v is number of vertices.
        edges = new Edge[(m.matrix.length * m.matrix.length) - m.matrix.length];
        
        // Create a new vertex for each row of the matrix
        for(int i = 0; i < vertices.length; i++){
            vertices[i] = new Vertex();
        }
        
        // Go through the entire matrix and insert edges where needed with the specified
        // weight. An edge is created if the weight is greater than 0.
        int edgeCounter = 0;
        for(int i = 0; i < m.matrix.length; i++){
            for(int j = 0; j < m.matrix.length; j++){
                if(m.matrix[i][j] > 0){
                    // A new edge takes in the vertex it is pointing to first, and then
                    // the vertex that is being pointed from.
                    Edge e = new Edge(m.matrix[i][j], vertices[j], vertices[i]);
                    edges[edgeCounter] = new Edge(m.matrix[i][j], vertices[j], vertices[i]);
                    vertices[i].addEdge(edges[edgeCounter]);
                    edgeCounter++;
                }// end if
            } // end for
        } // end for
    }
    
    /* This method completes a depth search of the weighted graph. While going through
       the graph, each edge is compiled into a heap in order of smallest weight.
    */
    public Heap depthSearch(){
        Vertex first = vertices[0]; // Start at first vertex
        Edge[] vertexEdges = new Edge[5]; // This array holds the edges going out of a vertex.
        Stack<Vertex> s = new Stack(); // Vertices go onto the stack in order to progress through the graph
        s.add(first);
        first.visited = true;
        vertexEdges = first.edges.toArray(vertexEdges); // edges in Vertex class is an ArrayList, so convert from ArrayList to Edge array
        Heap edges = new Heap(vertexEdges[0]); // Initialize the heap
        edges = insertEdges(edges, vertexEdges, 1); // Add remaining edges out of the first vertex to the heap
        
        // Continue searching the graph until the stack is empty.
        while(!s.isEmpty()){
            // Search for a vertex that has not been visited. 
            Vertex next = searchForVertex(vertexEdges);
            // If next has not been visited...
            if(next != null){
                s.add(next);
                next.visited = true;
                vertexEdges = next.edges.toArray(vertexEdges);
                
                edges = insertEdges(edges, vertexEdges, 0);
            // If next has been visited    
            }else{
                Vertex top = s.pop();
            //    vertexEdges = null;
                vertexEdges = top.edges.toArray(vertexEdges);
            }
        }
        
        // Put visited on each vertex back to false!
        for(int i = 0; i < vertices.length; i++){
            vertices[i].visited = false;
        }
        return edges;
    }
    
    /* This method looks at the edges going out of a vertex and determines if any of
       the vertices they connnect to have been visited or not. If a vertex has not
       been visited, it is returned. If all vertices have been visited, returns null
    */
    private Vertex searchForVertex(Edge[] e){
        
        int i = 0;
        Vertex v = null;  // To be returned null if an unvisited vertex not found
        if(e[0] != null){
            while(e[i] != null){
                if(e[i].getTo().visited == false){
                    v = e[i].getTo();
                    break;
                }
                i++;
            }
        }
            return v;
        
    }
    
    /* Inserts edges from an edge array to a heap of edges */
    private Heap insertEdges(Heap h, Edge[] e, int i){
        while(e[i] != null){
            h.insertEdge(e[i]);
            i++;
        }
        return h;
    }
    
    public Vertex[] getVertices(){
        return vertices;
    }
    
    public Edge[] getEdges(){
        return edges;
    }
    
}

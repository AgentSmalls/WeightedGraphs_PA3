
package weighted_graphs_pa3;


public class MST {
    private Vertex[] vertices;
    private Edge[] edges;
    
    // The number of edges is always one less than number of vertices.
    public MST(WeightedGraph graph){
        vertices = graph.getVertices();
        edges = new Edge[vertices.length - 1];
    }
        
    public MST prim(){
        
        return null;
    }
    
    public MST kruskal(WeightedGraph graph){
//        MST copy = new MST(graph);
        Heap candidates = graph.depthSearch();
        
        // Initialize each cluster while maximizing memory by making clusters the minimum
        // size that they need to be.
        for(int i = vertices.length; i > 0; i--){
            vertices[vertices.length - i].initializeCluster(i);
        }
             
        int edgeCounter = 0;
        while(!candidates.isEmpty()){
            Edge e = candidates.removeEdge();
            Vertex[] endPoints = e.getVertices();
            // Check if endpoints are in the same cluster by checking if their clusters
            // share the same first element. If they are not in the same cluster, add
            // edge e to array edges and update the clusters.
            if(endPoints[0].getCluster()[0] != endPoints[1].getCluster()[0]){
                edges[edgeCounter] = e;
                edgeCounter++;
                // Determine which cluster to update. A vertex is
                endPoints[0].updateClusters(endPoints[0], endPoints[1], vertices);
            }
        }
        
        return this;
    }
    
    /* Prints the edges in a tree on one line... */
    public void printTree(){
        for(int i = 0; i < edges.length; i++){
            if(edges[i] != null){
                edges[i].print();
            }
        }
        System.out.println();
    }
    
    
    
}

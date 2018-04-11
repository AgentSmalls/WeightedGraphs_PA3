//<<<<<<< HEAD

//=======
/*
 * Authors: Timothy Small and James Jacobs
 * Date: 4/10/18
 * Overview: creates the Minimum Spanning Trees from prim and kruskal algorithms
 */
//>>>>>>> ff37456a4aaa3611e419c58788fc4311d666f09e
package weighted_graphs_pa3;


public class MST {
    private Vertex[] vertices;
    private Edge[] edges;
    
    // The number of edges is always one less than number of vertices.
    public MST(WeightedGraph graph){
        vertices = graph.getVertices();
        edges = new Edge[vertices.length - 1];
    }
        
    
    public MST Prim(WeightedGraph graph, int s){
        MST m = new MST(graph);
        Heap q = graph.depthSearch();
        
        Edge[] v = graph.getEdges();
        Edge[] p;
        
        //for each member of q set the priority to "infinity"
        for(Edge i : v){
            //set the priority to "infinity"
            //v[i] = ; //?????
        }
        //set the starting vertex 's' priority to 0
        //v[s] = null;
        //parent of s should be null
        
        
        while(!q.isEmpty()){
            //get miniumum for q as u
            //Vertex u = ;
            //for each adjacent vertex v to u
                //if v is in q and weight of (u,v) < priority of v then
                //the parent of v is set to be u
                //the priority of v is the weight of (u,v)
        }
        
        return m;
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

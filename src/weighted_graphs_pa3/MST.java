/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weighted_graphs_pa3;

/**
 *
 * @author timbo
 */
public class MST {
    private Vertex[] vertices;
    private Edge[] edges;
    
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
            v[i] = ; //?????
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
    
    public MST Kruskal(WeightedGraph graph){
        MST copy = new MST(graph);
        Heap candidates = graph.depthSearch();
//        candidates.printEdges();
//        int i = 0;
        while(!candidates.isEmpty()){
            candidates.printEdges();
            Edge e = candidates.removeEdge();
//            i++;
//            System.out.println(i);
        }
        
        return copy;
    }
}

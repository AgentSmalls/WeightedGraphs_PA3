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
    
    
    
    public MST Prim(){
        
        return null;
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

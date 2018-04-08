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
public class Edge {
    public int weight;
    private Vertex to;
    private Vertex from;
    
    public Edge(int w, Vertex v, Vertex vv){
        weight = w;
        to = v;
        from = vv;
    }
    
    public Vertex getTo(){
        return to;
    }
    
    public Vertex[] getVertices(){
        Vertex[] v = new Vertex[] {to, from};
        return v;
    }
}

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
    private Vertex v;
    
    public Edge(int w, Vertex v){
        weight = w;
        this.v = v;
    }
    
    public Vertex getVertex(){
        return v;
    }
}

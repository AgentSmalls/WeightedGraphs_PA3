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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vertex v = new Vertex();
        Vertex w = new Vertex();
        Vertex x = new Vertex();
        Vertex y = new Vertex();
        System.out.println(v.getName());
        System.out.println(w.getName());
        System.out.println(x.getName());
        System.out.println(y.getName());
        
        WeightedGraph wg = new WeightedGraph();
        
        wg.readCSV();
                
    }
    
}

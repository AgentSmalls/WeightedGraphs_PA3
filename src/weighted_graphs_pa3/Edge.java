/*
 * Authors: Timothy Small and James Jacobs
 * Date: 4/10/18
 * Overview: defines the connection between vertices and that connections weight
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
    
    public void print(){
        if(to.getName() <= from.getName()){
            System.out.print(to.getName());
            System.out.print(from.getName() + " ");
        }else{
            System.out.print(from.getName());
            System.out.print(to.getName() + " ");
        }
    }
}

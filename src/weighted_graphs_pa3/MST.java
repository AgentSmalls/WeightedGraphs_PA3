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
    
    public static final int NUMVERTS = 7;
    
    /*public int findMinimum(int vert[], Boolean mst[]){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for(int i = 0; i < NUMVERTS; i++){
            if(mst[i] == false && vert[i] < min){
                min = vert[i];
                minIndex = i;
            }
        }
        return minIndex;
    }*/
    // Translating the pseudocode into java. Everything here well be very temporary as things unravel
    public MST Prim(int matrix[][]){
        
        /*int p[] = new int[NUMVERTS];  //probably needs to be vertex array but int for testing purposes
        int vert[] = new int[NUMVERTS];
        Boolean mst[] = new Boolean[NUMVERTS];
        
        for(int i = 0; i < NUMVERTS; i++){
            vert[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }
        
        vert[0] = 0;
        p[0] = -1;
        
        for(int i = 0; i < NUMVERTS-1; i++){
            int u = findMinimum(vert, mst);
            
            mst[u] = true;
            
            for(int j = 0; j < NUMVERTS; j++){
                if(matrix[u][j] != 0 && mst[j] == false && matrix[u][j] < vert[j]){
                    p[j] = u;
                    vert[j] = matrix[u][j];
                }
            }
        }
        printP(p, NUMVERTS, matrix);*/
        
        return null;
    }
    /*public void printP(int p[], int n, int matrix[][]){
        for(int i = 0; i < NUMVERTS; i++){
            for(int j = 0; j < NUMVERTS; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }*/
}

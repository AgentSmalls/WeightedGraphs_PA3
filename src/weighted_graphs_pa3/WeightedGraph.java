/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weighted_graphs_pa3;
import java.util.*;
/**
 *
 * @author timbo
 */
public class WeightedGraph {
    private Vertex[] vertices;
    private Edge[] edges;
    int[][] adjacencyMatrix;
    
    public WeightedGraph(int[][] matrix){
        adjacencyMatrix = matrix;
        // matrix must be a square!!!
        vertices = new Vertex[matrix.length];
        // Max edges is (v^2)-v where v is number of vertices.
        edges = new Edge[(matrix.length * matrix.length) - matrix.length];
        
        for(int i = 0; i < vertices.length; i++){
            vertices[i] = new Vertex();
        }
        int edgeCounter = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] > 0){
                    // A new edge takes in the vertex it is pointing to first, and then
                    // the vertex that is being pointed from.
                    Edge e = new Edge(matrix[i][j], vertices[j], vertices[i]);
                    edges[edgeCounter] = new Edge(matrix[i][j], vertices[j], vertices[i]);
                    vertices[i].addEdge(edges[edgeCounter]);
                    edgeCounter++;
                }
            }
        }
    }
    
    public Heap depthSearch(){
        Vertex first = vertices[0];
        Edge[] vertexEdges = new Edge[5];
        Stack<Vertex> s = new Stack();
        s.add(first);
        first.visited = true;
        vertexEdges = first.edges.toArray(vertexEdges);
        Heap edges = new Heap(vertexEdges[0]);
        edges = insertEdges(edges, vertexEdges, 1);
        

        while(!s.isEmpty()){
            Vertex next = searchForVertex(vertexEdges);
            if(next != null){
                s.add(next);
                next.visited = true;
                // Null out vertexEdges for reuse
                //vertexEdges = null;
                // ArrayList.toArray(T[] a) cannot accept an empty array. So insert
                // something random into vertexEdges.
                //vertexEdges[0] = new Edge(1, first);
                vertexEdges = next.edges.toArray(vertexEdges);
                
                edges = insertEdges(edges, vertexEdges, 0);
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
    
    private Vertex searchForVertex(Edge[] e){
        
        int i = 0;
        boolean found = false;
        Vertex v = null;
        if(e[0] != null){
            while(e[i] != null){
                if(e[i].getTo().visited == false){
                    v = e[i].getTo();
                    found = true;
                    break;
                }
                i++;
            }
        }
        if(found){
            return v;
        }else{
            return null;
        }
        
    }
    
    private Heap insertEdges(Heap h, Edge[] e, int i){
        while(e[i] != null){
            h.insertEdge(e[i]);
            i++;
        }
        return h;
    }
<<<<<<< HEAD
    
    // moved over to MST class
    public MST Prim(){
        
        return null;
    }
    
    public MST Kruskal(){
        
        return null;
    }
=======

>>>>>>> 3f862a09c8fa06de717348930829a9aaa7eb7f27
    
    public int[][] FloydWarshall(int[][] matrix, char[] header){
        
        return null;
    }
    
    public void printMatrix(){
        for(int i = 0; i < adjacencyMatrix.length; i++){
            for(int j = 0; j < adjacencyMatrix.length; j++){
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public Vertex[] getVertices(){
        return vertices;
    }
    
    public Edge[] getEdges(){
        return edges;
    }
    
}

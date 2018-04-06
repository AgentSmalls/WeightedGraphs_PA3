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
public class Vertex {
    private static final int A_IN_ASCII = 65;
    private static int numVertices;
    private char name;
    
    public Vertex(){
        name = (char) (numVertices + A_IN_ASCII);
        numVertices++;
    }
    
    public char getName(){
        return name;
    }
}

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
public class AdjacencyMatrix {
    public int[][] matrix;
    public char[] header;
    
    
    public AdjacencyMatrix(char[] h, int [][] m){
        matrix = m;
        header = h;
    }
    
    public void printMatrix(){
        for(int i = 0; i < matrix.length; i++){
            System.out.print(header[i] + "  ");
        }
        System.out.println();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void FloydWarshall(){
        // Convert all -1's in matrix to infinity
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        printMatrix();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                for(int k = 0; k < matrix.length; k++){
                    if(matrix[i][j] > matrix[i][k] + matrix[k][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        printMatrix();
                    }
                }
            }
        }
        //return this;
    }
}

//<<<<<<< HEAD

//=======
/*
 * Authors: Timothy Small and James Jacobs
 * Date: 4/10/18
 * Overview: creates the adjacency matrix, prints the matrix and gets the length of the shortest path
    between all pairs of vertices
 */
//>>>>>>> ff37456a4aaa3611e419c58788fc4311d666f09e
package weighted_graphs_pa3;


public class AdjacencyMatrix {
    public int[][] matrix;
    public char[] header;
    
    
    public AdjacencyMatrix(char[] h, int [][] m){
        matrix = m;
        header = h;
    }
    
    /* This method prints an adjacency matrix by first prinitng its header and then
        printing the matrix.
    */ 
    public void printMatrix(){
        // Print header
        for(int i = 0; i < matrix.length; i++){
            System.out.print(header[i] + "  ");
        }
        System.out.println();
        // Print matrix. In Floyd Warshall, infinity values are represented by 
        // max value / 2. Therefore, print -1 for "no route" if a cell's value is
        // max value / 2.
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == Integer.MAX_VALUE / 2){
                    System.out.print("-1 ");
                }else{
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /* Floyd Warshall algorith finds the shortest path from each vertex to every
       other vertex and records that distance.
    */
    public void FloydWarshall(){
        // Convert all -1's in matrix to infinity / 2
        // If we convert the -1's to infinity, then the ints may overflow and
        // cause some problems. That is why we use max / 2.
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        // Print matrix before starting as a record of beginning point.
        printMatrix();
        // Iterate through the matrix checking for the shortest paths. If a shorter 
        // path is discovered, 
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
    }
}

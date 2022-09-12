/* Rotate Matrix

Brute force- copy every row of matrix in coloumn a dummy matrix

Optimized- Transpose of matrix then reverse every row


*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //Transpose the matrix
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //reverse every row
        for(int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }
    
    public static void reverse(int[] row) {
        int i = 0;
        int j = row.length - 1;
        
        while(i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }
}
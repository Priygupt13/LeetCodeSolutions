https://leetcode.com/problems/rotate-image/description/

// TC :  O(N^2 + N^2) = O(N^2)
// SC : O(1)
class Solution {
    public void rotate(int[][] matrix) {
       for(int i=0;i<matrix.length;++i){
           for(int j=i;j<matrix[i].length;++j){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
           }
       } 
       int n = matrix[0].length;
       for(int i=0;i<matrix.length;++i){
           for(int j=0;j<n/2;++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
           }
       }
    }
}

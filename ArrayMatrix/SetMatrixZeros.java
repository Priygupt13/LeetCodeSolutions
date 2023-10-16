TC : O(n*m)
SC : O(1)  

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false;
        boolean fc = false;
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                if(matrix[i][j]==0){
                    if(i==0) fr = true;
                    if(j==0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

     for(int i=1;i<matrix.length;++i){
         for(int j=1;j<matrix[i].length;++j){
             if(matrix[i][0]==0 || matrix[0][j]==0){
                 matrix[i][j] = 0;
             }
         }
     }
     int row = 0;
     if(fr){
        for(int col=0;col<matrix[row].length;++col){
            matrix[row][col] = 0;
        }
     }
     int col1 =0;
     if(fc){
         for(int row1=0;row1<matrix.length;++row1){
            matrix[row1][col1] = 0;
         }
     }

    }
}

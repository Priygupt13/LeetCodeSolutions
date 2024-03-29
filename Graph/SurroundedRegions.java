https://leetcode.com/problems/surrounded-regions/description/?envType=study-plan-v2&envId=top-interview-150
TC : O(n*m)
SC : O(n*m)  
class Solution {
    public void solve(char[][] board) {
       
       // Capture the unsurrounded region from top and bottom row
             for(int j=0;j<board[0].length;++j){
                if(board[0][j]=='O'){
                   dfs(0,j,board);
                }
               if(board[board.length-1][j]=='O'){
                       dfs(board.length-1,j,board);
                }
            }
       // Capture the unsurrounded region from left and right col
             for(int i=0;i<board.length;++i){
                if(board[i][0]=='O'){
                   dfs(i,0,board);
                }
               if(board[i][board[i].length-1]=='O'){
                       dfs(i,board[i].length-1,board);
                }
            }
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
         for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(board[i][j]=='#'){
                    board[i][j] = 'O';
                }
            }
        }
       

    }

    void dfs(int i,int j,char[][] board){
        if((i<0 || i>=board.length || j<0 || j>=board[i].length) || board[i][j]!='O'){
            return ;
        }
             board[i][j] = '#';
             dfs(i-1,j,board);
             dfs(i+1,j,board);
             dfs(i,j-1,board);
             dfs(i,j+1,board);
           
    }
}

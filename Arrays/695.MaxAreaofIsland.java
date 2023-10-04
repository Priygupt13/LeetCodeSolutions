TC : O(m*n)
SC : O(m*n)  
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[i].length;++j){
              int area = dfs(grid,i,j);
              maxArea = Math.max(area,maxArea);
            }
        }
        return maxArea;
    }
    int dfs(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return 0;
        if(grid[i][j]==1){
            grid[i][j] = 2;
            return 1+dfs(grid,i-1,j)+dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1);
        }
        return 0;
    }
}

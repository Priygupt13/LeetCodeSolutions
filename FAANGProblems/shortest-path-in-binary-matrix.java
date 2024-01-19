// TC : O(m*n)
// Sc : O(m*n)
// https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
          List<int[]> DIRECTIONS = Arrays.asList(new int[]{0,1},new int[]{1,0},new int[]{-1,0},new int[]{0,-1},new int[]{1,1},new int[]{-1,-1},new int[]{-1,1},new int[]{1,-1});
         int row = grid.length-1;
         int col = grid[0].length-1;
         if(grid[0][0]!=0 || grid[row][col]!=0) return -1;
         if(grid.length==1) return 1;
         Queue<int[]> queue = new LinkedList<>();
         queue.add(new int[]{0,0,1});
         int[][] visited = new int[row+1][col+1];
         visited[0][0] = 1;
         while(!queue.isEmpty()){
              int[] points = queue.poll();
              int x = points[0];
              int y = points[1];
              int len = points[2];
              if(x==row && y==col) return len;
              for(int[] dir : DIRECTIONS){
                  int x1 = x+dir[0];
                  int y1 = y+dir[1];
                  if(isValid(x1,y1,grid,visited))
                  {
                      queue.add(new int[]{x1,y1,len+1});
                      visited[x1][y1] = 1;
                  }
              }
         }
         return -1;
    }
    boolean isValid(int i,int j,int[][] grid,int[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==1 || visited[i][j]==1){
            return false;
        }
        return true;
    }
}

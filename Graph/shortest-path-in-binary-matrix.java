class Solution {
    private static final List<int[]> DIRECTIONS = Arrays.asList(new int[]{-1,0},new int[]{0,-1},new int[]{1,0},new int[]{0,1}
    ,new int[]{-1,-1},new int[]{1,1},new int[]{1,-1},new int[]{-1,1});
    public int shortestPathBinaryMatrix(int[][] grid) {
           int row = grid.length-1;
          int col = grid[0].length-1;
         if(grid[0][0]==1 || grid[row][col]==1) return -1;
         if(grid.length==1) return 1; 
         // queue is used to store the coordinates of cells where 0 present ->array of coordinates
         Queue<int[]> queue = new LinkedList<>();
         queue.add(new int[]{0,0,1}); // starting point is 0,0;
         boolean[][] visited = new boolean[row+1][col+1];
         visited[0][0] = true;
         while(!queue.isEmpty()){
             int[] point = queue.poll();
             int x = point[0];
             int y = point[1];
             int length = point[2];
             if(x==row && y==col) return length;
             for(int[] direction : DIRECTIONS) {
                 int x1 = direction[0]+x;
                 int y1 = direction[1]+y;
                 if(x1<0 || y1<0 || x1>=grid.length || y1>=grid[0].length || visited[x1][y1] || grid[x1][y1]==1){
                    continue;
                 }
                 queue.add(new int[]{x1,y1,length+1});
                 visited[x1][y1] = true; 
             }
         }
         return -1;
    }
}

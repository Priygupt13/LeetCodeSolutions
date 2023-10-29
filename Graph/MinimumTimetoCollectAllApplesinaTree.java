https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
TC : O(N+E)
SC : O(N+E)  
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;++i){
            map.put(i,new ArrayList<>());
        }
        for(int[] edge : edges){
           if(map.containsKey(edge[0])){
               map.get(edge[0]).add(edge[1]);
           }
           if(map.containsKey(edge[1])){
               map.get(edge[1]).add(edge[0]);
           }
        }

        int[] visited = new int[n];
        return dfs(0,map,visited,hasApple);

    }
 private boolean dfs(int node, HashMap<Integer,List<Integer>> adj,int[] visited,List<Boolean> hasApple){
        visited[node] = 1;
        List<Integer> children = adj.get(node);

        Boolean childApple = false;
        for(int i=0;i<children.size();++i){
            int child = children.get(i);
            if(visited[child] == 1) continue;
            if(dfs(child,adj,visited,hasApple)){ 
                time+= 2;
                childApple = true;
            }
        }
        return childApple || hasApple.get(node);
    }
}

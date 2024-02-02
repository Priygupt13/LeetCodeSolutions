/ SC :  O(N) due to the recursion stack, 
// TC : O(N)
class Solution {
    int max = 0;
    public int diameter(Node root) { // 1
       if(root==null) return 0;
       helper(root); // 1
       return max;
    }
    int helper(Node root){ // 1,3,5,6
        int firstMax = 0;
        int secMax = 0;
       List<Node> ListOfchildren = root.children;
       for(Node node: ListOfchildren){
           int length = helper(node); // 6
           if(firstMax < length){
               secMax = firstMax;
               firstMax = length;
           }else{
               if(length>secMax){
                   secMax = length;
               }
           }
       } 
       max = Math.max(max,firstMax+secMax); 
       return 1+Math.max(firstMax,secMax); // 0
    }
}

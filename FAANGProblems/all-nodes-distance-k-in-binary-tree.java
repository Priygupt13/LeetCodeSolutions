// TC : O(n)+O(n) = O(n)
 // Sc : O(n+k)
 // maximum distance k
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       List<Integer> result = new ArrayList<>(); 
       // edge case when k = 0;
       if(k==0){
           result.add(target.val);
           return result;
       }
       Map<TreeNode,TreeNode> childParentMap = new HashMap<>();
       childParentMap.put(root,null);
       findParents(root,childParentMap);
       HashSet<Integer> set = new HashSet<>();
       dfs(target,k,childParentMap,result,set);
       return result;
    }
    void findParents(TreeNode root,Map<TreeNode,TreeNode> childParentMap){
         if(root==null) return;
         if(root.left!=null)
           childParentMap.put(root.left,root);

         if(root.right!=null) 
           childParentMap.put(root.right,root);

          findParents(root.left,childParentMap);
          findParents(root.right,childParentMap);
    }
   void dfs(TreeNode target,int k,Map<TreeNode,TreeNode> childParentMap,List<Integer> result,HashSet<Integer> set){
       if(target==null || set.contains(target.val)){
           return;
       }
       if(k==0){
           
          result.add(target.val);
          return;
       }
       set.add(target.val);
       dfs(target.left,k-1,childParentMap,result,set);
       dfs(target.right,k-1,childParentMap,result,set);
       dfs(childParentMap.get(target),k-1,childParentMap,result,set);
    }
}

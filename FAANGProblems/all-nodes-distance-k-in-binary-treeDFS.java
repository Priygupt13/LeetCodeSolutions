https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
Time Complexity: O(n)
Space Complexity: O(n)

  class Solution {
     Map<Integer,TreeNode> childParentMap = new HashMap<>();
     Set<Integer> set = new HashSet<>();
      List<Integer> list = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       
        // edge case
        if(k==0){
            list.add(target.val);
            return list;
        }
        findParents(root);
        dfsToFindNodesAtk(target,k);
        return list;
    }
    void findParents(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            childParentMap.put(root.left.val,root);
            findParents(root.left);
        }
         if(root.right!=null){
            childParentMap.put(root.right.val,root);
            findParents(root.right);
        }
    }
    void dfsToFindNodesAtk(TreeNode target,int k){
        if(target==null || set.contains(target.val)) return;
        set.add(target.val);
        if(k==0){
            list.add(target.val);
            return;
        }
        dfsToFindNodesAtk(target.left,k-1);
        dfsToFindNodesAtk(target.right,k-1);
        dfsToFindNodesAtk(childParentMap.get(target.val),k-1);
    }
}

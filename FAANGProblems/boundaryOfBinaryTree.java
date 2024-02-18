
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Edge case when single node then it will be considered only one time in left boundary not in leave boundary
// TC : O(n)
// Sc : O(1)
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
       
        if(root.left==null && root.right==null) {
            list.add(root.val);
            return list;
        }
         list.add(root.val);
        if(root.left!=null){
            traverseLeftBoundary(root.left,list);
        }
        traverseLeaves(root,list);
        if(root.right!=null){
            traverseRightBoundary(root.right,list);
        }
        return list;
    }
    void traverseLeftBoundary(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        list.add(root.val);
        if(root.left==null)  traverseLeftBoundary(root.right,list); 
        else traverseLeftBoundary(root.left,list);
    }
    void traverseLeaves(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            list.add(root.val);
        }
        traverseLeaves(root.left,list);
        traverseLeaves(root.right,list);
    }

    void traverseRightBoundary(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
       
        if(root.right==null)  traverseRightBoundary(root.left,list); 
        else traverseRightBoundary(root.right,list);
        list.add(root.val);
    }
}

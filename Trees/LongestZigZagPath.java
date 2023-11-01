https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
TC : O(n)
SC : O(1)  
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
class Solution {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root.left==null && root.right==null) return 0;
        max = 0;
        helper(root.left,"R",0);
        helper(root.right,"L",0);
        return max;
    }
    void helper(TreeNode root,String direction,int steps){
        if(root==null) return;
        max = Math.max(max,steps+1);
        if(direction.equals("L")){
            if(root.left!=null){
                helper(root.left,"R",steps+1);
            }
            if(root.right!=null){
                helper(root.right,"L",0);
            }
        }
        else{
            if(root.right!=null){
                helper(root.right,"L",steps+1);
            }
            if(root.left!=null){
                helper(root.left,"R",0);
            }
        }
    }

}

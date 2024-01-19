https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/1150263252/
// Tc : O(n)
// SC : O(n)
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        flattentree(root);
    }
    TreeNode flattentree(TreeNode root){
        if(root==null) return null;
        TreeNode left = flattentree(root.left);
        TreeNode right = flattentree(root.right);
        root.left = null;
        root.right = left;
        TreeNode temp = root;
        while(temp.right!=null){
            temp = temp.right;
        }
        temp.right = right;
        return root;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
           TreeNode curr = stack.pop();
           if(curr.right!=null){
               stack.push(curr.right);
           }
           if(curr.left!=null){
               stack.push(curr.left);
           }
           if(!stack.isEmpty()){
               curr.right = stack.peek();
               curr.left = null;
           }
        }
    }
   
}


Problem Source : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
TC: O(n)
SC: O(n)  
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return ls;
        if(root.left==null && root.right==null) {
            list.add(root.val);
            ls.add(list);
            return ls;
        }
       queue.add(root);
       queue.add(null);
       list.add(root.val);
       ls.add(list);
       int level = 0;
       while(!queue.isEmpty() && queue.peek()!=null){
           TreeNode node = queue.peek();
           list = new ArrayList<>();
            level++;
           while(node!=null){
              System.out.print(node.val);
               if(node.left!=null){
                   queue.add(node.left);
                   list.add(node.left.val);
               }
               if(node.right!=null){
                   queue.add(node.right);
                    list.add(node.right.val);
               }
               queue.remove();
              node = queue.peek();

           }
           if(!list.isEmpty() && level%2!=0){
               Collections.reverse(list);
              
                ls.add(list);
           }else{
               if(!list.isEmpty())
                 ls.add(list);
           }
           
           queue.add(null);
           if(queue.peek()==null){
               queue.remove();
           }
       }
     return ls;
    }
}

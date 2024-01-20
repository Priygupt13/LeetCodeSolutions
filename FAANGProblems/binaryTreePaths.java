https://leetcode.com/problems/binary-tree-paths/description/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String str = "";
        dfs(root,list,str);
        return list;
    }
      void  dfs(TreeNode root,List<String> list,String str){
      if(root==null) return;
      if(root.left==null && root.right==null){
         str = str+String.valueOf(root.val);
         list.add(str);
      }
      dfs(root.left,list,str+String.valueOf(root.val)+"->");
      dfs(root.right,list,str+String.valueOf(root.val)+"->");
    }
}

class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) {
     List<String> list = new ArrayList<>();
     Queue<TreeNode> queue1 = new LinkedList<>();
     Queue<String> queue2 = new LinkedList<>();
     queue1.add(root);
     queue2.add("");
     while(!queue1.isEmpty()){
         TreeNode node = queue1.poll();
         String currString = queue2.poll();
         if(node.left==null && node.right==null){
             list.add(currString+String.valueOf(node.val));
         }
         if(node.left!=null){
             queue1.add(node.left);
             queue2.add(currString+String.valueOf(node.val)+"->");
         }
         if(node.right!=null){
             queue1.add(node.right);
             queue2.add(currString+String.valueOf(node.val)+"->");
         }
     }
       return list;
    }
  
}

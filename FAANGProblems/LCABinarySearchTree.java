https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
TC: O(n)
Sc: O(n)  
 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==null) return null;
       if(root==p || root==q) return root;
       if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
       }
       if(p.val>root.val && q.val>root.val){
             return lowestCommonAncestor(root.right,p,q);
       }
      return root; 
    }

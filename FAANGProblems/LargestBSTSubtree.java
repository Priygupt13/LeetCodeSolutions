class Pair{
    int min;
    int max;
    int size;
    public Pair(int min,int max,int size){
        this.min = min;
        this.max = max;
        this.size = size;
    }
}
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root==null) return 0;
        Pair p = dfs(root);
        return p.size;
    }
    Pair dfs(TreeNode root){
        if(root==null) return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        if(left.max>=root.val || right.min<=root.val){
            return new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
        }else{
            return new Pair(Math.min(root.val,left.min),Math.max(root.val,right.max),1+left.size+right.size);
        }
    }
}

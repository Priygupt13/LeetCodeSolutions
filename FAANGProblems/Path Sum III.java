// TC : O(n)
// SC : O(n)

class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
         helper(root,0,map,(long)targetSum);
        return count;
    }

    void helper(TreeNode root,long sum,Map<Long,Integer> map,long target){
        if(root==null) return;
        sum+=root.val;
        
        if(map.containsKey(sum-target)){
           count+= map.get(sum-target); 
        }
        if(map.containsKey(sum)){
            map.put(sum,map.get(sum)+1);
        }else{
            map.put(sum,1);
        }
        helper(root.left,sum,map,target);
         helper(root.right,sum,map,target);
        map.put(sum,map.get(sum)-1);
    }
}

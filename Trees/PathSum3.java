https://leetcode.com/problems/path-sum-iii/description/

TC : O(n)
Sc : O(n)

class Solution {
   
    int pathCount = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        long sum = 0;
        HashMap<Long,Integer> map = new HashMap<>();
        if(root.left==null && root.right==null){
            sum+=root.val;
            if(sum==targetSum) pathCount++;
            return pathCount;
        }
         dfs(root,sum,map,targetSum);
        return pathCount;
    }

    private void dfs(TreeNode root,long sum,HashMap<Long,Integer> map,int target){
        if(root==null) return;
        sum+=root.val;
        if(sum==target) pathCount++;
        long val = sum - target;
        if(map.containsKey(val)){
            pathCount+= map.get(val);
        }
        if(map.containsKey(sum)){
           int x = map.get(sum);
           map.put(sum,x+1);
        }else map.put(sum,1);
       
        dfs(root.left,sum,map,target);
        dfs(root.right,sum,map,target);
        map.put(sum, map.get(sum) - 1);
        map.remove(sum);
    }
}
/**
Class Solution{

    @Test
    public void testPathSum_WithRootNull_ShouldReturnZero(){
     // Create an instance of the class containing the pathSum method
       Solution solution = new Solution();
       int actual = solution.pathSum(null, 5);
       int expected = 0;
       Assertion.assertEquals(expected,actual);
    }

   @Test
   public void testPathSum_WithSingleRootNodeEqualToTarget_ShouldReturnOne(){
      Solution solution = new Solution();
      TreeNode root = new TreeNode(2);
      int actual = solution.pathSum(root, 2);
      int expected = 1; 
      assertEquals(expected,actual);
   }

   @Test
   public void testPathSum_WithSingleRootNodeNotEqualToTarget_ShouldReturn0(){
       Solution solution = new Solution();
      TreeNode root = new TreeNode(3);
      int actual = solution.pathSum(root, 2);
      int expected = 0; 
      assertEquals(expected,actual);
   }

   @Test
   public void testPathSum_WithMultipleNodesAndTargetSumExists_ShouldReturnCorrectCount(){
      // Create the binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        // Set the target sum
        int targetSum = 22;

         Solution solution = new Solution();
        int actual = solution.pathSum(root, targetSum);

        // Assert that the path count is correct
        assertEquals(3, pathCount);
   }
   @Test
   public void testPathSum_WithMultipleNodesPathNotExistsWithTargetSum_ShouldReturn0(){
      // Create the binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        // Set the target sum
        int targetSum = 10;

         Solution solution = new Solution();
        int actual = solution.pathSum(root, targetSum);

        // Assert that the path count is correct
        assertEquals(0, pathCount);
   }
}

 */

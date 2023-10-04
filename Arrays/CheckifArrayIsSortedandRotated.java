import static org.junit.Assert.assertEquals;
// TC : O(n)
// SC : O(1)
class Solution {
    public boolean check(int[] nums) {
         if(nums.length==1) return true;
         int count = 0;
         for(int i =1 ;i<nums.length; ++i){
               if(nums[i]<nums[i-1]){
                  count++;
               }
               if(count>1) return false;
         } 
          if(count==0) return true;
          return nums[0]>=nums[nums.length-1];
    }
}
class Test{
    @Test
    public testSingleElementArray(int[] nums){
    int[] nums = {1};
    Solution obj = new Solution();
    boolean actual = obj.check(nums);
    boolean expected = true;  
     Assert.assertEquals(actual,expected); 
    }

  @Test
   public testIncreasingArray(int[] nums){
    int[] nums = {1,2,3,4};
    Solution obj = new Solution();
    boolean actual = obj.check(nums);
    boolean expected = true;  
     Assert.assertEquals(actual,expected); 
    }
  @Test
 public testDecreasingArray(int[] nums){
    int[] nums = {4,3,2,1};
    Solution obj = new Solution();
    boolean actual = obj.check(nums);
    boolean expected = true;  
     Assert.assertEquals(actual,expected); 
    }
  @Test
   public testOneSwapArray(int[] nums){
    int[] nums = {3,4,5,1,2};
    Solution obj = new Solution();
    boolean actual = obj.check(nums);
    boolean expected = true;  
     Assert.assertEquals(actual,expected); 
    }
    @Test
   public testNonIncreasingOneSwapArray(int[] nums){
    int[] nums = {5,1,2,3,4};
    Solution obj = new Solution();
    boolean actual = obj.check(nums);
    boolean expected = true;  
     Assert.assertEquals(actual,expected); 
    }
   @Test
   public testIncreasingTwoSwapArray(int[] nums){
    int[] nums = {1,3,2,5,4};
    Solution obj = new Solution();
    boolean actual = obj.check(nums);
    boolean expected = false;  
     Assert.assertEquals(actual,expected); 
    }
}

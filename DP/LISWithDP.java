https://leetcode.com/problems/longest-increasing-subsequence/
TC : O(n^2)
SC : O(n)  
class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] LIS = new int[nums.length];
       Arrays.fill(LIS,1);
       int max = 1;
       for(int i=nums.length-2;i>=0;--i){
           int j = i+1;
           while(j<nums.length){
               if(nums[i]<nums[j]){
                   LIS[i] = Math.max(LIS[i],1+LIS[j]);
               }
               j++;
           }
        max = Math.max(max,LIS[i]);
       }
       return max;
    }
     

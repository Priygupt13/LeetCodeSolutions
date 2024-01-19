// https://leetcode.com/problems/max-consecutive-ones-iii/
// TC : O(n)
// Sc : O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int len = 0;
        int max = 0;
        int count = 0;
        while(end < nums.length){
            if(nums[end]==1){
                len = end-start+1;
                max = Math.max(len,max);
            }else{
                 count++;
                 if(count<=k){
                     len = end-start+1;
                     max = Math.max(len,max);
                 }else{
                     while(start<nums.length && nums[start]!=nums[end]){
                         start++;
                     }
                     start++;
                     count--;
                 }
            }
             end++;
        }
        return max;
    }
}

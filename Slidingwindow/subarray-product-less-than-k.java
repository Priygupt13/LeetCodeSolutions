https://leetcode.com/problems/subarray-product-less-than-k/
TC : O(n)
SC : O(1)  
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int product = 1;
        int start = 0;
        int end = 0;
        while(end < nums.length){
            if(nums[end]>=k){
                start = end+1;
                end++;
                product = 1;
                continue;
            }
            product = product*nums[end];
            if(product<k){
                count+= end-start+1;
            }else{
               while(start <= end && product>=k){
                   product = product/nums[start];
                   start++;
               }
                count+= end-start+1;
            }
            end++;
        }
        return count;
    }
}

// https://leetcode.com/problems/subarray-product-less-than-k/description/

// [1,1,1] k = 1
// TC : O(n)
// SC : O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        if(k==0) return 0;
        int prod = 1;
        while(end<nums.length){
            prod = prod * nums[end];
            if(prod<k){
                count+= end-start+1;
            }else{
                prod = prod/nums[start];
                start++;
                while(prod>=k && start<end){
                  prod = prod/nums[start];
                  start++;  
                }
                 if(prod<k)
                   count+=end-start+1;
            }
            end++;
        }
        return count;
    }
}

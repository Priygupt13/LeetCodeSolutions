https://leetcode.com/problems/wiggle-sort/

class Solution {
    // TC : O(n)
    // SC : O(1)
    public void wiggleSort(int[] nums) {
        for(int i=1;i<nums.length;++i){
           if(i%2==1){
               if(nums[i]>nums[i-1]) continue;
               swap(nums,i,i-1);
           }else{
               if(nums[i]<nums[i-1]) continue;
               swap(nums,i,i-1);
           }
        }
    }
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

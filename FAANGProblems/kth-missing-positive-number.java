https://leetcode.com/problems/kth-missing-positive-number/
TC : O(log(n))
SC : O(n)  
class Solution {
    public int findKthPositive(int[] arr, int k) {
       int start = 0;
       int end = arr.length-1;
       int[] nums = new int[arr.length];
       for(int i=0;i<arr.length;++i){
           int num = i+1;
           int missNumbersSofar = arr[i]-num; 
           nums[i] = missNumbersSofar;
       }
       while(start<=end){
         int mid = start + (end-start)/2;
         if(nums[mid]<k){
             start = mid+1;
         }else{
             end=mid-1;
         }
       }
       if(end<0){
          return k;
       }
       return arr[end]+(k-nums[end]);
    }
}

/*
 * LeetCode Url: https://leetcode.com/problems/contains-duplicate-ii
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */ 

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==1 && k==0) return true;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;++i){
           if(!map.containsKey(nums[i])){
               map.put(nums[i],i);
           }else{
                int val = map.get(nums[i]);
                int diff = Math.abs(val-i); 
                if(diff<=k)
                 return true;
                else
                   map.put(nums[i],i);
           }
        }
        return false;
    }
}


https://leetcode.com/problems/continuous-subarray-sum/
TC : O(n)
SC : O(n)  
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean flag = false;
        map.put(0,-1);
        int sum = 0;
        for(int i =0;i<nums.length;++i){
            sum+=nums[i];
            int rem = sum%k;
            if(map.containsKey(rem)){
                   int len =  i - map.get(rem);
                   if(len>=2)
                    return true;
            }else{
                    map.put(rem,i);
            }
        }
        return flag;
    }
}

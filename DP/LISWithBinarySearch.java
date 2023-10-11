https://leetcode.com/problems/longest-increasing-subsequence/
TC : O(nlog(n))
SC: O(n)  
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;++i){
           if(nums[i]>list.get(list.size()-1)){
               list.add(nums[i]);
           }else{
               int index = binarySearch(nums[i],list);
               list.set(index,nums[i]);
           }
        }
        return list.size();
    }
      int binarySearch(int val,List<Integer> list){
             int start = 0;
             int end = list.size()-1;
               while(start <= end){
                  int mid = (start + end)/2;
                    if(list.get(mid)==val){
                         return mid;
                    }
                    else if(list.get(mid)<val){
                       start = mid + 1;
                    }else{
                      end = mid -1;
                    }
               }
               return start;
      }
}

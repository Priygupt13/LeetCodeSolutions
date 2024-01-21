TC :O(nlogn)
SC : O(1)  
class Solution {
    public void nextPermutation(int[] nums) {
     if(nums.length==1) return;
      boolean found = false;
      for(int i=nums.length-1;i>0;--i){
        if(nums[i-1]>=nums[i]) continue;
        int curr = nums[i];
        int pos = i-1;
        int j = nums.length-1;
        while(j>pos){
          if(nums[j]>nums[pos]){
            swap(j,pos,nums);
            found = true;
            break;
          }
          j--;
        }
         sortArray(pos+1,nums.length-1,nums);
         break;
      }
      if(!found){
        Arrays.sort(nums);
      }
    }
     void swap(int index1,int index2,int[] nums){ //  2,1,[1,2,3]
        int temp = nums[index1]; // 1
        nums[index1] = nums[index2]; // [2,2,3]
        nums[index2] = temp; // [2,1,3]
    }
    void sortArray(int start,int end,int[] nums){
        if(start==end) return;
        while(start<end){
            if(nums[start]>nums[end]){
               swap(start,end,nums);
            }
            start++;
            end--;
        }
    }
}

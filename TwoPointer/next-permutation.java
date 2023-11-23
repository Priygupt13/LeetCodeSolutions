class Solution {
    // TC: O(n) + O(n/2)
   // n/2 bcz it is swapping half array in sort function
  // O(n)
  // Sc : O(1)
    public void nextPermutation(int[] nums) {
        // step 1. find the break point means at what point i-1 < i element
        // iterate from last element and check i-1 > i then move ahead and stop where it is not
        boolean found = false;
        if(nums ==null || nums.length<=1) return;
        
        for(int i=nums.length-1;i>0;--i){
            if(nums[i-1]>=nums[i]){
                continue;
            }else{
                found = true;
                int position = i-1;
                int j = nums.length-1;
                while(j>position){
                    if(nums[j]>nums[position]){
                        swap(position,j,nums);
                        break;
                    }
                    j--;
                }
                sort(i,nums,nums.length-1);
                break;
            }
           
        }
        if(!found){
             sort(0,nums,nums.length-1); 
             return;
        }  

    }
    void swap(int index1,int index2,int[] nums){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    void sort(int start,int[] nums,int end){
         while(start < end){
             swap(start,end,nums);
             start++;end--;
         }
    }
}

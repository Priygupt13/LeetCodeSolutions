https://leetcode.com/problems/koko-eating-bananas/description/

TC : O(nlogm)
SC : O(1)    

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int max = 0;
        for(int i=0;i<piles.length;++i){
          max = Math.max(max,piles[i]);
        }
        int end = max;
        while(start <= end){
          int mid = start + (end - start)/2;
          int hours = 0;  
          if(canfinish(piles,h,mid)){
            end = mid -1;
          }else{
            start = mid+1;
          }  
        }
        return start;
      }

      boolean canfinish(int[] piles,int target,int mid){
           int totalTime = 0;
          for(int i=0;i<piles.length;++i){
             if(piles[i]%mid==0){
               totalTime+=(piles[i]/mid);
             }
            else{
                 totalTime+=(piles[i]/mid)+1;
            }
            if(totalTime>target) return false;
          }
          return true;
      }

}
    

https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
TC : O(nlogn)
SC : O(1)  

class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int high = 0;
       int low = 0;
       for(int i=0;i<weights.length;++i){
           high+= weights[i];
           low = Math.max(low,weights[i]);
       }
           int mid  = 0;
           int minWeight = Integer.MAX_VALUE;
         while(low<=high){
           mid = low+(high-low)/2;
           boolean totaldays = checkShip(weights,days,mid);
            if(totaldays){
               high = mid-1;
               minWeight = mid;
             }else {
                low = mid+1;
             }
          }
       return minWeight;
    }
    boolean checkShip(int[] weights,int days,int max){
            int currentDay = 1;
            int total = 0;
            for(int i=0;i<weights.length;++i){
               total+= weights[i];
               if(total > max){
                   total = weights[i];
                   currentDay++; 
               }
               if(currentDay > days) return false;
           } 
        return true;
    }
}

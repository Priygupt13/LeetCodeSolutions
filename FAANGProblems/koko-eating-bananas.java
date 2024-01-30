// https://leetcode.com/problems/koko-eating-bananas/
// TC : O(n)*Log(largestPilesize)
// SC : O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
          int largestPile = 0;
        for(int i=0;i<piles.length;++i){
            if(piles[i]>largestPile) // 11>7
              largestPile = piles[i]; // 11
        }
        int start = 1;
        int end = largestPile; // 11
        int prev = 1;
        while(start<=end){ // 4<=3
            int mid = start+(end-start)/2; // 4
            if(canFinish(mid,h,piles)){ // 
                prev = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return prev;
    }
     boolean canFinish(double k,int h,int[] piles){ // 3,8,[3,6,7,11]
        int hours = 0;
        for(int i=0;i<piles.length;++i){  
           hours+=Math.ceil(piles[i]/k);
        }
        return hours<=h; // 10<=8
    }
}

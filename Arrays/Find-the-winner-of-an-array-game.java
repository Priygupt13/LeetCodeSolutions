https://leetcode.com/problems/find-the-winner-of-an-array-game/?envType=daily-question&envId=2023-11-05

class Solution {
    public int getWinner(int[] arr, int k) {
        if(k==1){
           return Math.max(arr[0],arr[1]);
        }
        int max = 0;
        for(int j=0;j<arr.length;++j){
            max = Math.max(max,arr[j]);
        }
        if(k>=arr.length){
          return max;
        }
          int currWinner = arr[0];
          int WinnerCount = 0;
          for(int i=1;i<arr.length;++i){
              int curr = arr[i];
              if(currWinner > arr[i]){
                 WinnerCount++;
              }else{
                  currWinner = arr[i];
                  WinnerCount = 1;
              }
              if(WinnerCount == k){
                  return currWinner;
              }
          }
          return currWinner;
        }
}

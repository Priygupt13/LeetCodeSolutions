https://leetcode.com/problems/maximum-length-of-pair-chain/
Tc: O(n^2)
Sc: O(n)  
class Solution {
    public int findLongestChain(int[][] pairs) {
      int[] dp = new int[pairs.length];  
      Arrays.fill(dp,1);
      if(pairs.length==1) return 1;
      Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
      int max = 0;
       for(int i=pairs.length-2;i>=0;--i){
           int j = i+1;
           while(j<pairs.length){
                if(pairs[j][0]>pairs[i][1]){
                 dp[i] = Math.max(dp[i],dp[j]+1);
                }
                j++;
           }
           max= Math.max(max,dp[i]);
       }
       return max;
    }
}

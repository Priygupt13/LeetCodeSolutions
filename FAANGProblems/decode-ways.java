// https://leetcode.com/problems/decode-ways/
// Tc: O(2^n) without memoization
// Tc : O(n) with memoization
// Sc : O(n)
class Solution {
    public int numDecodings(String s) {
       int[] dp = new int[s.length()+1];
       Arrays.fill(dp,-1);
      return solve(s,0,s.length(),dp); 
    }
    int solve(String str,int i,int n,int[] dp){
       if(dp[i]!=-1) return dp[i]; 
       if(i>=n){
          dp[i] = 1; 
          return dp[i];
       }
       if(str.charAt(i)=='0')  {
           dp[i] = 0;   
          return dp[i];
       }  
        int result = solve(str,i+1,n,dp);
        dp[i] = result;
        if(i+1<str.length()){
             if(str.charAt(i)=='1' || (str.charAt(i)=='2' && str.charAt(i+1)<='6')){
              result += solve(str,i+2,n,dp);
              dp[i] = result;
             }
        }
       return dp[i];
    }

}

https://leetcode.com/problems/count-binary-substrings/description/

Approach :  increase count if  prev and curr are same and if they are not same, then take the min of count and prev, and reset the count 
class Solution {
    public int countBinarySubstrings(String s) {
         int count = 1;
         int ans = 0;
         int prev = 0;
        
         for(int i=1;i<s.length();++i){
             if(s.charAt(i)==s.charAt(i-1)){
                 count++;
             }
             else{
                 ans+= Math.min(count,prev);
                 prev = count;
                 count = 1;
             }
         }
         ans+= Math.min(prev,count);
         return ans;
    }
}

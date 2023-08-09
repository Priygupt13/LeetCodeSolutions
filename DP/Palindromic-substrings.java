https://leetcode.com/problems/palindromic-substrings/
Time complexity : O(n^2)
Space complexity : O(1)  
  

class Solution {
    public int countSubstrings(String s) {
        if(s.length()<2) return 1;
        int result = 0;
        // for odd-length substring
        for(int i=0;i<s.length();++i){
            int left = i;
            int right = i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                result++;
                left--;
                right++;
            }
        }
       // for even-length substring
       for(int i=0;i<s.length();++i){
            int left = i;
            int right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
}

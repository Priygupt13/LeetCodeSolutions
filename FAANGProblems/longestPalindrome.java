// https://leetcode.com/problems/longest-palindromic-substring/
// TC: O(n^2)
// SC : O(1)

// Approach: Palindrome Expansion:
/*
    1. Iterate through each character in the string.
    2. For each character, consider it as a potential center of a palindrome.
    3. Expand outward from the center to check for palindromes.
    4. Two cases are considered:
       Palindromes with odd length.
       Palindromes with even length.
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        int maxLen = 1;
        int len = 1;
        String ans = "";
             for(int i=0;i<s.length();++i){
                 int start = i;
                 int end = i;
                 while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
                     len = end-start+1; 
                     start--;
                     end++;
                    
                 }
                 if(maxLen<len){
                     maxLen = len;
                     if(start<s.length()){
                          ans = s.substring(start+1,end);
                     } 
                 }
             }
             for(int i=0;i<s.length();++i){
                 int start = i;
                 int end = i+1;
                 while(start>=0  && end<s.length() && s.charAt(start)==s.charAt(end)){
                     len = end-start+1;
                     start--;
                     end++;
                    
                 }
                 if(maxLen<len){
                     maxLen = len;
                     ans = s.substring(start+1,end);
                 }
             }
        if(maxLen==1){
            ans = s.substring(0,1);
            return ans;
        }else 
          return ans;
    }
}

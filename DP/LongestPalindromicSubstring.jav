https://leetcode.com/problems/longest-palindromic-substring/description/
// TC : O(n^2)
// SC : O(1)
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        int length = 1;
        int max = 1;
        String s1 = "";
       
    
        for(int i=0;i<s.length();++i){
            int left = i;
            int right = i;
             // for odd scenario
            while(left>=0 && right<s.length() && (s.charAt(left)==s.charAt(right))){
                 length = right - left +1;
                left--;
                right++;
            }
            
            if(max < length){
                max = length;
                s1 = s.substring(left+1,right);
               
            }
            
        }
      
      // for even scenario
        for(int i=0;i<s.length();++i){
            int left = i;
            int right = i+1;
             // for odd scenario
            while(left>=0 && right<s.length() && (s.charAt(left)==s.charAt(right))){
                 length = right - left +1;
                left--;
                right++;
            }
            
            if(max < length){
                max = length;
                s1 = s.substring(left+1,right);
               
            }
            
        }
       
        if(max==1){
           s1 = s.substring(0,1);
          return s1;
        } 
        else return s1;
        
    }
}

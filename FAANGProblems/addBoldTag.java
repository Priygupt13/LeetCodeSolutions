// TC : O(m*n)
// len(s) - n
// len(dict)- m
// SC : O(n)
// https://leetcode.com/problems/add-bold-tag-in-string/
class Solution {
    public String addBoldTag(String s, String[] words) {
       boolean[] bold = new boolean[s.length()];
       for(String word : words){
           // find all the occurrences of the word in s and mark them true
           int index = s.indexOf(word);
           while(index!=-1){
               for(int start=index; start < index+word.length(); start++){
                   bold[start] = true;
               }
               index = s.indexOf(word, index+1);
           } 
       }

       // build the response
       StringBuilder sb = new StringBuilder();
        for(int i=0;i<bold.length;++i){
          if(bold[i]){
              if(i==0 || !bold[i-1]){
                  sb.append("<b>");
              }
              sb.append(s.charAt(i));
              if(i==bold.length-1 || !bold[i+1]){
                  sb.append("</b>");
              } 
          }else{
               sb.append(s.charAt(i));
          }
        }
        return sb.toString();
    }
}

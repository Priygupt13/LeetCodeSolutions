https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/

class Solution {
     public String removeDigit(String number, char digit) {
       List<String> list = new ArrayList<>();
        for(int i=0;i<number.length();++i){
            char ch = number.charAt(i);
            if(ch==digit){
               String str = number.substring(0,i)+number.substring(i+1);
               list.add(str);
            }
        }
         Collections.sort(list);
         return list.get(list.size()-1);
     }
 }

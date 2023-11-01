https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=featured-list&envId=top-microsoft-questions?envType=featured-list&envId=top-microsoft-questions
TC : O(n(4^n))
SC : O(n)  
class Solution {
    public List<String> letterCombinations(String digits) {
           List<String> result = new ArrayList<>();
           StringBuilder sb = new StringBuilder();
           if(digits.length()==0) return result;
           Map<Integer,String> map = new HashMap<>();
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
           helper(0,digits,sb,map,result);
           return result;
    }
    void helper(int index,String digits,StringBuilder sb,
    Map<Integer,String> map,List<String> result){
         if(index==digits.length()){
             if(sb.length()==digits.length()){
                 result.add(sb.toString());
             }
             return;
         }
         int number = digits.charAt(index)-'0';
         String letters = map.get(number);
         for(int i=0;i<letters.length();++i){
             sb.append(letters.charAt(i));
             helper(index+1,digits,sb,map,result);
             sb.deleteCharAt(sb.length()-1);
         }
    }
}

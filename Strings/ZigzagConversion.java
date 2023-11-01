https://leetcode.com/problems/zigzag-conversion/?envType=featured-list&envId=top-microsoft-questions?envType=featured-list&envId=top-microsoft-questions
TC: O(s.length()*numRows)
SC: O(s.length()*numRows)
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        Map<Integer,List<Character>> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        int i = 0;
        while(i<s.length()){
           int j = 0;
           while(i<s.length() && j<numRows){
                char ch = s.charAt(i);
                if(!map.containsKey(j)){
                    list = new ArrayList<>();
                    list.add(ch);
                    map.put(j,list);
                    j++;
                }else{
                    map.get(j).add(ch);
                    j++;
                } 
                i++;
            }
            for(int k = numRows-2; k>=1;--k){
                 if(i<s.length()){
                     char ch1 = s.charAt(i);
                    if(map.containsKey(k))
                     map.get(k).add(ch1);
                 }
                 i++; 
            }  
        }
      StringBuilder res = new StringBuilder();
      for(Integer key : map.keySet()){
          List<Character> ls =   map.get(key);
          for(int x=0;x<ls.size();++x){
              res.append(ls.get(x));
          }
      }
     return res.toString();
    }
}

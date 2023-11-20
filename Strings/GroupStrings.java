TC : O(m*n)
SC : O(m*n)  
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> ls = new ArrayList<>();
        for(String str: strings){
            int i = 1;
            String key = "";
            while(i<str.length()){
               int x = str.charAt(i)-'0';
               int y = str.charAt(i-1)-'0'; 
               int diff = ((x-y)+26)%26;
               key+=String.valueOf(diff)+",";
               i++;
            }
            if(key.length()==0 || key.isEmpty()) key+="-1";
            if(!map.containsKey(key)){
               List<String> list = new ArrayList<>();
               list.add(str); 
               map.put(key,list);
            }else{
                map.get(key).add(str);
            }
        }
       
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
             ls.add(entry.getValue());
        }
        return ls;
    }
}

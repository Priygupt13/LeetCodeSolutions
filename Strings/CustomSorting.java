class Solution {
      class Student{
        private int position;
        private String values;
        public Student(int position,String values){
            this.position = position;
            this.values = values;
        }
        public String toString(){
            return this.position + " " + this.values;
        }
    }
    public String customSortString(String order, String s) {
         HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();++i){
            char ch = s.charAt(i);
             if(!map.containsKey(ch)){
                map.put(ch,1);
             }else{
                 int freq = map.get(ch);
                 map.put(ch,freq+1);
             }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();++i){
                char ch = order.charAt(i);
                if(map.containsKey(ch)){
                    int freq = map.get(ch);
                    String s1 = "";
                    while(freq>0){
                       s1+= ch;
                       freq--;
                    }
                    sb.append(s1);
                    map.put(ch,0);
                }
        }
        System.out.print(map);
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
                  if(entry.getValue()!=0){
                    int freq = entry.getValue();
                    char ch = entry.getKey();
                    String s1 = "";
                    while(freq>0){
                       s1+= ch;
                       freq--;
                    }
                    sb.append(s1);
                  }
        }
        return sb.toString();

    }
}

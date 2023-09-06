// Problem : https://leetcode.com/problems/time-based-key-value-store/description/
// TC: O(log(n))
// SC: O(k*n) k = total no of keys and n = number of nodes
class Node{
    int time;
    String value;
    Node(int time,String value){
        this.time = time;
        this.value = value;
    }
}
class TimeMap {

    HashMap<String,List<Node>> mappings;
    public TimeMap() {
       mappings = new HashMap<String,List<Node>>();
    }
    
    public void set(String key, String value, int timestamp) {
       // if key does not exist 
       Node newNode = new Node(timestamp,value);
        if(!mappings.containsKey(key)){
             List<Node> list = new ArrayList<>();
             list.add(newNode);
             mappings.put(key,list);
        }  
        else{
               List<Node> list1 = mappings.get(key);
               list1.add(newNode);
               mappings.put(key,list1);  
        }
       //System.out.print(mappings);    
    }
    
    public String get(String key, int timestamp) {
        if(!mappings.containsKey(key)) return "";
        List<Node> list2 = mappings.get(key);
        return binarySearch(list2,0,list2.size()-1,timestamp);
    }

    String binarySearch(List<Node> list, int start, int end,int timeStamp)  {
      int mid = 0;
      while(start < end){
           mid = start + (end - start)/2 +1;
          Node x = list.get(mid);
          if(x.time == timeStamp) return x.value;
          else if(x.time < timeStamp){
              start = mid;
          } 
          else end = mid - 1;
      }
      if(list.get(start).time > timeStamp) return "";
      else return  list.get(start).value;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

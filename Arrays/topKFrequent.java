class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      if(nums.length==1) return new int[]{1};

      // Step 1: Create a frequency map
    Map<Integer,Integer> map = new HashMap<>();

     // Step 2: Fill the map
    for(int num : nums){
      if(!map.containsKey(num)){
          map.put(num,1);
      }else{
        map.put(num,map.get(num)+1);
      }
    }
      // Step 3: Create a bucket
     List<List<Integer>> buckets = new ArrayList<>();
     for(int num : nums){
      buckets.add(new ArrayList<>());
     }
      buckets.add(new ArrayList<>());
    
      // Step 4: Fill the bucket with (freq -> list of numbers having that frequency)
     for(Map.Entry<Integer,Integer> entry : map.entrySet()){
         int freq = entry.getValue();
         List<Integer> listOfElements = buckets.get(freq);
         if(listOfElements.isEmpty()){
                listOfElements.add(entry.getKey());
         }else{
           buckets.get(freq).add(entry.getKey());
         }
     }
     // Step 5: fill the elemnts in result array
     int[] ans = new int[k];
     int x = 0;
     for(int i=buckets.size()-1;i>=0;--i){
        if(!buckets.get(i).isEmpty() && x!=k){
           List<Integer> list1 = buckets.get(i);
           for(Integer item : list1){    
                 ans[x] = item;
                 x++;
           }
        }
     }
       return ans; // [3,4]
    }
}

https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/description/
TC : O(n)
SC : O(1)  
class Solution {
    public int numOfPairs(String[] nums, String target) {
       HashMap<String,Integer> map = new HashMap<>();
       int count =0;
       for(int i=0;i<nums.length;++i){
           String str = nums[i];
           if(target.startsWith(str)){
               String sub = target.substring(str.length());
               if(map.containsKey(sub)){
                   count+= map.get(sub);
               }
           }
           if(target.endsWith(str)){
               String sub1 = target.substring(0,target.length()-str.length());
               if(map.containsKey(sub1)){
                   count+= map.get(sub1);
               }
           }
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }
       return count;
    }

}

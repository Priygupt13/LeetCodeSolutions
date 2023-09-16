https://leetcode.com/problems/insert-interval/

class Solution {
   
    public int[][] insert(int[][] intervals, int[] newInterval) {
       
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
         // condition 1:
          // when newinterval is added at the end of intervals:
            if(newInterval == null || interval[1]<newInterval[0]){
              list.add(interval);  
            } // condition 2:
          // when newinterval is added at the beginning of intervals:
            else if(interval[0]>newInterval[1]){
                list.add(newInterval);
                 list.add(interval);
                newInterval = null;
            }else { // when newinterval is overlap with intervals
                int min = Math.min(interval[0],newInterval[0]);
                int max = Math.max(interval[1],newInterval[1]);
                newInterval[0] = min;
                newInterval[1] = max;
            }
        }
       
        if (newInterval != null) list.add(newInterval);
       return list.toArray(new int[list.size()][2]);
       // int[][] result = new int[list.size()][2];
      //   for(int j =0;j<list.size();++j){
      //      int[] interval = list.get(j);
      //      result[j]= interval;
    //    }
     //   return result;
    }
}

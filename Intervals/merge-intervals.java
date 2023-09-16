https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
       // sort the intervals based on the start time
       Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
       List<int[]> result = new ArrayList<>();
       // store the first interval in the list to compare it with next interval
       result.add(intervals[0]);
       for(int i=1;i<intervals.length;++i){ // iterate over all intervals 
           int[] interval = intervals[i]; 
           int[] prev = result.get(result.size()-1); 
           if(prev[1]>=interval[0]){  
             // if end time of previous interval is greater than start 
             //time of current interval it means we nedd to merge them
             // take the max end time because start time is already in sorted 
             //so the prev interval will have the min start time already
             prev[1] = Math.max(interval[1],prev[1]);
             // remove the last interval
             result.remove(result.size()-1);
             // update with the overlapped interval
             result.add(prev);
           }else{
             // if not overlapped then add the interval
                result.add(interval);
           }
       }
      // convert the list into array
       return result.toArray(new int[result.size()][2]);
    }
}

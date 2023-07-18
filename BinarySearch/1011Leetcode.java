https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
Tc :O(nlogm)
sc: O(1)

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        for(int weight : weights){
            start = Math.max(start,weight);
        }
        int end = 0;
        for(int weight : weights){
            end+=weight;
        }
        while(start < end){
            int mid = start + (end - start)/2;
            if(possibleCapacity(weights,mid,days)){
              end = mid;
            }else {
                start = mid+1;
            }
        }
        return start;
    }

    boolean possibleCapacity(int[] weights,int capacity,int days){
         int weightCarried = 0;
         int daysSpent = 1;
         int i = 0;
         for(i=0;i<weights.length;++i){
             weightCarried+= weights[i];
             if(weightCarried>capacity){
                 weightCarried = weights[i];
                 daysSpent++;
             }
         }
      return daysSpent<=days;
    }
}
/**
class ShipWithinDaysTest{
    
       @Test
       public void testshipWithinDays_CapacityLessThanMaximumWeight(){
           int[] weights = {10, 20, 30, 40, 50};
           int days = 5;
           int expected = 50;
           int result = shipWithinDays(weights, days);
           Assert.assertEquals(expected, result);
       }
    
      @Test
      public void testMinimumCapacity_SingleDay() {
        int[] weights = {1, 2, 3, 4, 5};
        int days = 1;
        int expected = 15;
        int result = shipWithinDays(weights, days);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void testEqualCapacity_MultipleDays() {
        int[] weights = {3, 4, 5, 2};
        int days = 4;
        int expected = 5;
        int result = shipWithinDays(weights, days);
        Assert.assertEquals(expected, result);
    }
    
}
 */

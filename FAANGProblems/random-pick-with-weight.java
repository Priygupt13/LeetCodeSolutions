/*
Cummulative sum is telling the probability distribution across elements in the array;
Cumulative sums provide an efficient way to handle random selection based on weights.
Without cumulative sums, you might need to traverse the entire array each time to calculate the total sum, making random selection less efficient.

Avoiding Recalculation:
Cumulative sums allow us to avoid recalculating the total sum for every random selection.
Once cumulative sums are precomputed during initialization, they can be used repeatedly for efficient random index selection.

Probability Distribution:
Cumulative sums create a range of values where each range corresponds to a particular index in the array.
The size of each range is proportional to the weight assigned to the corresponding index, ensuring a proper probability distribution.

Time Complexity: O(log n)
Space Complexity: O(n
*/

class Solution {
    int[] sum;
    Random random;
    int totalSum = 0;
    public Solution(int[] w) {
        random = new Random();
        sum = new int[w.length];
        sum[0] = w[0];
        int totalSum = w[0];
        for(int i=1;i<w.length;++i){
            sum[i] = w[i]+sum[i-1];
            totalSum+= w[i];
        }
       this.totalSum = totalSum;
       this.sum = sum;
    }
    // we need to call pick index multiple times to get random index
    public int pickIndex() {
        int start = 0;
        int end = sum.length-1;
        int number = random.nextInt(totalSum)+1;
        while(start < end) {
            int mid = start + (end-start)/2;
            if(sum[mid]==number) return mid;
            else if(sum[mid]<number) start = mid+1;
            else end = mid;
        }
        return start;
    }
}

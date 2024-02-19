class Solution {
    public int maximumSum(int[] arr) {
       
        int[] forward = new int[arr.length];
        int[] backward = new int[arr.length];
        int n = arr.length;
        int maxSum = arr[0];
        forward[0] = arr[0];
         //forward pass 
        for(int i=1;i<n;++i){
           forward[i] = Math.max(forward[i-1]+arr[i],arr[i]);
           maxSum = Math.max(maxSum,forward[i]);
        }
        // backward pass
        backward[n-1] = arr[n-1];
        for(int i=n-2;i>=0;--i){
           backward[i] = Math.max(backward[i+1]+arr[i],arr[i]);
           maxSum = Math.max(maxSum,backward[i]);
        }

        // find maximum sum considering deleting one element
        for(int i=1;i<n-1;++i){
          maxSum = Math.max(maxSum,forward[i-1]+backward[i+1]);
        }
        return maxSum;
    }
}

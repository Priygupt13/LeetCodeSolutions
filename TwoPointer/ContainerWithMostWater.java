https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    // TC : O(n)
    // SC : O(1)
    // remember that there can be a pillar of 0 height and other of some height like 0,2
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxA = 0;
        while(start<end){
           int width = end - start;
           int len = Math.min(height[start],height[end]);
           int area = len * width;
           maxA = Math.max(area,maxA);
           if(height[start] < height[end]){
               start++;
           }else {
               end--;
           }
        }
        return maxA;
    }
}


https://leetcode.com/problems/top-k-frequent-elements/description/
TC: O(n * log(k))
SC : O(n+k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<nums.length;++i){
            frequencyMap.put(nums[i],frequencyMap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });

        for(int key : frequencyMap.keySet()){
            minHeap.offer(new int[]{key,frequencyMap.get(key)});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] arrofTopKFrequentElements = new int[minHeap.size()];
        int x = arrofTopKFrequentElements.length-1;
        while(!minHeap.isEmpty()){
            arrofTopKFrequentElements[x] = minHeap.poll()[0];
            x--;
        }
        return arrofTopKFrequentElements;
    }
}

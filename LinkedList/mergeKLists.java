
https://leetcode.com/problems/merge-k-sorted-lists/description/

# TC : O(nlogk)
# SC: O(k)  
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         if(lists.length==0) return null;
         if(lists.length==1) return lists[0];
       
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a,b)->{
          return a.val - b.val;
        });
        for(int i=0;i<lists.length;++i){
          ListNode x = lists[i];
              if(x!=null)
               minHeap.offer(x);
        }
         System.out.print(minHeap.size());
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){

            ListNode nodes =  minHeap.poll();
            curr.next = nodes;
            curr = curr.next;
            if(nodes.next!=null){
              minHeap.offer(nodes.next);
            }
           
        }  
       return dummy.next;
    }
}

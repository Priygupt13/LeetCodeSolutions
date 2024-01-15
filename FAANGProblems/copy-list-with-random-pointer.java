/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// TC : O(n)
// SC : O(n)
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<Node,Node>();
        Node temp = head;
        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        Node ptr = head;
        while(ptr!=null){
           if(map.containsKey(ptr)){
               Node copiedNode = map.get(ptr);
               Node randomPtr =  ptr.random;
               Node nextPtr = ptr.next;
               if(randomPtr==null){
                   copiedNode.random = null;
               }else{
                   if(map.containsKey(randomPtr)){
                     Node copiedRandom =   map.get(randomPtr);
                     copiedNode.random = copiedRandom;
                   }
               }
               if(nextPtr==null){
                 copiedNode.next = null;
               }
               else{
                  if(map.containsKey(nextPtr)){
                   Node copiedNextNode = map.get(nextPtr);
                   copiedNode.next = copiedNextNode;
                  }
               }
           } 
           ptr = ptr.next;
        }
        return map.get(head);
    }
}

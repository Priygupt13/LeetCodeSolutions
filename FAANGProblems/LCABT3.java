
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
TC : O(h)
SC : O(1)  
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
    int countP = getSize(p);
    int countQ = getSize(q);
    int diff = countP - countQ;
      while(diff>0){
          p = p.parent;
          diff--;
      }
      while(diff < 0){
          q = q.parent;
          diff++;
      }
      while(p!=q){
          p = p.parent;
          q = q.parent;
      }
      return p;
    }
    int getSize(Node p){
      int count = 0;
       Node temp = p;
       while(temp!=null){
           count++;
           temp = temp.parent;
       }
       return count;
    }
}

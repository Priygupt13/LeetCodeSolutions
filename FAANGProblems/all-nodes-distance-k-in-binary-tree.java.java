https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
TC : O(n)
SC : O(n)  
 public List<Integer> distance(TreeNode root, TreeNode target, int k) {
      List<Integer> list = new ArrayList<>();
        if(k==0) {
           list.add(target.val);
           return list;
        }
        if(root==null) return list;
        HashMap<Integer,TreeNode> map = new HashMap<>();
        map.put(root.val,null); // [3,null]
        createParentMapping(root,map); // 3,[3,null]
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        int level = 0;
        boolean flag = false;
        Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
        visited.put(target.val,true);
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            if(level==k) flag = true;
            for(int i=0;i<size;++i){
                TreeNode node = queue.poll();
                if(node.left!=null){
                   
                    if(!visited.containsKey(node.left.val)){
                        queue.add(node.left);
                        visited.put(node.left.val,true);
                          if(flag) {
                        list.add(node.left.val);
                       }
                    }
                       
                  
                }
                if(node.right!=null){
                  if(!visited.containsKey(node.right.val)){
                        queue.add(node.right);
                        visited.put(node.right.val,true);
                         if(flag) {
                          list.add(node.right.val);
                      }
                   }
                }
                if(map.containsKey(node.val)){
                    TreeNode parent = map.get(node.val);
                    if(parent!=null){
                       if(!visited.containsKey(parent.val)){
                        queue.add(parent);
                        visited.put(parent.val,true);
                         if(flag)
                          list.add(parent.val);
                       }
                   }
                }
            }
            flag = false;
        }
        return list;
    }
    void createParentMapping(TreeNode root,HashMap<Integer,TreeNode> map){
        if(root==null) return;
        if(root.left!=null){
              map.put(root.left.val,root); //[3,null],[5,3],[6,5],[7,2],[1,3],[0,1][8,1]
              createParentMapping(root.left,map);
        } 
        if(root.right!=null){
              map.put(root.right.val,root); // [2,5],[4,2]
              createParentMapping(root.right,map); //
        }
    }
   
}

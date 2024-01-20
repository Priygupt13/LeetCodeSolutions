https://leetcode.com/problems/nested-list-weight-sum/description/


class Solution {
   
    public int depthSum(List<NestedInteger> nestedList) {
      if(nestedList==null || nestedList.size()==0) return 0; 
       int[] sum = new int[1];
        dfs(nestedList,1,sum);
        return sum[0];
    }
    int dfs(List<NestedInteger> nestedList,int depth,int[] sum){
       for(NestedInteger list : nestedList){
           if(list.isInteger()){
              sum[0]+= depth*list.getInteger();
           }else{
               List<NestedInteger> nestedListItems = list.getList();
               dfs(nestedListItems,depth+1,sum);
           }
       }
      return sum[0];
    }
}


// approach
// 1. iterate over each number
// 2. for each number:
//      start to pick the first number
//      go back
//      try picking the next number   
class Solution {
    // TC : O(n!*n)
    // SC : O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }
    void backtrack(List<List<Integer>> resultList, List<Integer> list,int[] nums){

        if(list.size()==nums.length){
            resultList.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;++i){
            if(list.contains(nums[i])) continue;
             else  list.add(nums[i]);
            backtrack(resultList,list,nums);
            list.remove(list.size()-1);
        }
    }
}

class Solution {
    // TC : O(n)
    // SC : O(n)
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while(end<s.length()){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                max = Math.max(max,set.size()); 
            }else{
                while(s.charAt(start)!=s.charAt(end)){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.remove(s.charAt(start));
                start++;
                set.add(s.charAt(end));
            }
            end++;
        }
        return max;
    }
}

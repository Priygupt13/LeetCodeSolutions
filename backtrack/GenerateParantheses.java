https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n==1) {
          list.add("()");
          return list;
        } 
        String res = "";
        int open = n;
        int close = n;
        solve(open,close,new StringBuilder(),list);
        return list;
    }
    void solve(int open,int close,StringBuilder sb, List<String> list){
        if(open==0 && close==0) {
            list.add(sb.toString());
            return;
        }
        if(close>=open && open!=0){
            sb.append("(");
            solve(open-1,close,sb,list);
             sb.deleteCharAt(sb.length()-1);
        }
        if(close!=0){
             sb.append(")");
             solve(open,close-1,sb,list);
             sb.deleteCharAt(sb.length()-1);
        }
      
    }
}

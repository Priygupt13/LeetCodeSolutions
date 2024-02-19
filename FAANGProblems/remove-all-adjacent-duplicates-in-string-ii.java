class Pair{
    char ch;
    int freq;
    public Pair(char ch,int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) { // "deeedbbcccbdaa"
        Stack<Pair> stack = new Stack<>(); // [a-1][b-1][c-1][d-1]
        for(int i=0;i<s.length();++i){
            char ch = s.charAt(i); // a
            if(stack.isEmpty()){
                stack.push(new Pair(ch,1));
            }else{
                Pair p = stack.peek();
                if(p.ch==ch){
                     if(p.freq==k-1){ 
                         int x = k-1; 
                      while(!stack.isEmpty() && x>0){
                         stack.pop();
                         x--;
                      }
                     } 
                     else{
                        stack.push(new Pair(ch,p.freq+1));
                    }
                }else{
                    stack.push(new Pair(ch,1));
                } 
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
           int freq3 = stack.peek().freq;
           while(freq3>0){
                 sb.insert(0,stack.pop().ch);
                 freq3--;
           } 
        }
        return sb.toString();
    }
}

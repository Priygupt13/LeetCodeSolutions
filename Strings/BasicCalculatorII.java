class Solution {
    // Tc : O(n)
    // SC : O(n)
    public int calculate(String s) {
     // Stack<Integer> stack = new Stack<>();
      if(s==null || s.isEmpty()) return 0;
      int curr = 0;
      char operator = '+';
      int sum = 0;
      int last = 0;
      // 3 + 2 - 1 * 3
      for(int i=0;i<s.length();++i){
          char ch = s.charAt(i); // 3
        if(Character.isDigit(ch)){
             curr = 0;
            while(i<s.length() && Character.isDigit(s.charAt(i)))
            {
               int val =  s.charAt(i) -'0';
               curr = curr * 10 + val;
               i++;
            } // 3
              i--;
            if(operator=='*'){
                last = last * curr;
               
             }else if(operator=='/'){
                 last = last/curr;
              
             }else if(operator=='-'){
                 sum+= last;
                 last = -curr;
               
             }else if(operator=='+'){
                 sum+= last; // 0
                 last = curr; //
               
             }
         }
        if(!Character.isDigit(ch) && ch!= ' '){
             operator = ch;
        }
      } 
      return sum+=last;
    }
}

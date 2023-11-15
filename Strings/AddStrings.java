
TC : O(max(n+m))
SC : O(max(n+m))
class Solution {
    public String addStrings(String num1, String num2) {
       int i = num1.length()-1;
       int j = num2.length()-1;
       int carry = 0;
       StringBuilder sb = new StringBuilder();
       while(i>=0 || j>=0 || carry>0){ // 1
           int n1 = 0;
           int n2 = 0;
           if(i>=0){
               n1 = num1.charAt(i)-'0';
               i--;
           }
           if(j>=0){
               n2 = num2.charAt(j)-'0';
               j--;
           }
           int num = (n1+n2+carry)%10; // 0,1
           carry = (n1+n2+carry) >=10 ? 1 : 0; // 10+0=10 = 1
           sb.insert(0,num); // 0
       }
       
       return sb.toString();
    }
}

Test Cases :
@Test
public void testAddStrings(){
  Solution solution = new Solution();
   // Test case 1: Basic addition
  String num1  = "45";
  String num2 = "12";
  String expected = "57";
  assertEquals(expected,solution.addStrings(num1,num2));

  //  Test case 2: Addition with carry
   assertEquals("1000", solution.addStrings("555", "445"));

  // Test case 3: Different length inputs
  assertEquals("533",solution.addStrings("456,"77"));

  // Test case 4: One String is empty 
   assertEquals("77",solution.addStrings(","77"));
  
  // Test case 5: Both empty strings
    assertEquals("0", solution.addStrings("", ""));

  //  Test case 6: Large numbers
        assertEquals("1111111111111111111111111111111111111111111111111111111111110", 
                     solution.addStrings("555555555555555555555555555555555555555555555555555555555555", 
                                        "555555555555555555555555555555555555555555555555555555555555"));

}
  

  

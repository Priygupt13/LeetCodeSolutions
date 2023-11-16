TC : O(log(num))
SC : O(log(num))  
class Solution {
    public int maximumSwap(int num) { // 9973
        int[] lastIndices = new int[10];
        int countDigits = 0;
        int number = num;
        // log(num)
        while(number > 0){
            number  = number/10;
            countDigits++;
        }
        if(countDigits==1) return num;
        int[] digits = new int[countDigits];
        int position = digits.length-1;
        // log(num)
        for(int i = position;i>=0;--i){
            int rem = num%10;
            digits[i] = rem;
            num = num/10;
        }
        for(int j=0;j<digits.length;++j){
            lastIndices[digits[j]] = j;
        }
        for(int i=0;i<digits.length;++i){
            int digit = digits[i];
            for(int x = 9;x>digit;--x){
                if(lastIndices[x]>i){
                    swap(i,lastIndices[x],digits);
                    return getNumberFromArray(digits);
                }
            }
        }
        return getNumberFromArray(digits);
    }

    void swap(int index1,int index2,int[] digits){
        int temp = digits[index1];
        digits[index1] = digits[index2];
        digits[index2] = temp;
    }
    int getNumberFromArray(int[] digits){
        int result = 0;
        for(int i=0;i<digits.length;++i){
            result = result*10+digits[i];
        }
        return result;
    }
}


@Test
    public void testMaximumSwap() {
    // test case 1 : when single digit
    Solution solution = new Solution();
    assertEquals(1,solution.maximumSwap(1));

    // Test case 2:  with two digits, no swap needed
     assertEquals(98,solution.maximumSwap(98));
  
    // Test case 2:  with two digits,  swap needed
   assertEquals(89,solution.maximumSwap(89));

   // Test case with the maximum possible value (10^5), no swap needed
      assertEquals(100000, solution.maximumSwap(100000));
  
    }

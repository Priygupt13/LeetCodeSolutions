https://leetcode.com/problems/simplify-path/
TC :  O(n)
SC :  O(1)  
class Solution {
    public String simplifyPath(String path) {
      String[] str = path.split("/");
      StringBuilder sb = new StringBuilder();
      int skipCount = 0;
      for(int i=str.length-1;i>=0;--i){
            String component = str[i];
            if(component.isEmpty() || component.equals(".")) continue;
            else if(component.equals("..")){
               skipCount++;
            }else if(skipCount>0){
                skipCount--;
            }else{
                sb.insert(0,"/"+component);
            }
      } 
      return sb.length()==0 ? "/": sb.toString();
    }
}
TC :  O(n)
SC :  O(n)  
class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
      Stack<String> stack = new Stack<>();
      for(int i=0;i<str.length;++i){
             if(str[i].length()==0 || str[i].equals(".")){
                 continue;
             }else if(str[i].equals("..")){
                 if(!stack.isEmpty()) stack.pop();
             }else {
                 stack.push(str[i]);
             }
      } 
      StringBuilder result = new StringBuilder();
      for(String str1 : stack){
          result.append("/");
          result.append(str1);
      }
     if(stack.isEmpty()) return "/";
     else return result.toString();
    }
}

// Test cases
import static org.junit.Assert.*;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSimplifyPath() {
        Solution solution = new Solution();

        // Test case 1: Basic path simplification
        String path1 = "/a/./b/../../c/";
        assertEquals("/c", solution.simplifyPath(path1));

        // Test case 2: Path with consecutive slashes
        String path2 = "/a//b/";
        assertEquals("/a/b", solution.simplifyPath(path2));

        // Test case 3: Path with multiple consecutive dots
        String path3 = "/a/b/././c";
        assertEquals("/a/b/c", solution.simplifyPath(path3));

        // Test case 4: Path with ".." in the middle
        String path4 = "/a/b/../c";
        assertEquals("/a/c", solution.simplifyPath(path4));

        // Test case 5: Path with leading ".."
        String path5 = "/../a/b/c";
        assertEquals("/a/b/c", solution.simplifyPath(path5));

        // Test case 6: Path with trailing ".."
        String path6 = "/a/b/c/..";
        assertEquals("/a/b", solution.simplifyPath(path6));

        // Test case 7: Empty path
        String path7 = "";
        assertEquals("/", solution.simplifyPath(path7));

        // Test case 8: Path with a single dot
        String path8 = ".";
        assertEquals("/", solution.simplifyPath(path8));

        // Test case 9: Path with single dot and slash
        String path9 = "./";
        assertEquals("/", solution.simplifyPath(path9));

      // Test case 10: Path with trailing slash
       String path10 = "/a/b/c/";
       assertEquals("/a/b/c",solution.simplifyPath(path10));
    }
}


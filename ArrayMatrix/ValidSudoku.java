https://leetcode.com/problems/valid-sudoku/description/
TC : O(1)
SC : O(1)  
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;++i){
            HashSet<Character> set = new HashSet<Character>();
            for(int j=0;j<9;++j){
                if(!isValid(set,board[i][j])) return false;
            }
        }
        for(int i=0;i<9;++i){
            HashSet<Character> set = new HashSet<Character>();
            for(int j=0;j<9;++j){
                if(!isValid(set,board[j][i])) return false;
            }
        }
        return checkBoxes(board,0,0) && checkBoxes(board,0,3) && checkBoxes(board,0,6) &&
               checkBoxes(board,3,0) && checkBoxes(board,3,3) && checkBoxes(board,3,6) &&
               checkBoxes(board,6,0) && checkBoxes(board,6,3) && checkBoxes(board,6,6);
       
    }

     public boolean checkBoxes(char[][] board,int iStart, int jStart){
        HashSet<Character> set = new HashSet<>();
         for(int i=iStart;i<iStart+3;++i){
             for(int j=jStart;j<jStart+3;++j){
                 if(!isValid(set,board[i][j])) return false;
             }
         }   
        return true;
    }
     public boolean isValid(HashSet<Character> set, char ch){
            return ch=='.' || set.add(ch);
     }
}

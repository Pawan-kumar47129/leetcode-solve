class Solution {
    boolean isSafe(int row,int col,char ch,char[][]board){
        //check row
        for(int j=0;j<9;j++){
            if(board[row][j]==ch) return false;
        }
        //col 
        for(int i=0;i<9;i++){
            if(board[i][col]==ch) return false;
        }
        // 3*3 matrix
        int topRow=(row/3)*3;
        int topCol=(col/3)*3;
        for(int i=topRow;i<topRow+3;i++){
            for(int j=topCol;j<topCol+3;j++){
                if(board[i][j]==ch) return false;
            }
        }
        return true;

    }
    boolean solve(int row,int col,char[][]board){
        if(row == 8 && col == 9){
            return true;
        }
        if(col == 9) {
            row=row+1;
            col=0;
        }
        if(board[row][col] !='.') return solve(row,col+1,board);
        
        for(char ch='1';ch<='9';ch++){
            if(isSafe(row,col,ch,board)){
                board[row][col]=ch;
                if(solve(row,col+1,board))return true;
                board[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }

    
}
class Solution:                        
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        def isValid(row: int, col: int) -> bool:
            # check row
            for j in range(9):
                if board[row][j] == board[row][col] and j != col:
                    return False

            # check column
            for i in range(9):
                if board[i][col] == board[row][col] and i != row:
                    return False 

            # check 3x3 small box
            b_row = (row // 3) * 3
            b_col = (col // 3) * 3
            for i in range(b_row, b_row + 3):
                for j in range(b_col, b_col + 3):
                    if board[i][j] == board[row][col] and (i != row or j != col):
                        return False

            return True
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                if not isValid(i, j):
                    return False
        return True               
        
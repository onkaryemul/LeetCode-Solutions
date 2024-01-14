class Solution {
    
    // helper function -> dfs function
    private void dfs(char[][] board, int rows, int columns, int i, int j) {
        // Base case
        if(i < 0 || i >= rows || j < 0 || j >= columns || board[i][j] != 'X') {
            return;
        }
        
        board[i][j] = '*';
        
        dfs(board, rows, columns, i-1, j); // up
        dfs(board, rows, columns, i, j+1); // right
        dfs(board, rows, columns, i+1, j); // down
        dfs(board, rows, columns, i, j-1); // left
    }
    
    
    public int countBattleships(char[][] board) {
        int battleships = 0;
        
        int rows = board.length; // no. of rows
        int columns = board[0].length; // no. of columns
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(board[i][j] == 'X') {
                    battleships++;
                    dfs(board, rows, columns, i, j);
                }
            }
        }
        
        return battleships;
    }
    
}


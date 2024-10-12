class Solution {
     
    // TC : O(n) => n = no. of moves played => max 9
    // SC : O(3*3) = O(9) ~ O(1)
    
    // Using Simple Simulation
    
    public String tictactoe(int[][] moves) {
        int n = moves.length; // no. of moves => max 9
        
        // Make a 2D board
        char[][] board = new char[3][3];
        // fill the board with '.' => indicating empty cell
        for(int i=0; i < 3; i++) {
            for(int j=0; j < 3; j++) {
                board[i][j] = '.';
            }    
        }
         
        // Initialize board
        // fill the board with the moves played by players 
        // Player A => plays always first    => places 'X' character
        // Player B => plays after player A  => places 'O' character
        
        // moves => 0, 2, 4, .., => played by Player A  => move no. is even
        // moves => 1, 3, 5, .., => played by Player B  => move no. is odd
        
        for(int i=0; i < n; i++) { // iterate from 0th move to (n-1)th move
            // Check if the ith move is even => then player A will play
            if(i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = 'X';
            }
            // otherwise, the ith move is odd => then player B will play
            else {
                board[moves[i][0]][moves[i][1]] = 'O';
            }
        }
        
        // call findResult() to know who wins the game, or it is draw or pending
        return findResult(board, moves);
    }
    
    
    // helper function => to find the result for tic-toe-game
    private String findResult(char[][] board, int[][] moves) {
        // 1. Check who wins the game (A or B)
        // 1.a => Check all columns
        for(int j=0; j < 3; j++) {
            int cntA = 0;
            int cntB = 0;
            
            for(int i=0; i < 3; i++) {
                if(board[i][j] == 'X') {
                    cntA++;
                }
                else if(board[i][j] == 'O') {
                    cntB++;
                }
            }
            
            if(cntA == 3) {
                return "A";
            }
            
            if(cntB == 3) {
                return "B";
            }
        }
        
        
        // 1.b => check all rows
        for(int i=0; i < 3; i++) {
            int cntA = 0;
            int cntB = 0;
            
            for(int j=0; j < 3; j++) {
                if(board[i][j] == 'X') {
                    cntA++;
                }
                else if(board[i][j] == 'O') {
                    cntB++;
                }
            }
            
            if(cntA == 3) {
                return "A";
            }
            
            if(cntB == 3) {
                return "B";
            }
        }
        
        // 1.c => Check in left diagonal
        if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            return "A";
        }
        
        if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            return "B";
        }
        
        // 1.d => Check right diagonal
        if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            return "A";
        }
        
        if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
            return "B";
        }
        
        // 2. Decide whether it is draw or pending
        // Pending => when no. of moves played is less than 9
        // Draw => when no. of moves played = 9
        
        return moves.length == 9 ? "Draw" : "Pending";
    }
    
}


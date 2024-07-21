class Solution {
    
    // TC : O(1)
    // SC : O(1)
    
    // Simple Math Simulation
    public String losingPlayer(int x, int y) {
        int completeTurns = Math.min(x, y/4);
        
        if(completeTurns % 2 == 1) { // odd
            return "Alice";
        }
        
        return "Bob";
    }
    
}


/* 
1. The only way to make 115 is to use one coin of value 75 and four coins of value 10. 
Each turn uses up these many coins.
2. Hence the number of turns is min(x, y / 4).
3. Determine the winner based on number of turns.
*/


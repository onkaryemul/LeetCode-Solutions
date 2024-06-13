class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length; // n = students.length
        
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int moves = 0;
        
        for(int i=0; i < n; i++) {
            moves = moves + Math.abs(seats[i] - students[i]);
        }
        
        return moves;
    }
    
}


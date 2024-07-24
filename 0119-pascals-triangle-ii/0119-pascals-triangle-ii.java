class Solution {
    
    // TC : O(n)
    // SC : O(n), for returning the list of integer for required row of Pascal's triangle
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        
        long ans = 1;
        int row = rowIndex + 1;
        
        for(int col=1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        
        return ansRow;
    }
    
}


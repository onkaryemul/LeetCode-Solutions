class Solution {
    
    // TC : O(n^2)
    // SC : O(n^2), for the arraylist that we are returning
    
    // Store the entire Pascal's triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int row=1; row <= numRows; row++) {
            ans.add(generateRow(row));
        }
        
        return ans;
    }
    

    private List<Integer> generateRow(int row) {
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // inserting the 1st element
        
        long ans = 1;
        
        // Calculate the rest of the elements
        for(int col=1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        
        return ansRow;
    }
    
}


/* 
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }
*/


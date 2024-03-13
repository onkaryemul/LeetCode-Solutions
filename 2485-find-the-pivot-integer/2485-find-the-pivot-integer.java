class Solution {
    
    public int pivotInteger(int n) {
        // Base case
        if(n == 1) {
            return n;
        }
        
        int leftValue = 1;
        int rightValue = n;
        
        int sumLeft = leftValue;
        int sumRight = rightValue;
        
        while(leftValue < rightValue) {
            if(sumLeft < sumRight) {
                leftValue++;
                sumLeft += leftValue;
            }
            else {
                rightValue--;
                sumRight += rightValue;
            }
            
            if(sumLeft == sumRight && (leftValue + 1) == (rightValue - 1)){
                return leftValue + 1; // returning pivot integer
            }
        }
        
        return -1;
    }
    
}


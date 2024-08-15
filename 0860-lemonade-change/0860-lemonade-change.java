class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Simple Simulation
    
    // Function to find whether each customer can be provided with correct change
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        
        int five = 0;
        int ten = 0;
        
        for(int bill : bills) {
            if(bill == 5) {
                five++;
            }
            else if(bill == 10) {
                if(five > 0) {
                    five--;
                    ten++;
                }
                else {
                    return false;
                }
            }
            else { // bill == 20
                if(five > 0 && ten > 0) {
                    five--;
                    ten--;
                }
                else if(five >= 3) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}


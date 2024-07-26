class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Function to find whether each customer can be provided with correct change
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length; // no. of customers
        
        int five = 0; // counter for $5 bills
        int ten = 0; // counter for $10 bills
        
        for(int i=0; i < n; i++) { // iterate through each customer's bill
            // 1. If the customer's bill is $5
            if(bills[i] == 5) {
                five++; // increment the count of $5 bills
            }
            // 2. If the customer's bill is $10
            else if(bills[i] == 10) {
                // Check if there are $5 bills available to given change
                if(five > 0) {
                    five--; // use one $5 bill to give change
                    ten++; // receive one $10 bill
                }
                else { // if no $5 bill available, then return false
                    return false; 
                }
            }
            // 3. If the customer's bill is $20
            else {
                // Check if there are both $5 and $10 bills availabel to give change
                if(five > 0 && ten > 0) {
                    five--; // use one $5 bill
                    ten--; // use one $10 bill
                }
                // If there are not enough $10 bills,
                // Check if there are at least three $5 bills available
                else if (five >= 3) {
                    five -= 3; // use three $5 bills to give change
                } 
                else { // if unable to give change, return false
                    return false;
                }
            }
        
        }
        
        // Return true, if all customers are served with correct change
        return true;
    }
    
}


class Solution {
    
    
    // Main algorithm code 
    // TC : O(n) & SC : O(n)
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        
        int len = arr.length;
        
        int[] leftNextSmaller = findLeftNextSmaller(arr, len);
        int[] rightNextSmaller = findRightNextSmaller(arr, len);
        
        long totalSum = 0;
        
        // O(n)
        for(int i=0; i<len; i++) {
            long leftDistance = i - leftNextSmaller[i];
            long rightDistance = rightNextSmaller[i] - i;
            
            long totalWays = leftDistance * rightDistance;
            
            long currentSum = totalWays * arr[i];
            
            totalSum = (totalSum + currentSum) % mod;
        }
        
        
        return (int)totalSum;
    }
    
    
    // helper function to find the left next smaller element index
    private int[] findLeftNextSmaller(int[] arr, int len) {
        int[] result = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        
        // O(n)
        for(int i=0; i<len; i++) {
            
            if(stack.isEmpty()) {
                result[i] = -1;
            } 
            else {
                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                result[i] = (!stack.isEmpty()) ? stack.peek() : -1;
            }
            
            stack.push(i);
        }
        
        return result;
    }
    
    
    // helper function to find the right next smaller element index
    private int[] findRightNextSmaller(int[] arr, int len) {
        int[] result = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        
        // O(n)
        for(int i=len-1; i>=0; i--) {
            
            if(stack.isEmpty()) {
                result[i] = len;
            }
            else {
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                result[i] = (!stack.isEmpty()) ? stack.peek() : len;
            }
            
            stack.push(i);
        }
        
        return result;
    }
    
}



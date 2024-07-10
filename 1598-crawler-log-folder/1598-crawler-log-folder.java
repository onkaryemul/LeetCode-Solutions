class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Simple Simulation
    public int minOperations(String[] logs) {
        int depth = 0;
        
        for(String log : logs) {
            if(log.equals("../")) {
                depth = Math.max(0, depth-1);
            }
            else if(!log.equals("./")) {
                depth++;
            }
        }
        
        return depth;
    }
    
}


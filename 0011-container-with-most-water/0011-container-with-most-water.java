class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Two-pointers Greedy approach 
    public int maxArea(int[] height) {
        int n = height.length;
        
        int i = 0, j = n-1;
        int maxWater = 0;
        
        while(i < j) {
            int h = Math.min(height[i], height[j]);
            int w = j-i;
            
            int area = h*w;
            
            maxWater = Math.max(maxWater, area);
            
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return maxWater;
    }
    
}


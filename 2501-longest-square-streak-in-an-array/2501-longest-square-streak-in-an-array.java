class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    public int longestSquareStreak(int[] nums) {
        // 1. Using HashSet to store nums[] elements
        HashSet<Integer> uniques = new HashSet<>();
        
        for(int num : nums) {
            uniques.add(num);
        }
        
        int maxSquareStreak = 1;
        
        for(int num : uniques) {
            int sqrt = (int)Math.sqrt(num);
            
            // Check if the square root of current number exists, then this is not an starting number of the subsequence, hence we can skip
            if(sqrt * sqrt == num && uniques.contains(sqrt)) {
                continue;
            }
            
            // current num is starting number of the subsequence, which each element is square of the previous number
            int currStreak = 1;
            
            while(num < 1000 && uniques.contains(num * num)) {
                currStreak++;
                num *= num;
            }
            
            maxSquareStreak = Math.max(maxSquareStreak, currStreak);
        }
        
        
        // the length of the subsequence is "at least 2"
        return maxSquareStreak == 1 ? -1 : maxSquareStreak;
    }
    
}


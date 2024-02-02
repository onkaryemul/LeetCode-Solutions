class Solution {
    
    // TC : O(1)
    // SC : O(1)
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        int len = digits.length();
        
        List<Integer> result = new ArrayList<>();
        
        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();
        
        // Sliding Window 
        for(int left = lowLength; left <= highLength; left++) 
        {
            for(int right = 0; right <= len - left; right++) 
            {
                String seqString = digits.substring(right, right + left);
                int num = Integer.parseInt(seqString);
                
                if(num >= low && num <= high) {
                    result.add(num);
                }
                
                // for avoiding unnecessary comparisons of larger number
                if(num > high) {
                    break;
                }
            }
            
        }
        
        
        return result;
    }
    
}


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Optimized approach ==> Single Pass solution
    
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        
        for(int ele : arr) {
            if(seenNumbers.contains(2 * ele) || (ele % 2 == 0 && seenNumbers.contains(ele / 2))) {
                return true;
            }
            
            seenNumbers.add(ele);
        }
        
        return false;
    }
    
}

